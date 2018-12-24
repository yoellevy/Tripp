package com.tripp.uxteam.tripp;


import android.app.Fragment;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements SignScreen.OnFragmentInteractionListener, AboutYourselfFragment.OnFragmentInteractionListener, TripViewFragment.OnFragmentInteractionListener {

    private static MainActivity instance = null;

    public static MainActivity GetInstance() {
        return instance;
    }

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SignScreen signScreenFragment = SignScreen.newInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, signScreenFragment);
        fragmentTransaction.commit();
        setContentView(R.layout.activity_main);
        instance = this;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {

        AboutYourselfFragment about_fragment = (AboutYourselfFragment)getSupportFragmentManager().findFragmentByTag("ABOUT_FRAGMENT");
        if (about_fragment != null && about_fragment.isVisible()) {
            about_fragment.OnBack();
        } else {
            super.onBackPressed();
        }
    }
}
