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

public class FragmentDinner extends Fragment {

    RadioGroup weddingDinner;
    RadioButton weddingDinnerCheck;
    String wDCheckString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_dinner, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingDinner = (RadioGroup) view.findViewById(R.id.plan_dinner);

        weddingDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = weddingDinner.getCheckedRadioButtonId();
                weddingDinnerCheck = (RadioButton) view.findViewById(selectedDinnerId);
                wDCheckString = weddingDinnerCheck.getText().toString();
                // Put choice into database.
            }
        });
    }
}
