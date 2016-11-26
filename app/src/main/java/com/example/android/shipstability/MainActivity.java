package com.example.android.shipstability;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity is for Quizzes of Ship Stability.
 */
public class MainActivity extends AppCompatActivity {

    int totalScores;
    int numberOfQuizzes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Submit to check the scores of answering quizzes.
     */
    public void submit (View view){
        totalScores=0;
        numberOfQuizzes=0;

        boolean quiz1Result = checkQuiz1Result();
        TextView quiz1ResultDisplay = (TextView) findViewById(R.id.quiz1_result);
        displayResult(quiz1Result, quiz1ResultDisplay);

        boolean quiz2Result = checkQuiz2Result();
        TextView quiz2ResultDisplay = (TextView) findViewById(R.id.quiz2_result);
        displayResult(quiz2Result, quiz2ResultDisplay);

        boolean quiz3Result = checkQuiz3Result();
        TextView quiz3ResultDisplay = (TextView) findViewById(R.id.quiz3_result);
        displayResult(quiz3Result, quiz3ResultDisplay);

        boolean quiz4Result = checkQuiz4Result();
        TextView quiz4ResultDisplay = (TextView) findViewById(R.id.quiz4_result);
        displayResult(quiz4Result, quiz4ResultDisplay);

        boolean quiz5Result = checkQuiz5Result();
        TextView quiz5ResultDisplay = (TextView) findViewById(R.id.quiz5_result);
        displayResult(quiz5Result, quiz5ResultDisplay);

        displayTotalScores(totalScores,numberOfQuizzes);
    }

    /**
     * This method check the result of Quiz-1.
     */
    private boolean checkQuiz1Result() {
        boolean result = false;
        RadioGroup quiz1RadioGroup = (RadioGroup) findViewById(R.id.quiz1_radiogroup);
        int checkID = quiz1RadioGroup.getCheckedRadioButtonId();
        if (checkID==R.id.quiz1_answer_24m){
            result = true;
            totalScores++;
        } else {
            result = false;
        }
        numberOfQuizzes++;
        return result;
    }

    /**
     * This method check the result of Quiz-2.
     */
    private boolean checkQuiz2Result() {
        boolean result = false;
        EditText quiz2 = (EditText) findViewById(R.id.quiz2_answer);
        String quiz2Answer = quiz2.getText().toString();

        if (quiz2Answer.equals("twelve")) {
            result = true;
            totalScores++;
        } else if (quiz2Answer.equals("12")){
            result= true;
            totalScores++;
        } else {
            result = false;
        }
        numberOfQuizzes++;
        return result;
    }

    /**
     * This method check the result of Quiz-3.
     */
    private boolean checkQuiz3Result() {
        boolean result = false;
        EditText quiz3 = (EditText) findViewById(R.id.quiz3_answer);
        String quiz3Answer = quiz3.getText().toString();

        if (quiz3Answer.equals("5000")) {
            result = true;
            totalScores++;
        }  else {
            result = false;
        }
        numberOfQuizzes++;
        return result;
    }

    /**
     * This method check the result of Quiz-4.
     */
    private boolean checkQuiz4Result() {
        boolean result = false;
        EditText quiz41 = (EditText) findViewById(R.id.quiz4_answer1);
        EditText quiz42 = (EditText) findViewById(R.id.quiz4_answer2);

        String quiz4Answer1 = quiz41.getText().toString();
        String quiz4Answer2 = quiz42.getText().toString();

        if (quiz4Answer1.equals("2") && quiz4Answer2.equals("1")) {
            result = true;
            totalScores++;
        }  else {
            result = false;
        }
        numberOfQuizzes++;
        return result;
    }

    /**
     * This method check the result of Quiz-5.
     */
    private boolean checkQuiz5Result() {
        boolean result = false;
        CheckBox quiz51 = (CheckBox) findViewById(R.id.quiz5_answer_iscode);
        CheckBox quiz52 = (CheckBox) findViewById(R.id.quiz5_answer_prob);
        CheckBox quiz53 = (CheckBox) findViewById(R.id.quiz5_answer_marpol);

        boolean quiz5Iscode = quiz51.isChecked();
        boolean quiz5Prob = quiz52.isChecked();
        boolean quiz5Marpol = quiz53.isChecked();

        if (quiz5Iscode && quiz5Prob && quiz5Marpol == false) {
            result = true;
            totalScores++;
        }  else {
            result = false;
        }
        numberOfQuizzes++;
        return result;
    }

    /**
     * This method displays the result of Quizzes on the screen.
     * @param result is the result of the quiz.
     * @param view is the text view to show the result.
     */
    private void displayResult(boolean result, TextView view) {
        TextView resultTextView = view;

        if (result){
            resultTextView.setText(R.string.correct);
        } else {
            resultTextView.setText(R.string.tryagain);
        }
    }

    /**
     * This method displays the result of Quiz-5 on the screen.
     * @param totalScores is the total scores of the quiz.
     * @param numberOfQuizzes is the number of quizzes.
     */
    private void displayTotalScores (int totalScores, int numberOfQuizzes) {
        TextView totalScoresTextView = (TextView) findViewById(R.id.total_scores);
        String totalScoresText = getString(R.string.total_scores);
        totalScoresText = totalScoresText + totalScores + " / "+numberOfQuizzes;
        totalScoresTextView.setText(totalScoresText);
        Toast.makeText(this,totalScoresText,Toast.LENGTH_LONG).show();
    }
}