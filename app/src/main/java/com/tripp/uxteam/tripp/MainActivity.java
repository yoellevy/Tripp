package com.tripp.uxteam.tripp;


import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance = null;
    private GestureDetectorCompat mDetector;

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
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

    }


    @Override
    public void onBackPressed() {

        AboutYourselfFragment about_fragment = (AboutYourselfFragment) fragmentManager.findFragmentByTag("ABOUT_FRAGMENT");
        if (about_fragment != null && about_fragment.isVisible()) {
            about_fragment.OnBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event)
//    {
//        TripViewFragment trip_view_fragment = (TripViewFragment)getSupportFragmentManager().findFragmentByTag("TRIP_VIEW_FRAGMENT");
//        if (trip_view_fragment != null && trip_view_fragment.isVisible()) {
//            trip_view_fragment.onTouch(event);
////            return true;
//        }
//        return super.dispatchTouchEvent(event);
//    }


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
//            Log.d(DEBUG_TAG, "onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            try {
                TripViewFragment trip_view_fragment = (TripViewFragment) fragmentManager.findFragmentByTag("TRIP_VIEW_FRAGMENT");
                trip_view_fragment.onFling(velocityX, velocityY);

            } catch (Exception e) {
                return true;
            }

            Log.d(DEBUG_TAG, "onFling: " + String.valueOf(velocityX) + " " + String.valueOf(velocityY));
            return true;
        }
    }


}
