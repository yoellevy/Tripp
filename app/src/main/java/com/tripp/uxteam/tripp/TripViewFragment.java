package com.tripp.uxteam.tripp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TripViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TripViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripViewFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public TripViewFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TripViewFragment.
     */
    // TODO: Rename and change types and number of parameters
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

    public void addSiteToTrip(View view, int idx) {
        ConstraintLayout nav_layout = view.findViewById(R.id.nav_constraint_layout);
        Button btn = new Button(getActivity());
        btn.setText(String.valueOf(idx));
        ConstraintLayout.LayoutParams layout_param = new ConstraintLayout.LayoutParams(250, 250);
        layout_param.setMargins(50, 50, 0, 0);
        if (idx > 3)
            layout_param.topToBottom = (idx - 3);
        if (idx % 3 != 1)
            layout_param.leftToRight = idx - 1;
        btn.setLayoutParams(layout_param);
        btn.setBackgroundResource(R.drawable.circle_shape);
        btn.setId(idx);
        nav_layout.addView(btn);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trip_view, container, false);
        for (int i = 1; i < 30; i++)
            addSiteToTrip(view, i);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
