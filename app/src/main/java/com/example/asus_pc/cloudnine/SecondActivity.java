package com.example.asus_pc.cloudnine;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b;
    private EditText name,mail,phone,age,passward;
    LoginClass myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b = (Button) findViewById(R.id.buttonIsClicked);
        name = (EditText) findViewById(R.id.nameBox);
        mail = (EditText) findViewById(R.id.mailBox);
        phone = (EditText) findViewById(R.id.phoneBox);
        age = (EditText) findViewById(R.id.ageBox);
        passward = (EditText) findViewById(R.id.passwardBox);

        myDatabaseHelper = new LoginClass(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        b.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        if(!validity())
        {
            Log.d("tag", "mess");
            //Toast.makeText(MainActivity.this,"Success...",Toast.LENGTH_LONG).show();
            String Name = name.getText().toString();
            String Mail = mail.getText().toString();
            String Age = age.getText().toString();
            String Passward = passward.getText().toString();

             myDatabaseHelper.insertData(Name,Mail,Passward,Age);

            /*if((rowId == -1)){
                Toast.makeText(getApplicationContext(), "Row "+rowId+" is unsuccessfully inserted", Toast.LENGTH_LONG).show();
            }

            else{
                Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_LONG).show();
            }*/
            Intent inten = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(inten);
        }
    }

    private boolean validity()
    {
        if(name.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter User Name",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(mail.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter E-mail",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(phone.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter Phone Number",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(age.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter Age",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(passward.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(SecondActivity.this,"Enter Passward",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return false;
    }


}
