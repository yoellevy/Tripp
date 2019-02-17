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
public class StaticImageFragment extends BaseFragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String IMG_TO_LOAD = "param1";
    private static final String FRAGMENT_TO_PASS_TO = "param2";

    @Override
    boolean onBack() {
        return false;
    }

    public enum FRAGMENTS {
        ABOUT_YOURSELF("ABOUT_YOURSELF"),
        TRIP_TYPE("TRIP_TYPE");
        private final String text;

        /**
         * @param text
         */
        FRAGMENTS(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    enum IMAGES {
        static_img_background_img("static_img_background_img"),
        now_we_know_you_better("now_we_know_you_better"),
        welcome_back("welcome_back");

        private final String text;

        /**
         * @param text
         */
        IMAGES(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    private String imgToLoad;
    private String fragmentToPassTo;

    private boolean passedToNextFragment = false;

//    private OnFragmentInteractionListener mListener;

    public StaticImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param imgToLoad        Parameter 1.
     * @param fragmentToPassTo Parameter 2.
     * @return A new instance of fragment StaticImageFragment.
     */
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
            imgToLoad = getArguments().getString(IMG_TO_LOAD);
            fragmentToPassTo = getArguments().getString(FRAGMENT_TO_PASS_TO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_static_image, container, false);
        ImageView backgroundImg = view.findViewById(R.id.static_img_background_img);
        backgroundImg.setBackgroundResource(enumToId());
        backgroundImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                changeFragment();
            }
        }, 3000);

        return view;
    }

    /**
     * we can do this only here because it's after inflation.
     * @return the id of the image in R
     */
    private int enumToId(){
        if (this.imgToLoad.equals(IMAGES.static_img_background_img.toString()))
        { return R.drawable.after_sign_up; }
        else if (this.imgToLoad.equals(IMAGES.now_we_know_you_better.toString()))
        { return R.drawable.now_we_know_you_better; }
        else if(this.imgToLoad.equals(IMAGES.welcome_back.toString()))
        { return R.drawable.welcome_back; }

        return R.id.static_img_background_img;
    }




    private void changeFragment(){
        if (!passedToNextFragment) {
            passedToNextFragment = true;
            Fragment fragment = AboutYourselfFragment.newInstance();
            String fragmentName = "";
            if (this.fragmentToPassTo.equals(FRAGMENTS.ABOUT_YOURSELF.toString())) {
                fragment = AboutYourselfFragment.newInstance();
            } else if (this.fragmentToPassTo.equals(FRAGMENTS.TRIP_TYPE.toString())) {
                fragment = SelectDaysAndTypeFragment.newInstance();
            }

            FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(this).commit();
            fragmentManager.popBackStack();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment, fragmentName).addToBackStack(fragmentName);
            fragmentTransaction.commit();
        }
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
