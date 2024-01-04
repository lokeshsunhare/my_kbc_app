package com.example.kbc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView tv_name;
    TextView tv_email;
    TextView tv_result;

    int total = 0;
    int CorrectCount = 0;
    int wrongCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_name = findViewById(R.id.tv_name);
        tv_email = findViewById(R.id.tv_email);
        tv_result = findViewById(R.id.tv_result);

        tv_name.setText(getIntent().getExtras().getString("name"));
        tv_email.setText(getIntent().getExtras().getString("email"));
        total = getIntent().getExtras().getInt("total");
        CorrectCount = getIntent().getExtras().getInt("CorrectCount");
        wrongCount = getIntent().getExtras().getInt("wrongCount");
        tv_result.setText(CorrectCount + "/" + total);

    }
}