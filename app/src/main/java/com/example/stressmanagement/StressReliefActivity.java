package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StressReliefActivity extends AppCompatActivity {

    Button btnMeditation, btnBreathingExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_relief);

        btnMeditation = findViewById(R.id.btnMeditation);
        btnBreathingExercise = findViewById(R.id.btnBreathingExercise);

        btnMeditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StressReliefActivity.this, MeditationActivity.class);
                startActivity(intent);
            }
        });

        btnBreathingExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StressReliefActivity.this, BreathingExerciseActivity.class);
                startActivity(intent);
            }
        });
    }
}
