package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class StressTestActivity extends AppCompatActivity {

    TextView textViewQuestion;
    RadioGroup radioGroup;
    Button btnNext;
    int currentQuestionIndex = 0;
    int stressLevel = 0;
    String[] questions = {
            "1. 나는 가끔 초조하거나 불안하거나 조마조마함을 느낀다.",
            "2. 나는 여러 가지 것들에 대해 걱정을 너무 많이 한다.",
            "3. 나는 가끔 쉽게 짜증이 나거나 쉽게 성을 내게 된다.",
            "4. 나는 가끔 너무 안절부절 못해서 가만히 있기가 힘들다.",
            "5. 나는 가끔 걱정하는 것들을 멈추거나 조절할 수가 없다.",
            "6. 나는 가끔 편하게 있기가 어렵다.",
            "7. 나는 마치 끔찍한 일이 생길 것 처럼 두렵게 느껴진다."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_test);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        btnNext = findViewById(R.id.btnNext);

        textViewQuestion.setText(questions[currentQuestionIndex]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(StressTestActivity.this, "답변을 선택해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = findViewById(selectedId);
                    int answerValue = getAnswerValue(radioButton.getText().toString());
                    stressLevel += answerValue;

                    if (currentQuestionIndex < questions.length - 1) {
                        currentQuestionIndex++;
                        textViewQuestion.setText(questions[currentQuestionIndex]);
                        radioGroup.clearCheck();
                    } else {
                        // 테스트 종료
                        displayStressLevel();
                    }
                }
            }
        });
    }

    private int getAnswerValue(String answer) {
        if (answer.equals("전혀 그렇지 않다")) {
            return 0;
        } else if (answer.equals("가끔 그렇다")) {
            return 1;
        } else if (answer.equals("자주 그렇다")) {
            return 2;
        } else {
            return 3;
        }
    }

    private void displayStressLevel() {
        String stressMessage;
        if (stressLevel <= 1) {
            stressMessage = "\n스트레스가 적음.\n\n일상에서 스트레스를 관리하고 예방하기 위해\n프리스트레스 어플을 사용해보세요!";
        } else if (stressLevel <= 3) {
            stressMessage = "\n스트레스 약간 있음.\n\n프리스트레스 어플을 활용하여\n스트레스를 조절하고 효과적으로 관리해보세요!";
        } else if (stressLevel <= 5) {
            stressMessage = "\n스트레스 보통.\n\n프리스트레스 어플을 통해\n스트레스를 완화하고 편안한 마음을 찾아보세요!";
        } else {
            stressMessage = "\n스트레스 많음.\n\n프리스트레스 어플을 사용하여\n스트레스를 관리하고 건강한 삶을 살아보세요!";
        }

        Intent intent = new Intent(StressTestActivity.this, StressTestResultActivity.class);
        intent.putExtra("stressLevel", stressLevel);
        intent.putExtra("stressMessage", stressMessage);
        startActivity(intent);
    }
}
