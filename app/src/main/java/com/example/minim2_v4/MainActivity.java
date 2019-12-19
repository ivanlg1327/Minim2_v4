package com.example.minim2_v4;



import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText textusername;
    private EditText textpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        this.textusername = findViewById(R.id.usernamebox);
        this.textpassword = findViewById(R.id.passwordbox);

        final Button logIn = findViewById(R.id.logIn);
        final Button signUp = findViewById(R.id.signUp);
        final View.OnClickListener connectListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id){
                    case R.id.logIn:
                        //funcion conectar

                        menuClick();
                        break;

                    case R.id.signUp:

                        singUpClick();
                        break;

                }
            }
        };
        logIn.setOnClickListener(connectListener);
        signUp.setOnClickListener(connectListener);
    }
    public void menuClick()
    {
        Intent i = new Intent(this,ListActivity.class);
        startActivity(i);
    }

    public void singUpClick()
    {

    }
}
