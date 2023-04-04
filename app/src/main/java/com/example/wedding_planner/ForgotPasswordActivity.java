package com.example.wedding_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText recoveryCode;
    EditText userName;
    EditText newPassword;
    EditText validateNewPassword;
    AppCompatButton changePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);
        getSupportActionBar().hide();

        recoveryCode = (EditText) findViewById(R.id.forgot_password_code);
        userName = (EditText) findViewById(R.id.forgot_password_username);
        newPassword = (EditText) findViewById(R.id.forgot_password);
        validateNewPassword = (EditText) findViewById(R.id.forgot_password_validate);
        changePasswordButton = (AppCompatButton) findViewById(R.id.change_password);

        String code = getIntent().getExtras().getString("0123");

        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recoveryCode_ = recoveryCode.getText().toString();
                String userName_ = userName.getText().toString();
                String newPassword_ = newPassword.getText().toString();
                String validateNewPassword_ = validateNewPassword.getText().toString();
                boolean checkUserName_ = true; // Check if username exists.

                // If everything is correct
                if((recoveryCode_.equals(code) && checkUserName_) && (!newPassword_.equals("") && !validateNewPassword_.equals("") && newPassword_.equals(validateNewPassword_))) {
                    // Change password with username information.
                    startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
                }
                else if(recoveryCode_.equals("")) {
                    Toast.makeText(getApplicationContext(), "This area cannot be empty!", Toast.LENGTH_LONG).show();
                }
                else if(!recoveryCode_.equals(code)) {
                    Toast.makeText(getApplicationContext(), "Recovery code is not correct!", Toast.LENGTH_LONG).show();
                }
                else if(!checkUserName_) {
                    Toast.makeText(getApplicationContext(), "Username is not correct!", Toast.LENGTH_LONG).show();
                }
                else if(newPassword_.equals("") || validateNewPassword_.equals("")) {
                    Toast.makeText(getApplicationContext(), "This area cannot be empty!", Toast.LENGTH_LONG).show();
                }
                else if(!newPassword_.equals(validateNewPassword_)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
