package com.tripp.uxteam.tripp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TripViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TripViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TripViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TripViewFragment newInstance(String param1, String param2) {
        TripViewFragment fragment = new TripViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public void addSiteToTrip(View view, int idx, final String name) {
        ConstraintLayout nav_layout = view.findViewById(R.id.nav_constraint_layout);
        final Button btn = new Button(getActivity());
//        btn.setText(String.valueOf(idx));
        ConstraintLayout.LayoutParams layout_param = new ConstraintLayout.LayoutParams(250, 289);
        layout_param.setMargins(50, 50, 0, 0);
        if (idx > 3)
            layout_param.topToBottom = (idx - 3);
        else layout_param.topToBottom = R.id.sub_trip_sum_title;
        if (idx % 3 != 1)
            layout_param.leftToRight = idx - 1;
        btn.setLayoutParams(layout_param);
        int resID = getResources().getIdentifier("summery_" + name,
                "drawable", getActivity().getPackageName());
        btn.setBackgroundResource(resID);
        btn.setContentDescription(name);
        btn.setId(idx);
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

    View view;
    ArrayList<String> attractions;

    int prev_attraction_idx = -1;
    int current_attraction_idx = 0;

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
        attractions.add("berthillon_glaciet");
        attractions.add("arc_de_triomphe");
        attractions.add("jadis_pub");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trip_view, container, false);



        this.createMockAttractions();

        int idx = 1;
        for (String name : attractions
                ) {
            addSiteToTrip(view, idx++, name);
        }

        return view;
    }


    public void next_slide() {
        if (current_attraction_idx == attractions.size() - 1)
            return;

        ImageView tripview_background = view.findViewById(R.id.tripview_background);
        int resID = getResources().getIdentifier("new_sitemap_" + attractions.get(++current_attraction_idx),
                "drawable", getActivity().getPackageName());
        tripview_background.setImageResource(resID);
    }

    public void previus_slide() {
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

}
