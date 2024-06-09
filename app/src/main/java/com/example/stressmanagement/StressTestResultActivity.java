package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StressTestResultActivity extends AppCompatActivity {

    TextView textViewResult, textViewSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_test_result);

        textViewResult = findViewById(R.id.textViewResult);
        textViewSource = findViewById(R.id.textViewSource);

        int stressLevel = getIntent().getIntExtra("stressLevel", 0);
        String stressMessage = getIntent().getStringExtra("stressMessage");

        textViewResult.setText("스트레스 레벨: " + stressLevel + "\n" + stressMessage);
        textViewSource.setText("출처: - Spitzer RL, Kroenke K, Williams JB, et al.(2006). A brief measure for assessing generalized anxiety disorder: the GAD-7, Arch Intern Med 166, 1092-7\n");
    }
}
