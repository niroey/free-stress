package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnStressTest, btnStressManagement, btnStressRelief, btnDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStressTest = findViewById(R.id.btnStressTest);
        btnStressManagement = findViewById(R.id.btnStressManagement);
        btnStressRelief = findViewById(R.id.btnStressRelief);
        btnDiary = findViewById(R.id.btnDiary);

        btnStressTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StressTestActivity.class));
            }
        });

        btnStressManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StressManagementActivity.class));
            }
        });

        btnStressRelief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StressReliefActivity.class));
            }
        });

        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DiaryActivity.class));
            }
        });
    }
}
