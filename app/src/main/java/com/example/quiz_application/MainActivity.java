package com.example.quiz_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private Button start;
    public long longBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(TextView)findViewById(R.id.name);
        start=(Button)findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Splash_Screen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(longBackPressed + 2000 > System.currentTimeMillis()){
            new AlertDialog.Builder(this).setTitle("Do you want to exit ?").setNegativeButton("No",null).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setResult(RESULT_OK,new Intent().putExtra("EXit",true));
                    finish();
                }
            }).create().show();

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
}