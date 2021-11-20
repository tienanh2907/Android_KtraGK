package com.nta.ktragk;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    Button btnChoose, btnPlay, btnPause;
    TextView txtNumber, txtName, txtTime;
    int[] idSongs = {
            R.raw.easy_on_me,
            R.raw.fancy_like,
            R.raw.industry_baby,
            R.raw.kiss_me_more,
            R.raw.need_to_know,
            R.raw.stay
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
    }

    public void playMusic(View v) {
        music.start();
    }

    public void pauseMusic(View v) {
        music.pause();
    }

    public void chooseSongs(View v) {
        Intent intent = new Intent(this, ChooseSongs.class);
        activityLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            String choose = intent.getStringExtra("choose");

                            switch (choose) {
                                case "1":
                                    viewSong(idSongs[0],choose,"Easy On Me");
                                    break;
                                case "2":
                                    viewSong(idSongs[1],choose,"Fancy Like");
                                    break;
                                case "3":
                                    viewSong(idSongs[2],choose,"Industry baby");
                                    break;
                                case "4":
                                    viewSong(idSongs[3],choose," Kiss me more");
                                    break;
                                case "5":
                                    viewSong(idSongs[4],choose,"Need To Know");
                                    break;
                                case "6":
                                    viewSong(idSongs[5],choose,"Stay");
                                    break;
                            }
                        }
                    }
                }
            }
    );

    public void viewSong(int id,String number,String name) {
        if(music.isPlaying()){
            music.release();
        }
        music = MediaPlayer.create(this, id);
        double finalTime = music.getDuration();
        txtNumber.setText(number);
        txtName.setText(name);
        txtTime.setText(String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime)))
        );
    }

    private void getViews() {
        btnChoose = findViewById(R.id.btnChoose);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        txtNumber = findViewById(R.id.txtNumber);
        txtName = findViewById(R.id.txtName);
        txtTime = findViewById(R.id.txtTime);
    }
}