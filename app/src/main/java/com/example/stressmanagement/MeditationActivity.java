package com.example.stressmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

public class MeditationActivity extends AppCompatActivity {

    Button btnMeditationTimer;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        btnMeditationTimer = findViewById(R.id.btnMeditationTimer);

        mediaPlayer = MediaPlayer.create(this, R.raw.meditation);
        startMeditation();
    }

    private void startMeditation() {
        btnMeditationTimer.setEnabled(false);

        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                long timeLeft = millisUntilFinished / 1000;
                btnMeditationTimer.setText("남은 시간: " + timeLeft + "초");
            }

            public void onFinish() {
                btnMeditationTimer.setText("명상 완료");
                btnMeditationTimer.setEnabled(true);
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
