package com.example.asus_pc.cloudnine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pass,email,url;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        url = (EditText) findViewById(R.id.URL);
        but = (Button) findViewById(R.id.button);
        but.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(!validity())
        {
            //Toast.makeText(MainActivity.this,"Success...",Toast.LENGTH_LONG).show();
            Intent inten = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(inten);
        }
    }

    private boolean validity()
    {
        if(url.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter url",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(email.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter username",Toast.LENGTH_LONG).show();
            return true;
        }

        else if(pass.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter passward",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

}

