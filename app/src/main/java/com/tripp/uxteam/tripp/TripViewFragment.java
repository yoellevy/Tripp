package com.tripp.uxteam.tripp;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


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
    ArrayList<String> attractions;

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
        int resID = getResources().getIdentifier("summery_" + name,
                "drawable", getActivity().getPackageName());
        btn.setBackgroundResource(resID);
        btn.setContentDescription(name);
        btn.setId(idx); // use for constraint
        btn.setOnClickListener(new View.OnClickListener() {
            String btn_name = name;

            @Override
            public void onClick(View view) {
                View parent = view.getRootView();
                ImageView tripview_background = parent.findViewById(R.id.tripview_background);
                int resID = getResources().getIdentifier("new_sitemap_" + btn_name,
                        "drawable", getActivity().getPackageName());
                tripview_background.setImageResource(resID);
                android.support.v4.widget.DrawerLayout mDrawerLayout = parent.findViewById(R.id.drawer_layout);
                current_attraction_idx = attractions.indexOf(btn_name);
                mDrawerLayout.closeDrawers();
            }
        });
        nav_layout.addView(btn);
    }


    private void createMockAttractions() {
        attractions = new ArrayList<>();
        attractions.add("eiffel_tower");
        attractions.add("seine_river");
        attractions.add("saint_chapelle");
        attractions.add("notre_dame");
        attractions.add("lafayette_gourmet");
        attractions.add("the_louvre");
        attractions.add("versailles");
        attractions.add("matamata_coffee");
        attractions.add("musee_dorsay");
        attractions.add("berthillon_glaciet");//
        attractions.add("arc_de_triomphe");
        attractions.add("jadis_pub");//
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_view, null);

        mDrawerLayout = view.findViewById(R.id.drawer_layout);
        nav_view = view.findViewById(R.id.nav_view);
        this.createMockAttractions();
        openDrawer();
        ((ImageView) view.findViewById(R.id.drawer_handle_circle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer();
            }
        });
        int idx = 1;
        for (String name : attractions
                ) {
            addSiteToTrip(idx++, name);
        }

        return view;
    }


    /**
     * function to show next attraction
     */
    public void next_slide() {
        if (current_attraction_idx == attractions.size() - 1)
            return;

        ImageView tripview_background = view.findViewById(R.id.tripview_background);
        int resID = getResources().getIdentifier("new_sitemap_" + attractions.get(++current_attraction_idx),
                "drawable", getActivity().getPackageName());
        tripview_background.setImageResource(resID);
    }

    /**
     * change attraction to previous attraction
     */
    public void previous_slide() {
        if (current_attraction_idx == 0)
            return;

        ImageView tripview_background = view.findViewById(R.id.tripview_background);
        int resID = getResources().getIdentifier("new_sitemap_" + attractions.get(--current_attraction_idx),
                "drawable", getActivity().getPackageName());
        tripview_background.setImageResource(resID);
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
