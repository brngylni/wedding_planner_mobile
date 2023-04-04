package com.example.wedding_planner;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    Switch notifications;
    LinearLayout deleteAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        getSupportActionBar().setTitle("Settings");

        notifications = (Switch) findViewById(R.id.settings_notifications);
        deleteAccount = (LinearLayout) findViewById(R.id.settings_delete_layout);

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
                builder.setMessage("Are you sure?");
                builder.setNegativeButton("No", null);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Delete user from database and open login screen.
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                });
                builder.show();

            }
        });

    }

}
