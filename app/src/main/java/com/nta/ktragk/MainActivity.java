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

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    Button btnChoose, btnPlay,btnPause;
    TextView txtNumber, txtName, txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();

    }

    public void playMusic(View v){
        music.start();
    }

    public  void pauseMusic(View v){
        music.pause();
    }

    public void chooseSongs(View v){
        Intent intent = new Intent(this,ChooseSongs.class);
        chooseSongs.launch(intent);
    }

    ActivityResultLauncher<Intent> chooseSongs = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Log.d(TAG,)
                        }
                    }
            );

    private void getViews(){
        btnChoose = findViewById(R.id.btnChoose);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        txtNumber = findViewById(R.id.txtNumber);
        txtName= findViewById(R.id.txtName);
        txtTime = findViewById(R.id.txtTime);
    }
}