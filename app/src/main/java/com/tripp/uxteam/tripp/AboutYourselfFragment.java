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
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutYourselfFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutYourselfFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutYourselfFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    static int QuestionsAnswered = 0;

    public AboutYourselfFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AboutYourselfFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutYourselfFragment newInstance() {
        AboutYourselfFragment fragment = new AboutYourselfFragment();
        Bundle args = new Bundle();
        QuestionsAnswered = 0;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    View view;

    void setNextQuestion() {
        ImageView title_img = view.findViewById(R.id.about_title);
        Button img_rightTop = view.findViewById(R.id.img_right_top);
        Button img_leftTop = view.findViewById(R.id.img_left_top);
        Button img_rightBottm = view.findViewById(R.id.img_right_bottom);
        Button img_leftBottom = view.findViewById(R.id.img_left_bottom);

        if (QuestionsAnswered == 1) {
            title_img.setImageResource(R.drawable.title_two);
            img_rightTop.setBackgroundResource(R.drawable.answer_frame_sites);
            img_leftTop.setBackgroundResource(R.drawable.answer_frame_shopping);
            img_rightBottm.setBackgroundResource(R.drawable.answer_frame_pool);
            img_leftBottom.setBackgroundResource(R.drawable.answer_frame_coffee);
        } else if (QuestionsAnswered == 2) {
            title_img.setImageResource(R.drawable.title_three);
            img_rightTop.setBackgroundResource(R.drawable.answer_frame_party);
            img_leftTop.setBackgroundResource(R.drawable.answer_frame_bed);
            img_rightBottm.setBackgroundResource(R.drawable.answer_frame_food);
            img_leftBottom.setBackgroundResource(R.drawable.answer_frame_bar);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_yourself, container, false);
        Button img_rightTop = view.findViewById(R.id.img_right_top);
        Button img_leftTop = view.findViewById(R.id.img_left_top);
        Button img_rightBottm = view.findViewById(R.id.img_right_bottom);
        Button img_leftBottom = view.findViewById(R.id.img_left_bottom);

        Button[] img_arr = new Button[]{img_rightTop, img_leftTop, img_rightBottm, img_leftBottom};
        int i = 0;
        for (Button img_button :
                img_arr) {
            img_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (QuestionsAnswered < 2) {
                        QuestionsAnswered++;
                        setNextQuestion();
                        return;
                    }

                    SelectDaysAndTypeFragment fragment = SelectDaysAndTypeFragment.newInstance();
                    FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            });
            i++;
        }

        return view;
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
