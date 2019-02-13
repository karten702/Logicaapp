package com.example.logicaapp;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout answer1;
    private TextInputLayout answer2;
    private TextInputLayout answer3;
    private TextInputLayout answer4;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = findViewById(R.id.textInputLayout);
        answer2 = findViewById(R.id.textInputLayout2);
        answer3 = findViewById(R.id.textInputLayout3);
        answer4 = findViewById(R.id.textInputLayout4);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswers();
            }
        });
    }

    private void CheckAnswers() {
        String answerString1 = GetAnswerFromInput(answer1);
        String answerString2 = GetAnswerFromInput(answer2);
        String answerString3 = GetAnswerFromInput(answer3);
        String answerString4 = GetAnswerFromInput(answer4);
        if (answerString1.toLowerCase() == "t" && answerString2.toLowerCase() == "f" && answerString3.toLowerCase() == "f" && answerString4.toLowerCase() == "t"){
            Toast.makeText(this, getString(R.string.answerCorrect), Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, getString(R.string.answerIncorrect), Toast.LENGTH_SHORT).show();
    }

    private String GetAnswerFromInput(TextInputLayout editor){
        String value = "";
        if(editor.getEditText().getText().length() > 1){
            value = editor.getEditText().getText().toString();
        }
        return value;
    }

}
