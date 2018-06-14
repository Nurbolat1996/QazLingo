package kz.qazlingo.www.qazlingo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by sansyzbaynurbolat on 1/16/18.
 */

public class Fragment_alippe_low_level extends Fragment {
    private static final String TAG = "MainActivity";
    private static final String TITLE = "Әріптің латынша нұсқасын еңгізіңіз";
    private static final String BUTTON_NEXT_TEXT = "Келесі";
    private static final String BUTTON_CHECK_TEXT = "Тексеру";
    private int rightAnswerColor;
    private int wrongAnswerColor;
    boolean isCheck;
    private int noAnswerColor;
    private EditText etAnswer;
    private Button btNext;
    private TextView tvNotification;
    private TextView tvAlphabet;
    private TextView tvRightAnswer;
    private Random random;
    private String currentLetter;
    private Converter converter;
    MediaPlayer rightSound;
    MediaPlayer wrongSound;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_low_level,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVar();
        nextButtonClicked();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCheck){
                    btNext.setText(BUTTON_NEXT_TEXT);
                    String answer = etAnswer.getText().toString().toUpperCase();
                    if(converter.toLatin(currentLetter).equals(answer)){
                        //if answer is right
                        int randomNumber = random.nextInt(Vars.lst_right_great_words.length-1);
                        tvNotification.setText(Vars.lst_right_great_words[randomNumber]);
                        tvNotification.setBackgroundColor(rightAnswerColor);
                        rightSound.start();
                    }else{
                        //if answer is wrong
                        wrongSound.start();
                        int randomNumber = random.nextInt(Vars.lst_wrong_great_words.length-1);
                        tvNotification.setText(Vars.lst_wrong_great_words[randomNumber]);
                        tvNotification.setBackgroundColor(wrongAnswerColor);
                        tvRightAnswer.setText("Дұрыс жауап: "+converter.toLatin(currentLetter));
                    }
                    isCheck = false;
                }else{
                    nextButtonClicked();
                }


            }
        });



    }


    private void  initVar(){
        converter = new Converter();
        random = new Random();
        rightAnswerColor = getResources().getColor(R.color.rightAnswer);
        wrongAnswerColor = getResources().getColor(R.color.wrongAnswer);
        noAnswerColor = getResources().getColor(R.color.grayBackground);
        tvNotification = getActivity().findViewById(R.id.alippe_low_level_text_view_lenta);
        tvAlphabet = getActivity().findViewById(R.id.alippe_low_level_text_view);
        btNext = getActivity().findViewById(R.id.alippe_low_level_button);
        etAnswer = getActivity().findViewById(R.id.alippe_low_level_edit_text);
        tvRightAnswer = getActivity().findViewById(R.id.alippe_low_level_text_view_right_answer);
        rightSound = MediaPlayer.create(getContext(),R.raw.right);
        wrongSound = MediaPlayer.create(getContext(),R.raw.wrong);
    }


    private void nextButtonClicked(){
        etAnswer.setText("");
        tvNotification.setText(TITLE);
        tvNotification.setBackgroundColor(noAnswerColor);
        int randomNumber = random.nextInt(Vars.lst_kiril.length-1);
        int randomNumberColor = random.nextInt(Vars.lst_colors.length-1);
        tvAlphabet.setTextColor(Vars.lst_colors[randomNumberColor]);
        currentLetter = Vars.lst_kiril[randomNumber];
        tvAlphabet.setText(currentLetter);
        tvRightAnswer.setText("");
        btNext.setText(BUTTON_CHECK_TEXT);
        isCheck = true;
    }

}
