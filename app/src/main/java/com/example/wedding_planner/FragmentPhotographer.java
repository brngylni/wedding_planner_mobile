package com.example.wedding_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPhotographer extends Fragment {

    RadioGroup weddingPhotographer;
    RadioButton weddingPhotographerCheck;
    String pCheckString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_photographer, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingPhotographer = (RadioGroup) view.findViewById(R.id.plan_photographer);

        weddingPhotographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = weddingPhotographer.getCheckedRadioButtonId();
                weddingPhotographerCheck = (RadioButton) view.findViewById(selectedDinnerId);
                pCheckString = weddingPhotographerCheck.getText().toString();
                // Put choice into database.
            }
        });
    }
}