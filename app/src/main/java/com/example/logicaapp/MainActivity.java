package com.example.logicaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText answer1;
    private EditText answer2;
    private EditText answer3;
    private EditText answer4;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = findViewById(R.id.Editor1);
        answer2 = findViewById(R.id.editor2);
        answer3 = findViewById(R.id.editor3);
        answer4 = findViewById(R.id.editor4);
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
        if (answerString1.equalsIgnoreCase("t") && answerString2.equalsIgnoreCase("f") && answerString3.equalsIgnoreCase("f") && answerString4.equalsIgnoreCase("t")){
            Toast.makeText(this, getString(R.string.answerCorrect), Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, getString(R.string.answerIncorrect), Toast.LENGTH_SHORT).show();
    }

    private String GetAnswerFromInput(EditText editor){
        String value = "";

        if(editor.getEditableText().length() > 0){
            value = editor.getEditableText().toString();
        }
        return value;
    }

}
