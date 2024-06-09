package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class DiaryActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button saveButton, viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        datePicker = findViewById(R.id.datepicker);
        editText = findViewById(R.id.edit_text);
        saveButton = findViewById(R.id.save_button);
        viewButton = findViewById(R.id.view_button);

        saveButton.setEnabled(false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    saveButton.setEnabled(true);
                }
            });
        }

        saveButton.setOnClickListener(v -> saveDiary());

        viewButton.setOnClickListener(v -> {
            Intent intent = new Intent(DiaryActivity.this, ViewDiaryActivity.class);
            startActivity(intent);
        });
    }

    private void saveDiary() {
        int year = datePicker.getYear();
        int month = datePicker.getMonth() + 1;
        int day = datePicker.getDayOfMonth();

        String diaryContent = editText.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("diary", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(year + "-" + month + "-" + day, diaryContent);
        editor.apply();

        Toast.makeText(this, "일기가 저장되었습니다.", Toast.LENGTH_SHORT).show();

        saveButton.setEnabled(false);
    }
}