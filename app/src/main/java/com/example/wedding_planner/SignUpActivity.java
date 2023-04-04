package com.example.wedding_planner;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.media.Image;
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

import com.example.wedding_planner.models.User;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    ImageButton profilePicture;
    EditText name;
    EditText lastName;
    EditText userName;
    EditText phoneNumber;
    DatePickerDialog picker;
    DBAdapter adapter;
    EditText dateOfBirth;
    Spinner genders;
    EditText password;
    EditText validatePassword;
    RadioGroup userType;
    RadioButton userTypeCheck;
    String uTCheckString;
    AppCompatButton signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        getSupportActionBar().hide();
        adapter = new DBAdapter(getApplicationContext());
        profilePicture = (ImageButton) findViewById(R.id.signup_pp);
        name = (EditText) findViewById(R.id.signup_name);
        lastName = (EditText) findViewById(R.id.signup_lastname);
        userName = (EditText) findViewById(R.id.signup_username);
        phoneNumber = (EditText) findViewById(R.id.signup_phone_number);
        dateOfBirth = (EditText) findViewById(R.id.signup_dateofbirth);
        genders = (Spinner) findViewById(R.id.signup_gender);
        password = (EditText) findViewById(R.id.signup_password);
        validatePassword = (EditText) findViewById(R.id.signup_password_validate);
        userType = (RadioGroup) findViewById(R.id.user_type);
        signUpButton = (AppCompatButton) findViewById(R.id.signup_button_2);

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

        //Sign Up Button
        signUpButton.setOnClickListener(new View.OnClickListener() {
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
                    String password_ = password.getText().toString();
                    String validatePassword_ = validatePassword.getText().toString();
                    if(password_ != null && validatePassword_ != null && password_.equals(validatePassword_)) {
                        if (name_ != null && lastName_ != null && userName_ != null && dateOfBirth_ != null) {
                            // Add user information into database and open login screen
                            adapter.insertUser(new User(-1, name_, lastName_, userName_, password_, dateOfBirth_, 1, "barankara5@gmail.com" , phoneNumber_, gender_));
                            Toast.makeText(getApplicationContext(), "Sign Up Completed!", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords are not same!", Toast.LENGTH_LONG).show();
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

                picker = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
                                dateOfBirth.setText(day1 + "/" + (month1 + 1) + "/" + year1);
                            }
                            }, year, month, day);
                picker.show();
            }
        });


        //Genders Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genders.setAdapter(adapter);
    }
}
