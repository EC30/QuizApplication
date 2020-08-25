package com.example.quiz_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Score extends AppCompatActivity {
    private Button done, exit;
    private TextView correct, score, score_number, correct_number,wrong_answer,wrong_number;
    private long longBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Toolbar score_toolbar=findViewById(R.id.score_toolbar);
        setSupportActionBar(score_toolbar);
        getSupportActionBar().setTitle("Score");


        score=(TextView)findViewById(R.id.score);
        score_number=(TextView)findViewById(R.id.score_number);
        correct=(TextView)findViewById(R.id.correct);
        correct_number=(TextView)findViewById(R.id.correct_number);
        wrong_answer=(TextView)findViewById(R.id.wrong_answer);
        wrong_number=(TextView)findViewById(R.id.wrong_number);

        done=(Button)findViewById(R.id.done);
        exit=(Button)findViewById(R.id.Exit);

        String score_str=getIntent().getStringExtra("SCORE");
        String correct_str=getIntent().getStringExtra("CORRECT");
        String wrong_str= getIntent().getStringExtra("WRONG");
        correct_number.setText(correct_str);
        wrong_number.setText(wrong_str);
        score_number.setText(score_str);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Score.this,Splash_Screen.class);
                Score.this.startActivity(intent);
                Score.this.finish();
            }
        });
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // finish();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if(longBackPressed + 2000 > System.currentTimeMillis()){
            Intent intent=new Intent(Score.this,MainActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }
        longBackPressed=System.currentTimeMillis();

    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    public void onClick(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit")
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}