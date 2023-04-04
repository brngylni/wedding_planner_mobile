package com.example.wedding_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAlcohol extends Fragment {

    RadioGroup weddingAlcohol;
    RadioButton weddingAlcoholCheck;
    String wACheckString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_alcohol, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingAlcohol = (RadioGroup) view.findViewById(R.id.plan_alcohol);

        weddingAlcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = weddingAlcohol.getCheckedRadioButtonId();
                weddingAlcoholCheck = (RadioButton) view.findViewById(selectedDinnerId);
                wACheckString = weddingAlcoholCheck.getText().toString();
                // Put choice into database.
            }
        });
    }
}