package com.tripp.uxteam.tripp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LoaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaderFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public LoaderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment LoaderFragment.
     */
    public static LoaderFragment newInstance(String param1) {
        LoaderFragment fragment = new LoaderFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                changeFragment();
            }
        }, 3000);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loader_screen, container, false);
    }

    private void changeFragment() {
        Fragment fragment = YouGotCity.newInstance(this.mParam1);
        FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(this).commit();
        fragmentManager.popBackStack();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment, "ABOUT_FRAGMENT").addToBackStack("ABOUT_FRAGMENT");
        fragmentTransaction.commit();
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
