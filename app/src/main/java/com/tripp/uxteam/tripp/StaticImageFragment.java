package com.tripp.uxteam.tripp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link StaticImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaticImageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IMG_TO_LOAD = "param1";
    private static final String FRAGMENT_TO_PASS_TO = "param2";
    enum FRAGMENTS {ABOUT_YOURSELF}

    // TODO: Rename and change types of parameters
    private String ImgToLoad;
    private String FragmentToPassTo;

//    private OnFragmentInteractionListener mListener;

    public StaticImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imgToLoad Parameter 1.
     * @param fragmentToPassTo Parameter 2.
     * @return A new instance of fragment StaticImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaticImageFragment newInstance(String imgToLoad, String fragmentToPassTo) {
        StaticImageFragment fragment = new StaticImageFragment();
        Bundle args = new Bundle();
        args.putString(IMG_TO_LOAD, imgToLoad);
        args.putString(FRAGMENT_TO_PASS_TO, fragmentToPassTo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ImgToLoad = getArguments().getString(IMG_TO_LOAD);
            FragmentToPassTo = getArguments().getString(FRAGMENT_TO_PASS_TO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_static_image, container, false);
        ImageView backgroundImg = view.findViewById(R.id.static_img_background_img);

        backgroundImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToAboutFragment();
            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                changeToAboutFragment();
            }
        }, 1500);

        return view;
    }

    private void changeToAboutFragment(){
        AboutYourselfFragment fragment = AboutYourselfFragment.newInstance();
        FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment, null);
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
