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
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AboutYourselfFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutYourselfFragment extends BaseFragment {

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

    /**
     * set Images source using known ids
     *
     * @param title_id the id of the title source image
     * @param img_id1  first answer ids source
     * @param img_id2  second answer ids source
     * @param img_id3  third answer ids source
     * @param img_id4  fourth answer ids source
     */
    void set_answers_background(int title_id, int img_id1, int img_id2, int img_id3, int img_id4) {
        ImageView title_img = view.findViewById(R.id.about_title);
        Button img_rightTop = view.findViewById(R.id.img_right_top);
        Button img_leftTop = view.findViewById(R.id.img_left_top);
        Button img_rightBottm = view.findViewById(R.id.img_right_bottom);
        Button img_leftBottom = view.findViewById(R.id.img_left_bottom);

        title_img.setImageResource(title_id);
        img_rightTop.setBackgroundResource(img_id1);
        img_leftTop.setBackgroundResource(img_id2);
        img_rightBottm.setBackgroundResource(img_id3);
        img_leftBottom.setBackgroundResource(img_id4);
    }

    /**
     * set current question background
     */
    void setQuestion() {

        if (QuestionsAnswered == 0) {
            set_answers_background(R.drawable.title_one,
                    R.drawable.answer_frame_site_seeing,
                    R.drawable.answer_frame_park,
                    R.drawable.answer_frame_art,
                    R.drawable.answer_frame_viewpoints);
        } else if (QuestionsAnswered == 1) {
            set_answers_background(R.drawable.title_two,
                    R.drawable.answer_frame_sites,
                    R.drawable.answer_frame_shopping,
                    R.drawable.answer_frame_pool,
                    R.drawable.answer_frame_coffee);
        } else if (QuestionsAnswered == 2) {
            set_answers_background(R.drawable.title_three,
                    R.drawable.answer_frame_party,
                    R.drawable.answer_frame_bed,
                    R.drawable.answer_frame_food,
                    R.drawable.answer_frame_bar);
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

                /**
                 * set button onclick action
                 * if the user hasn't answer three question, then advance answered question counter
                 * else move to select days and type fragment
                 * @param view
                 */
                @Override
                public void onClick(View view) {

                    if (QuestionsAnswered < 2) {
                        QuestionsAnswered++;
                        setQuestion();
                        return;
                    }
                    QuestionsAnswered = 0;

                    SelectDaysAndTypeFragment fragment = SelectDaysAndTypeFragment.newInstance();
                    FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragment_container, fragment, "FETCH_TRIP_FRAGMENT").addToBackStack("FETCH_TRIP_FRAGMENT");
                    fragmentTransaction.commit();
                    setQuestion();
                }
            });
            i++;
        }

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
        QuestionsAnswered--;
        if (QuestionsAnswered < 0) {
            QuestionsAnswered = 0;
            return true;
        }
        setQuestion();
        return false;

    }
}
