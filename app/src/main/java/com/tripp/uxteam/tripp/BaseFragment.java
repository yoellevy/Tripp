package com.tripp.uxteam.tripp;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {
    /**
     * this function need to be implemented and be called when physical back button clicked.
     */
    abstract boolean onBack();
}
