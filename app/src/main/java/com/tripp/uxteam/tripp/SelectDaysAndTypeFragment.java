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
import android.widget.NumberPicker;
import android.widget.ProgressBar;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class SelectDaysAndTypeFragment extends Fragment {

    private ProgressBar spinner;

    public SelectDaysAndTypeFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TripViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectDaysAndTypeFragment newInstance() {

        SelectDaysAndTypeFragment fragment = new SelectDaysAndTypeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_days_and_type, container, false);

        spinner = (ProgressBar) view.findViewById(R.id.progress_bar);
        spinner.setVisibility(View.GONE);

        // here we'll set the values of the number picker element
        NumberPicker timePicker = view.findViewById(R.id.time_length_picker);
        timePicker.setMinValue(1);
        timePicker.setMaxValue(30);

        NumberPicker timeTypePicker = view.findViewById(R.id.time_types_picker);
        timeTypePicker.setMinValue(0);
        timeTypePicker.setMaxValue(2);
        timeTypePicker.setDisplayedValues(getResources().getStringArray(R.array.TIME_TYPES));


        Button fetchBtn = view.findViewById(R.id.fetch_my_trip_btn);
        fetchBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TripViewFragment fragment = TripViewFragment.newInstance();
                FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment,"TRIP_VIEW_FRAGMENT");
                fragmentTransaction.commit();
                spinner.setVisibility(View.VISIBLE);
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

}
