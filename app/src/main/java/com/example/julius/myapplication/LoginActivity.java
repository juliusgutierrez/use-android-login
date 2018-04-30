package com.example.julius.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static EditText userName;
    private static EditText password;
    private static TextView attempt;
    private static Button loginBtn;
    private int attempCounter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
    }

    public void loginButton() {
        userName = findViewById(R.id.editText_userName);
        password = findViewById(R.id.editText_password);
        attempt = findViewById(R.id.textView_attemptNumber);
        loginBtn = findViewById(R.id.button_login);
        attempt.setText(Integer.toString(attempCounter));
        loginBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:

                if (userName.getText().toString().equals("user") &&
                        password.getText().toString().equals("pass")) {
                    Toast.makeText(LoginActivity.this,
                            "Username and password is correct",
                            Toast.LENGTH_SHORT).show();
                    Intent intent
                            = new Intent(getApplicationContext(),
                            UserProfileActivity.class);
                    startActivity(intent);
                } else {
                    attempt.setText(Integer.toString(--attempCounter));
                }
                break;

            default:
        }
    }
}
