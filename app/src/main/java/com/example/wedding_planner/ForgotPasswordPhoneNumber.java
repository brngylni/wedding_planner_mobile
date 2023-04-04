package com.example.wedding_planner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ForgotPasswordPhoneNumber extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    EditText phoneNumber;
    AppCompatButton sendCode;
    String phoneNumber_;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_phone_number);
        getSupportActionBar().hide();

        phoneNumber = (EditText) findViewById(R.id.forgot_password_phone_number);
        sendCode = (AppCompatButton) findViewById(R.id.send_code);
        code = "0123"; // Fetch the recovery code from database.


        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber_ = phoneNumber.getText().toString();

                // 1. Check if the number exists in database.
                // 2. If exists, send an sms recovery code.
                // change condition later
                if(phoneNumber_.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your phone number!", Toast.LENGTH_LONG).show();
                }
                else if(true) {
                    //sendSMSMessage();
                    Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                    intent.putExtra("0123", code);
                    startActivity(intent);
                }
                // 3. If not, alert that phone number is incorrect.
                else {
                    Toast.makeText(getApplicationContext(), "This phone number is not registered!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void sendSMSMessage() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber_, null, code, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}
