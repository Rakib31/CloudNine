package com.example.asus_pc.cloudnine;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pass,email,url;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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
            Intent inten = new Intent(ThirdActivity.this, FourthActivity.class);
            startActivity(inten);
        }
    }

    private boolean validity()
    {
        if(url.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(ThirdActivity.this,"Enter url",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(email.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(ThirdActivity.this,"Enter username",Toast.LENGTH_LONG).show();
            //return permission();
            return true;
        }

        else if(pass.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(ThirdActivity.this,"Enter passward",Toast.LENGTH_LONG).show();
            return true;
        }

        else if(email.getText().toString().trim().length() > 0 && pass.getText().toString().trim().length() > 0)
        {
            //Toast.makeText(SecondActivity.this,"Incorrect username",Toast.LENGTH_LONG).show();
            return permission();
            //return true;
        }

        else
            return false;
    }

    private boolean permission()
    {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String user = email.getText().toString().trim();
        String password = pass.getText().toString().trim();


        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection("jdbc:ucanaccess://I:\\Desktop\\Database1.accdb");
            String sql = "select * from Login_table where Uder_name='" + email.getText() + "'and User_password='" + pass.getText() + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()) {
                Log.d("tag",rs.getString("User_name") + "\t" + rs.getString("User_password") + "\n");
                if(rs.getString("User_name").equals(user) && rs.getString("User_password").equals(password))
                    return false;
            }
        }catch(Exception e){
            Log.d("tag",e + "\n");
        }
        Toast.makeText(ThirdActivity.this,"Incorrect username",Toast.LENGTH_LONG).show();
        return true;
    }

}


