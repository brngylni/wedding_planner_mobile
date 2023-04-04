package com.example.wedding_planner;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class CreatePlanActivitySecond extends AppCompatActivity {

    ViewPager2 myViewPager2_2;
    ViewPagerFragmentAdapter myAdapter_2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan_view_pager_2);
        getSupportActionBar().hide();

        myViewPager2_2 = findViewById(R.id.viewpager22);
        myAdapter_2 = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getLifecycle());

        myAdapter_2.addFragment(new FragmentDinnerMenu());
        myAdapter_2.addFragment(new FragmentPhotographerList());

        myViewPager2_2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2_2.setAdapter(myAdapter_2);
    }
}