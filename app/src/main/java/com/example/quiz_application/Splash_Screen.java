package com.example.quiz_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Splash_Screen extends AppCompatActivity implements View.OnClickListener{
    private CardView java,Python,php,html,jQuery,sql;
    private long longBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(intent);
            }
        });

        java=(CardView)findViewById(R.id.java);
        Python=(CardView)findViewById(R.id.python);
        php=(CardView)findViewById(R.id.php);
        html=(CardView)findViewById(R.id.sql);
        jQuery=(CardView)findViewById(R.id.jQuery);
        sql=(CardView)findViewById(R.id.html);


        java.setOnClickListener(this);
        Python.setOnClickListener(this);
        php.setOnClickListener(this);
        html.setOnClickListener(this);
        jQuery.setOnClickListener(this);
        sql.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.java:
                Intent intentJava=new Intent(Splash_Screen.this,Sets.class);
                intentJava.putExtra("Category",Constants.JAVA);
                startActivity(intentJava);
                break;
            case R.id.python:
                Intent intentPython=new Intent(Splash_Screen.this,Sets.class);
                intentPython.putExtra("Category",Constants.PYTHON);
                startActivity(intentPython);
                break;
            case R.id.sql:
                Intent intentXML=new Intent(Splash_Screen.this,Sets.class);
                intentXML.putExtra("Category",Constants.SQL);
                startActivity(intentXML);
                break;
            case R.id.php:
                Intent intentSQL=new Intent(Splash_Screen.this,Sets.class);
                intentSQL.putExtra("Category",Constants.PHP);
                startActivity(intentSQL);
                break;
            case R.id.html:
                Intent intentHTML=new Intent(Splash_Screen.this,Sets.class);
                intentHTML.putExtra("Category",Constants.HTML);
                startActivity(intentHTML);
                break;
            case R.id.jQuery:
                Intent intentjQuery=new Intent(Splash_Screen.this,Sets.class);
                intentjQuery.putExtra("Category",Constants.JQUERY);
                startActivity(intentjQuery);
                break;
        }

    }
    @Override
    public void onBackPressed() {
        if(longBackPressed + 2000 > System.currentTimeMillis()){
            Intent intent=new Intent(Splash_Screen.this,MainActivity.class);
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
    }
