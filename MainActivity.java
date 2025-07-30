package com.tuusuario.mycontactapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone, etEmail, etDescription;
    private TextView tvDate;
    private Calendar dob = Calendar.getInstance();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        tvDate = findViewById(R.id.tvDate);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etDescription = findViewById(R.id.etDescription);
        Button btnNext = findViewById(R.id.btnNext);

        tvDate.setOnClickListener(view -> {
            new DatePickerDialog(MainActivity.this, (view1, year, month, day) -> {
                dob.set(year, month, day);
                tvDate.setText(day + "/" + (month + 1) + "/" + year);
            }, dob.get(Calendar.YEAR), dob.get(Calendar.MONTH), dob.get(Calendar.DAY_OF_MONTH)).show();
        });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("date", tvDate.getText().toString());
            intent.putExtra("phone", etPhone.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());
            intent.putExtra("description", etDescription.getText().toString());
            startActivity(intent);
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            etName.setText(extras.getString("name", ""));
            tvDate.setText(extras.getString("date", ""));
            etPhone.setText(extras.getString("phone", ""));
            etEmail.setText(extras.getString("email", ""));
            etDescription.setText(extras.getString("description", ""));
        }
    }
}