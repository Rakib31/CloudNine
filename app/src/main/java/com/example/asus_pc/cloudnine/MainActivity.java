package com.example.asus_pc.cloudnine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            Intent inten = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(inten);
        }

        if(v.getId() == R.id.button2){
            Intent inten = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(inten);
        }
    }
}

