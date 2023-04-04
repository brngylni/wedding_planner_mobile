package com.example.wedding_planner;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class CreatePlanActivityFirst extends AppCompatActivity {

    ViewPager2 myViewPager2_1;
    ViewPagerFragmentAdapter myAdapter_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_plan_view_pager_1);
        getSupportActionBar().hide();

        myViewPager2_1 = findViewById(R.id.viewpager2);
        myAdapter_1 = new ViewPagerFragmentAdapter(getSupportFragmentManager(), getLifecycle());

        myAdapter_1.addFragment(new FragmentDateTime());
        myAdapter_1.addFragment(new FragmentDinner());
        myAdapter_1.addFragment(new FragmentAlcohol());
        myAdapter_1.addFragment(new FragmentGuestCapacity());
        myAdapter_1.addFragment(new FragmentPhotographer());
        myAdapter_1.addFragment(new FragmentBand());


        myViewPager2_1.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2_1.setAdapter(myAdapter_1);
    }
}
