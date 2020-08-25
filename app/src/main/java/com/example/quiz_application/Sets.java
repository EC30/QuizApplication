package com.example.quiz_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class Sets extends AppCompatActivity implements View.OnClickListener{
    TextView number,time,question;
    Button option1,option2,option3,option4;
    private ArrayList<Question> questionList;
    int quesNum;
    private CountDownTimer countDown;
    private int score_number;
    private int wrong_answer;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;
    private String categoryvalue;
    public long longBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        Toolbar set_toolbar=findViewById(R.id.set_toolbar);
        setSupportActionBar(set_toolbar);
        String title=getIntent().getStringExtra("Category");
        getSupportActionBar().setTitle(title);
        set_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sets.this,Splash_Screen.class);
                startActivity(intent);
            }
        });
        number=(TextView)findViewById(R.id.number);
        time=(TextView)findViewById(R.id.time);
        question=(TextView)findViewById(R.id.question);

        option1=(Button) findViewById(R.id.option1);
        option2=(Button) findViewById(R.id.option2);
        option3=(Button) findViewById(R.id.option3);
        option4=(Button) findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);


        Intent intentCategory=getIntent();
        categoryvalue=intentCategory.getStringExtra("Category");
        getQuestion();
        Collections.shuffle(questionList);
        score_number=0;
        wrong_answer=0;
    }
    public void getQuestion(){
        // questionsList=new ArrayList<>();
        Helper dbHelper=new Helper(this);
        questionList=dbHelper.getQuestions(categoryvalue);

        setQuestion();
    }
    private void setQuestion(){
        time.setText(String.valueOf(10));
        currentQuestion = questionList.get(questionCounter);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getOption1());
        option2.setText(currentQuestion.getOption2());
        option3.setText(currentQuestion.getOption3());
        option4.setText(currentQuestion.getOption4());

        number.setText(String.valueOf(1) + "/" +String.valueOf(questionList.size()));
        startTimer();
        quesNum=0;
    }
    private void startTimer(){
        countDown =new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes=00;
                int seconds=(int) (millisUntilFinished/1000);
                String timer=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
                //time.setText("00 : "+String.valueOf(millisUntilFinished/1000));
                time.setText(timer);
//                if(seconds<10){
//                    time.setTextColor(Color.RED);
//                }
            }

            @Override
            public void onFinish() {
                Toast.makeText(Sets.this, "Times up", Toast.LENGTH_SHORT).show();
                switch (questionList.get(quesNum).getAnswerNr()){
                    case 1:
                        option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        break;
                    case 2:
                        option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        break;
                    case 3:
                        option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        break;
                    case 4:
                        option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        break;

                }
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeQuestion();
                    }
                }, 1500);
            }
        };
        countDown.start();
    }
    @Override
    public void onClick(View v) {
        int selectedOption=0;
        switch ((v.getId())){
            case R.id.option1:
                selectedOption=1;
                break;
            case R.id.option2:
                selectedOption=2;
                break;
            case R.id.option3:
                selectedOption=3;
                break;
            case R.id.option4:
                selectedOption=4;
                break;
            default:

        }
        countDown.cancel();
        checkAnswer(selectedOption,v);

    }
    private void checkAnswer(int selectedOption,View view){
        if(selectedOption == questionList.get(quesNum).getAnswerNr()){
            //right_answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            Toast.makeText(Sets.this, "Correct Answer", Toast.LENGTH_SHORT).show();
            score_number++;

        }else{
            //wrong_answer
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(Sets.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
            switch (questionList.get(quesNum).getAnswerNr()){
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;

            }
        }
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 2000);

    }
    private void changeQuestion(){
        if(quesNum<questionList.size()-1){
            quesNum++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);
            number.setText(String.valueOf(quesNum+1)+"/"+String.valueOf(questionList.size()));
            time.setText((String.valueOf(10)));
            startTimer();

        }else{
            //score_display
            Intent intents=new Intent(Sets.this,Score.class);
            wrong_answer= questionList.size()-score_number;
            intents.putExtra("WRONG", String.valueOf(wrong_answer));
            intents.putExtra("CORRECT", String.valueOf(score_number));
            intents.putExtra("SCORE",String.valueOf(score_number) +"/" +String.valueOf(questionList.size()));
            intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intents);
            Sets.this.finish();
        }
    }
    private void playAnim(final View view, final int value, final int viewNum){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(value==0){
                            switch (viewNum)
                            {
                                case 0:
                                    ((TextView)view).setText(questionList.get(quesNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(questionList.get(quesNum).getOption1());
                                    break;
                                case 2:
                                    ((Button)view).setText(questionList.get(quesNum).getOption2());
                                    break;
                                case 3:
                                    ((Button)view).setText(questionList.get(quesNum).getOption3());
                                    break;
                                case 4:
                                    ((Button)view).setText(questionList.get(quesNum).getOption4());
                                    break;
                            }
                            if(viewNum!=0){
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                            }
                            playAnim(view,1,viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @Override
    public void onBackPressed() {
            if(longBackPressed + 2000 > System.currentTimeMillis()){
                Intent intent=new Intent(Sets.this,MainActivity.class);
                startActivity(intent);

            }
            else{
                Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
            }
            longBackPressed=System.currentTimeMillis();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(countDown!=null){
            countDown.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDown!=null){
            countDown.cancel();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(countDown!=null){
            countDown.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}