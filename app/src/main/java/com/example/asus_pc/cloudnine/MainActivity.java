package com.example.asus_pc.cloudnine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button b;
    private EditText name,mail,phone,age,passward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.buttonIsClicked);
        name = (EditText) findViewById(R.id.nameBox);
        mail = (EditText) findViewById(R.id.mailBox);
        phone = (EditText) findViewById(R.id.phoneBox);
        age = (EditText) findViewById(R.id.ageBox);
        passward = (EditText) findViewById(R.id.passwardBox);

        b.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        if(!validity())
        {
            //Toast.makeText(MainActivity.this,"Success...",Toast.LENGTH_LONG).show();
            Intent inten = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(inten);
        }
    }

    private boolean validity()
    {
        if(name.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(MainActivity.this,"Enter User Name",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(mail.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(MainActivity.this,"Enter E-mail",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(phone.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(MainActivity.this,"Enter Phone Number",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(age.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(MainActivity.this,"Enter Age",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(passward.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(MainActivity.this,"Enter Passward",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }

}

