package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.Toast;

public class BreathingExerciseActivity extends AppCompatActivity {

    Button btnBreathingExerciseTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);

        btnBreathingExerciseTimer = findViewById(R.id.btnBreathingExerciseTimer);
        startBreathingExercise();
    }

    private void startBreathingExercise() {
        btnBreathingExerciseTimer.setEnabled(false);
        new CountDownTimer(40000, 10000) {
            int count = 0;

            public void onTick(long millisUntilFinished) {
                if (count % 2 == 0) {
                    Toast.makeText(BreathingExerciseActivity.this, "숨을 들이마세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BreathingExerciseActivity.this, "숨을 내쉬세요", Toast.LENGTH_SHORT).show();
                }
                count++;
            }

            public void onFinish() {
                btnBreathingExerciseTimer.setEnabled(true);
                Toast.makeText(BreathingExerciseActivity.this, "호흡 운동이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}
