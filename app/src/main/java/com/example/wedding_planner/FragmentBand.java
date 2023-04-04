package com.example.wedding_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class FragmentBand extends Fragment {

    RadioGroup weddingBand;
    RadioButton weddingBandCheck;
    AppCompatButton nextButton;
    String bCheckString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_band, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingBand = (RadioGroup) view.findViewById(R.id.plan_band);
        nextButton = (AppCompatButton) view.findViewById(R.id.plan_next);

        weddingBand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = weddingBand.getCheckedRadioButtonId();
                weddingBandCheck = (RadioButton) view.findViewById(selectedDinnerId);
                bCheckString = weddingBandCheck.getText().toString();
                // Put choice into database.
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CreatePlanActivitySecond.class));
            }
        });
    }
}