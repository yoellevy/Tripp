package com.tripp.uxteam.tripp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TripViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripViewFragment extends BaseFragment {

    int current_attraction_idx = 0;
    android.support.v4.widget.DrawerLayout mDrawerLayout;
    NavigationView nav_view;
    View view;
    ArrayList<String> attractionsNames;

    public TripViewFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TripViewFragment.
     */
    public static TripViewFragment newInstance() {
        TripViewFragment fragment = new TripViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void renderBackground() {
        ImageView tripview_background = view.findViewById(R.id.tripview_background);
        int resID = getResources().getIdentifier("attraction_" + attractionsNames.get(current_attraction_idx),
                "drawable", getActivity().getPackageName());
        tripview_background.setImageResource(resID);
    }

    void setAttractionText() {
        ((TextView) view.findViewById(R.id.attraction_title)).setText(attractionMap.get(attractionsNames.get(current_attraction_idx)).getName());
        ((TextView) view.findViewById(R.id.description_text)).setText(attractionMap.get(attractionsNames.get(current_attraction_idx)).getShortDescription());
    }

    /**
     * add attraction thumbnail to drawer
     * currently adding mock thumbnail.
     *
     * @param idx  index of current thumbnail to insert
     * @param name name of thumbnail
     */
    public void addSiteToTrip(int idx, final String name) {
        ConstraintLayout nav_layout = view.findViewById(R.id.nav_constraint_layout);
        final Button btn = new Button(getActivity());
        ConstraintLayout.LayoutParams layout_param = new ConstraintLayout.LayoutParams(260, 356);
        layout_param.setMargins(50, 50, 0, 0);
        // each row contains 3 thumbnails, constraint thumb nail top to be under the right thumbnail
        if (idx > 3)
            layout_param.topToBottom = (idx - 3);
        else layout_param.topToBottom = R.id.sub_trip_sum_title;
        // constraint thumbnail left to thr right of prev thumbnail, unless it's the first thumbnail in row
        if (idx % 3 != 1)
            layout_param.leftToRight = idx - 1;
        btn.setLayoutParams(layout_param);
        int resID = getResources().getIdentifier("summary_" + name,
                "drawable", getActivity().getPackageName());
        btn.setBackgroundResource(resID);
        btn.setContentDescription(name);
        btn.setId(idx); // use for constraint
        btn.setOnClickListener(new View.OnClickListener() {
            String btn_name = name;

            @Override
            public void onClick(View view) {
                current_attraction_idx = attractionsNames.indexOf(btn_name);
                renderBackground();
                setAttractionText();
                mDrawerLayout.closeDrawers();
            }
        });
        nav_layout.addView(btn);
    }

    Map<String, Attraction> attractionMap;

    private void createMockAttractions() {
        attractionsNames = new ArrayList<>();
        ArrayList<Attraction> attractions = Globals.currentTrip.getAttractions();
        attractionMap = new ArrayMap<>();

        for (Attraction attraction :
                Globals.currentTrip.getAttractions()) {
            attractionsNames.add(attraction.getAssetName());
            attractionMap.put(attraction.getAssetName(), attraction);
        }
    }

    private void initializeView(View view) {
        mDrawerLayout = view.findViewById(R.id.drawer_layout);
        nav_view = view.findViewById(R.id.nav_view);
        this.createMockAttractions();
        openDrawer();
        //set drawer button functionality to open drawer
        ((ImageView) view.findViewById(R.id.drawer_handle_circle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer();
            }
        });
        int idx = 1;
        for (String name :
                attractionsNames) {
            addSiteToTrip(idx++, name);
        }

        ((TextView) view.findViewById(R.id.sub_trip_sum_title)).setText(Globals.currentTrip.getName());

        ((TextView) view.findViewById(R.id.else_text)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;
                CharSequence toastText = "This feature is not yet supported.";
                Toast toast = Toast.makeText(getContext(), toastText, duration);
                toast.show();
            }
        });
    }

    private void attachGoogleMapsButton(View view) {
        Button googleMapBtn = view.findViewById(R.id.google_maps_button);
        googleMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse(attractionMap.get(attractionsNames.get(current_attraction_idx)).getGoogleMapsUrl());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    private void attachTripadvisorButton(View view) {
        Button googleMapBtn = view.findViewById(R.id.tripadvisors_button);
        googleMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse(attractionMap.get(attractionsNames.get(current_attraction_idx)).getTripAdvisorUrl());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_view, null);

        initializeView(view);

        attachGoogleMapsButton(view);
        attachTripadvisorButton(view);

        renderBackground();

        setAttractionText();
        return view;
    }


    /**
     * function to show next attraction
     */
    public void next_slide() {
        if (current_attraction_idx == attractionsNames.size() - 1)
            return;

        current_attraction_idx++;
        renderBackground();
        setAttractionText();

    }

    /**
     * change attraction to previous attraction
     */
    public void previous_slide() {
        if (current_attraction_idx == 0)
            return;

        current_attraction_idx--;
        renderBackground();
        setAttractionText();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * fling implementation for this fragment, called from main activity
     *
     * @param velocityX
     * @param velocityY
     */
    public void onFling(float velocityX, float velocityY) {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            return;
        }
        if (Math.abs(velocityY) > Math.abs(velocityX)) {
            if (velocityY > 0)
                previous_slide();
            else
                next_slide();
        } else {
            if (velocityX > 0)
                openDrawer();
        }

    }

    public void openDrawer() {
        mDrawerLayout.openDrawer(nav_view);
    }

    @Override
    boolean onBack() {
        return true;
    }
}
