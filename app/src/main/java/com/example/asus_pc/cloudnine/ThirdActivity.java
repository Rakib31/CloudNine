package com.example.asus_pc.cloudnine;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private EditText pass,email,url;
    private Button button,button2;
    LoginClass loginHelper = new LoginClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        url = (EditText) findViewById(R.id.URL);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        webView = (WebView) findViewById(R.id.webId);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            if (!validity()) {
                if (loginHelper.search(email.getText().toString(), pass.getText().toString())) {
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl("http:/"+url.getText().toString().trim()+"/");
                    //Intent inten = new Intent(ThirdActivity.this, FourthActivity.class);
                    //startActivity(inten);
                } else
                    Toast.makeText(ThirdActivity.this, "incorrect username or passward", Toast.LENGTH_LONG).show();
            }
        }

        else if(v.getId() == R.id.button2)
        {
            Intent inten = new Intent(ThirdActivity.this, SecondActivity.class);
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
            return true;
        }

        else if(pass.getText().toString().trim().length() <= 0)
        {
            Toast.makeText(ThirdActivity.this,"Enter passward",Toast.LENGTH_LONG).show();
            return true;
        }

        else
            return false;
    }

}


