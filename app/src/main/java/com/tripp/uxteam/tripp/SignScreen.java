package com.tripp.uxteam.tripp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SignScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignScreen extends BaseFragment {

    public SignScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SignScreen.
     */
    public static SignScreen newInstance() {
        SignScreen fragment = new SignScreen();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sign_screen, container, false);
        Button button = view.findViewById(R.id.signup_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StaticImageFragment fragment = StaticImageFragment.newInstance(
                        StaticImageFragment.IMAGES.static_img_background_img.toString(),
                        StaticImageFragment.FRAGMENTS.ABOUT_YOURSELF.toString());

                FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, fragment, "ABOUT_FRAGMENT").addToBackStack("ABOUT_FRAGMENT");
                fragmentTransaction.commit();
            }
        });

        button = view.findViewById(R.id.login_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDaysAndTypeFragment fragment = SelectDaysAndTypeFragment.newInstance();
                FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, fragment, "FETCH_TRIP_FRAGMENT").addToBackStack("FETCH_TRIP_FRAGMENT");
                fragmentTransaction.commit();
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
