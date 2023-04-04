package com.example.wedding_planner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class FragmentDateTime extends Fragment {

    EditText weddingDate;
    EditText weddingTime;
    DatePickerDialog datePicker;
    TimePickerDialog timePicker;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.plan_date_time, container, true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weddingDate = (EditText) view.findViewById(R.id.plan_date);
        weddingTime = (EditText) view.findViewById(R.id.plan_time);

        weddingDate.setInputType(InputType.TYPE_NULL);
        weddingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
                        weddingDate.setText(day1 + "/" + (month1 + 1) + "/" + year1);
                    }
                }, year, month, day);
                datePicker.show();
            }
        });

        weddingTime.setInputType(InputType.TYPE_NULL);
        weddingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                timePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        weddingTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                timePicker.show();
                //Toast.makeText(getContext(), "Swipe Left", Toast.LENGTH_SHORT).show();
            }
        });

    }
}