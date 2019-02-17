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

    private double[] firstAnswerVec;
    private double[] secondAnswerVec;
    private double[] thirdAnswerVec;

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
                    R.drawable.answer_frame_hiking);
        } else if (QuestionsAnswered == 1) {
            set_answers_background(R.drawable.title_two,
                    R.drawable.answer_frame_sites,
                    R.drawable.answer_frame_shopping,
                    R.drawable.answer_frame_pool,
                    R.drawable.answer_frame_viewpoints);
        } else if (QuestionsAnswered == 2) {
            set_answers_background(R.drawable.title_three,
                    R.drawable.answer_frame_party,
                    R.drawable.answer_frame_stargazing,
                    R.drawable.answer_frame_food,
                    R.drawable.answer_frame_bar);
        }
    }

    void setQuestionVec(int question, int btnIndex) {
        if (question == 0) {
            switch (btnIndex) {
                case 0:
                    firstAnswerVec = new double[]{0, 0.8, 0.1, 0.1};
                    break;
                case 1:
                    firstAnswerVec = new double[]{1, 0, 0, 0};
                    break;
                case 2:
                    firstAnswerVec = new double[]{0.5, 0.5, 0, 0};
                    break;
                case 3:
                    firstAnswerVec = new double[]{0, 0, 0.1, 0.9};
                    break;
            }
        } else if (question == 1) {
            switch (btnIndex) {
                case 0:
                    secondAnswerVec = new double[]{0, 0.7, 0.3, 0};
                    break;
                case 1:
                    secondAnswerVec = new double[]{1, 0, 0, 0};
                    break;
                case 2:
                    secondAnswerVec = new double[]{0, 1, 0, 0};
                    break;
                case 3:
                    secondAnswerVec = new double[]{0, 0, 0.3, 0.7};
                    break;
            }

        } else if (question == 2) {
            switch (btnIndex) {
                case 0:
                    thirdAnswerVec = new double[]{0, 0, 0.2, 0.8};
                    break;
                case 1:
                    thirdAnswerVec = new double[]{0, 0, 1, 0};
                    break;
                case 2:
                    thirdAnswerVec = new double[]{0, 1, 0, 0};
                    break;
                case 3:
                    thirdAnswerVec = new double[]{0, 0.5, 0.5, 0};
                    break;
            }
        }
    }

    int currentBtnIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_yourself, container, false);
        Button img_rightTop = view.findViewById(R.id.img_right_top);
        Button img_leftTop = view.findViewById(R.id.img_left_top);
        Button img_rightBottm = view.findViewById(R.id.img_right_bottom);
        Button img_leftBottom = view.findViewById(R.id.img_left_bottom);

        Button[] img_arr = new Button[]{img_leftTop, img_rightTop, img_rightBottm, img_leftBottom};

        for (Button img_button :
                img_arr) {
            img_button.setOnClickListener(new View.OnClickListener() {

                /**
                 * set button onclick action
                 * if the user hasn't answer three question, then advance answered question counter
                 * else move to select days and type fragment
                 * @param view
                 */
                int btnIndex = currentBtnIndex;

                @Override
                public void onClick(View view) {
                    setQuestionVec(QuestionsAnswered, btnIndex);
                    if (QuestionsAnswered < 2) {
                        QuestionsAnswered++;
                        setQuestion();
                        return;
                    }
                    QuestionsAnswered = 0;
                    double[] loggedinUserCharVec = new double[]{0, 0, 0, 0};
                    for (int i = 0; i < 4; i++) {
                        loggedinUserCharVec[i] = (firstAnswerVec[i] + secondAnswerVec[i] + thirdAnswerVec[i]) / 3;
                    }

                    Globals.currentSessionUser.setCharacteristicVec(loggedinUserCharVec);

                    StaticImageFragment fragment = StaticImageFragment.newInstance(
                            StaticImageFragment.IMAGES.now_we_know_you_better.toString(),
                            StaticImageFragment.FRAGMENTS.TRIP_TYPE.toString());

                    FragmentManager fragmentManager = MainActivity.GetInstance().fragmentManager;
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment, "FETCH_TRIP_FRAGMENT").addToBackStack("FETCH_TRIP_FRAGMENT");
                    fragmentTransaction.commit();
                    setQuestion();
                }
            });
            currentBtnIndex++;
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
