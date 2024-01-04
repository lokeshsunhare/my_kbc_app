package com.example.kbc_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    Button saveNext;
    Button btn_previous;
    RecyclerView recycle_options;

    String nameStr;
    String emailStr;
    int CorrectCount = 0;
    int wrongCount = 0;
    int qCount = 1;

    List<Question> questionListAll = new ArrayList<>();
    List<Options> currentQuestionOptionList = new ArrayList<>();
    TextView tv_question_text;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle_options = findViewById(R.id.recycle_options);
        saveNext = findViewById(R.id.btn_save_next);
        btn_previous = findViewById(R.id.btn_previous);
        tv_question_text = findViewById(R.id.tv_question_text);
        mediaPlayer = MediaPlayer.create(this, R.raw.kbc_voice);
        mediaPlayer.start();
        nameStr = getIntent().getExtras().getString("name");
        emailStr = getIntent().getExtras().getString("email");

        setQuestionData();

        recycle_options.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        setQuestion(qCount - 1);
        setQuestionAdapter();
        saveNext.setOnClickListener(view -> {
            int i = qCount - 1;
            if (qCount <= questionListAll.size()) {
                for (int j = 0; j < questionListAll.get(i).getOptions().size(); j++) {
                    if (questionListAll.get(i).getOptions().get(j).isCheck()) {
                        questionListAll.get(i).setAnswer_given_option(questionListAll.get(i).getOptions().get(j).getId());
                    }
                }
            }
            if (qCount == questionListAll.size()) {
                CorrectCount = 0;
                wrongCount = 0;
                for (int index = 0; index < questionListAll.size(); index++) {
                    if (questionListAll.get(index).getAnswer_option() == questionListAll.get(index).getAnswer_given_option()) {
                        if (CorrectCount < questionListAll.size())
                            CorrectCount++;
                    } else {
                        if (wrongCount < questionListAll.size()) wrongCount++;
                    }
                }
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("name", nameStr);
                intent.putExtra("email", emailStr);
                intent.putExtra("total", questionListAll.size());
                intent.putExtra("CorrectCount", CorrectCount);
                intent.putExtra("wrongCount", wrongCount);
                startActivity(intent);
            }
            if (qCount != questionListAll.size()) {
                qCount++;
                setQuestion(qCount - 1);
            }

        });

        btn_previous.setOnClickListener(view -> {
            int i = qCount - 1;
            if (qCount >= questionListAll.size()) {
                for (int j = 0; j < questionListAll.get(i).getOptions().size(); j++) {
                    if (questionListAll.get(i).getOptions().get(j).isCheck()) {
                        questionListAll.get(i).setAnswer_given_option(questionListAll.get(i).getOptions().get(j).getId());
                    }
                }
            } else {
                Toast.makeText(this, "first Question", Toast.LENGTH_SHORT).show();
            }
            if (qCount != 1) {
                qCount--;
                setQuestion(qCount - 1);
            }
        });

    }


    private void setQuestion(int qCount) {
        currentQuestionOptionList = new ArrayList<>();
        currentQuestionOptionList = questionListAll.get(qCount).getOptions();
        tv_question_text.setText(questionListAll.get(qCount).getQuestions());
        setQuestionAdapter();
    }

    private void setQuestionAdapter() {
        OptionAdapter adapter = new OptionAdapter(this, currentQuestionOptionList);
        recycle_options.setAdapter(adapter);

    }

    private void setQuestionData() {
//        List<Options> optionsList1 = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            Options options = new Options(i, "Q1 Option" + i, false);
//            optionsList1.add(options);
//        }
//        Question question1 = new Question(1, "Question 1", optionsList1, 2);
//        questionListAll.add(question1);
//
//        List<Options> optionsList2 = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            Options options = new Options(i, "Q2 Option" + i, false);
//            optionsList2.add(options);
//        }
//        Question question2 = new Question(2, "Question 2", optionsList2, 2);
//        questionListAll.add(question2);
//

        for (int j = 1; j < 6; j++) {
            List<Options> optionsList3 = new ArrayList<>();
            for (int i = 1; i < 5; i++) {
                Options options = new Options(i, "Q" + j + " Option" + i, false);
                optionsList3.add(options);
            }
            Question question3 = new Question(2, "Question " + j, optionsList3, 2);
            questionListAll.add(question3);
        }
    }

}