package com.example.wedding_planner;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.Calendar;

public class Account extends AppCompatActivity {

    String personName = "Hasan Basri";
    String personLastName = "Paşazade";
    String personUserName = "b.pasazade";
    String personPhoneNumber = "05342625806";
    String personDoB = "06/06/2000";
    String personGender = "Male";
    String personUserType = "Regular User";

    ImageButton profilePicture;
    EditText name;
    EditText lastName;
    EditText userName;
    EditText phoneNumber;
    DatePickerDialog picker;
    EditText dateOfBirth;
    Spinner genders;
    RadioGroup userType;
    RadioButton userTypeCheck;
    String uTCheckString;
    AppCompatButton saveChangesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        getSupportActionBar().setTitle("Account");

        profilePicture = (ImageButton) findViewById(R.id.account_pp);
        name = (EditText) findViewById(R.id.account_name);
        lastName = (EditText) findViewById(R.id.account_lastname);
        userName = (EditText) findViewById(R.id.account_username);
        phoneNumber = (EditText) findViewById(R.id.account_phone_number);
        dateOfBirth = (EditText) findViewById(R.id.account_dateofbirth);
        genders = (Spinner) findViewById(R.id.account_gender);
        userType = (RadioGroup) findViewById(R.id.account_user_type);
        saveChangesButton = (AppCompatButton) findViewById(R.id.account_save_button);

        //Genders Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genders.setAdapter(adapter);

        //profilePicture.set
        name.setText(personName);
        lastName.setText(personLastName);
        userName.setText(personUserName);
        phoneNumber.setText(personPhoneNumber);
        dateOfBirth.setText(personDoB);
        if(personGender == "Male") {
            genders.setSelection(adapter.getPosition("Male"));
        } else if(personGender == "Female") {
            genders.setSelection(adapter.getPosition("Female"));
        }
        if(personUserType == "Regular User") {
            userType.check(R.id.radio1);
        } else if(personUserType == "Organizer") {
            userType.check(R.id.radio2);
        }

        // User Type Radio Button
        userType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedDinnerId = userType.getCheckedRadioButtonId();
                userTypeCheck = (RadioButton) view.findViewById(selectedDinnerId);
                uTCheckString = userTypeCheck.getText().toString();
                // Put choice into database.
            }
        });

        //Save Changes Button
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 2. Check if username already exists.
                if(userName.getText().toString().equals("check")) {
                    Toast.makeText(getApplicationContext(), "This username is already exists!", Toast.LENGTH_LONG).show();
                } else {
                    String name_ = name.getText().toString();
                    String lastName_ = lastName.getText().toString();
                    String userName_ = userName.getText().toString();
                    String phoneNumber_ = phoneNumber.getText().toString();
                    String dateOfBirth_ = dateOfBirth.getText().toString();
                    String gender_ = genders.getSelectedItem().toString();

                    if (name_ != null && lastName_ != null && userName_ != null && dateOfBirth_ != null && gender_ != null) {
                        // Add user information into database and open login screen
                        Toast.makeText(getApplicationContext(), "Changes Saved.", Toast.LENGTH_LONG).show();
                        finish();
                        //startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    }
                }
            }
        });

        //Date of Birth
        dateOfBirth.setInputType(InputType.TYPE_NULL);
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(Account.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
                        dateOfBirth.setText(day1 + "/" + (month1 + 1) + "/" + year1);
                    }
                }, year, month, day);
                picker.show();
            }
        });



    }
}

