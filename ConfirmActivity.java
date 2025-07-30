package com.tuusuario.mycontactapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {

    TextView tvName, tvDate, tvPhone, tvEmail, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvName = findViewById(R.id.tvName);
        tvDate = findViewById(R.id.tvDate);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescription = findViewById(R.id.tvDescription);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String date = intent.getStringExtra("date");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String description = intent.getStringExtra("description");

        tvName.setText(name);
        tvDate.setText(date);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDescription.setText(description);

        findViewById(R.id.btnEdit).setOnClickListener(v -> {
            Intent backIntent = new Intent(ConfirmActivity.this, MainActivity.class);
            backIntent.putExtra("name", name);
            backIntent.putExtra("date", date);
            backIntent.putExtra("phone", phone);
            backIntent.putExtra("email", email);
            backIntent.putExtra("description", description);
            startActivity(backIntent);
        });
    }
}