package com.nta.ktragk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseSongs extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btnChon;
    TextView txtChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_songs);
        getViews();
        Intent intent = getIntent();
    }

    private void getViews() {

        txtChoose = findViewById(R.id.txtChoose);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                txtChoose.setText("1");
                break;
            case R.id.btn2:
                txtChoose.setText("2");
                break;
            case R.id.btn3:
                txtChoose.setText("3");
                break;
            case R.id.btn4:
                txtChoose.setText("4");
                break;
            case R.id.btn5:
                txtChoose.setText("5");
                break;
            case R.id.btn6:
                txtChoose.setText("6");
                break;
            case R.id.btnChon:
                Intent intent = new Intent();
                intent.putExtra("choose", txtChoose.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}