package com.tripp.uxteam.tripp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * a costume number picker element
 */
public class MyNumberPicker extends NumberPicker {
    /**
     * Create a new number picker.
     *
     * @param context The application environment.
     */
    public MyNumberPicker(Context context) {
        super(context);
    }

    /**
     * Create a new number picker.
     *
     * @param context The application environment.
     * @param attrs   A collection of attributes.
     */
    public MyNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    private void updateView(View view) {
        // here we change the font and the size of the picker
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.raleway_medium);
        if(view instanceof EditText) {
            ((EditText) view).setTextSize(25);
//            ((EditText) view).setTypeface(typeface);
        }
    }

}
