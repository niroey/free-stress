package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.DatePicker;

public class ViewDiaryActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView diaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diary);

        datePicker = findViewById(R.id.datepicker);
        diaryTextView = findViewById(R.id.diary_text_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    loadDiary(year, monthOfYear + 1, dayOfMonth);
                }
            });
        }
    }

    private void loadDiary(int year, int month, int day) {
        SharedPreferences sharedPreferences = getSharedPreferences("diary", MODE_PRIVATE);
        String diaryContent = sharedPreferences.getString(year + "-" + month + "-" + day, "일기가 없습니다.");
        diaryTextView.setText(diaryContent);
    }
}