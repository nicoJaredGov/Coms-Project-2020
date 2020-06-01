package com.example.newproject2020.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newproject2020.RegSharedPrefs;
import com.example.newproject2020.TestActivity;
import com.example.project2020.R;

public class EmployeeRegistrationActivity extends AppCompatActivity {

    //Shared Preferences
    public static final String SHARED_PREFS = "empSharedPrefs";
    public static final String FULL_NAME = "fullName";
    public static final String PASSWORD = "password";
    public static final String ID_NUM = "userID";

    //Variables
    ImageView backButton;
    Button nextButton;
    TextView registerTitleText;

    RegSharedPrefs regSharedPref;
    EditText nameField, numField, passwordField, confirmField;
    String name, employeeNum, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);

        //Hooks
        backButton = findViewById(R.id.registration_back_button);
        nextButton = findViewById(R.id.nextBtn);
        registerTitleText = findViewById(R.id.register_title_text);
        nameField = findViewById(R.id.nameEditText);
        numField = findViewById(R.id.empNumEditText);
        passwordField = findViewById(R.id.passwordEditText);
        confirmField = findViewById(R.id.confirmEditText);

    }

    public void callRegisterNextScreen(View view) {
        name = nameField.getText().toString();
        employeeNum = numField.getText().toString();
        password = passwordField.getText().toString();
        confirmPassword = confirmField.getText().toString();

        regSharedPref.saveData(this,name," ",password,employeeNum);
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);

        //Add Transition
        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair<View, String>(backButton, "transition_registration_back_button");
        pairs[1] = new Pair<View, String>(nextButton, "transition_register_next_button");
        pairs[2] = new Pair<View, String>(registerTitleText, "transition_register_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(EmployeeRegistrationActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

}
