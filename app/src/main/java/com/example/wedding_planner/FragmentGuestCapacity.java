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

public class FragmentGuestCapacity extends Fragment {

    RadioGroup weddingGuestCap;
    RadioButton weddingGuestCapCheck;
    String gCCheckString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_guest_capacity, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingGuestCap = (RadioGroup) view.findViewById(R.id.plan_guest);

        weddingGuestCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = weddingGuestCap.getCheckedRadioButtonId();
                weddingGuestCapCheck = (RadioButton) view.findViewById(selectedDinnerId);
                gCCheckString = weddingGuestCapCheck.getText().toString();
                // Put choice into database.
            }
        });
    }
}