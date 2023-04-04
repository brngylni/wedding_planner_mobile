package com.example.wedding_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    String adminUsername = "a";
    String adminPassword = "a";
    EditText inputUserName;
    EditText inputPassword;
    DBAdapter adapter;
    AppCompatButton login_button;
    AppCompatButton signup_button;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        getSupportActionBar().hide();
        adapter = new DBAdapter(getApplicationContext());
        inputUserName = (EditText) findViewById(R.id.login_username);
        inputPassword = (EditText) findViewById(R.id.login_password);
        login_button = (AppCompatButton) findViewById(R.id.login_button);
        signup_button = (AppCompatButton) findViewById(R.id.signup_button);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);

        // Login Button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUserName_ = inputUserName.getText().toString();
                String inputPassword_ = inputPassword.getText().toString();
                if(inputUserName_.equals(adminUsername) && inputPassword_.equals(adminPassword)) {
                    Toast.makeText(getApplicationContext(), "Logging..", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra(inputUserName_, inputPassword_);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Login Information..", Toast.LENGTH_LONG).show();

                }
            }
        });

        // Sign Up Button
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });

        // Forgot Password Text
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordPhoneNumber.class));
            }
        });


    }
    @Override
    public void onBackPressed() {}
}