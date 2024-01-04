package com.example.kbc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText name;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        findViewById(R.id.et_submit).setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("name", name.getText().toString().trim());
            intent.putExtra("email", email.getText().toString().trim());
            startActivity(intent);
        });
    }
}