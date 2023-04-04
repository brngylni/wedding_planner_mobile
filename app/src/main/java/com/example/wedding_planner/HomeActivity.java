package com.example.wedding_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton addPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        getSupportActionBar().setTitle("Home");
        addPlan = (FloatingActionButton) findViewById(R.id.fab);
        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CreatePlanActivityFirst.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_account:
                startActivity(new Intent(new Intent(getApplicationContext(), Account.class)));
                return true;
            case R.id.menu_settings:
                startActivity(new Intent(new Intent(getApplicationContext(), Settings.class)));
                return true;
            case R.id.menu_logout:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
