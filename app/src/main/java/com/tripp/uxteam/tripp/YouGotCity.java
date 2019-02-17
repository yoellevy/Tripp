package com.tripp.uxteam.tripp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link YouGotCity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YouGotCity extends BaseFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public YouGotCity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment YouGotCity.
     */
    public static YouGotCity newInstance(String param1) {
        YouGotCity fragment = new YouGotCity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    private void changeFragment() {

        Fragment fragment = TripViewFragment.newInstance();
        FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(this).commit();
        fragmentManager.popBackStack();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, "TRIP_VIEW_FRAGMENT").addToBackStack("TRIP_VIEW_FRAGMENT");
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_you_got_city, container, false);

        TextView cityNameTextView = view.findViewById(R.id.city_text);
        cityNameTextView.setText(this.mParam1);

        Button view_trip_btn = view.findViewById(R.id.view_trip_btn);
        view_trip_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                changeFragment();
            }
        });

        TextView i_want_something_else_btn = view.findViewById(R.id.i_want_something_else_btn);
        i_want_something_else_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    boolean onBack() {
        return true;
    }
}
