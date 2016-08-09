package com.example.moham.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button playerBtn, computerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        playerBtn = (Button) findViewById(R.id.player_btn);
        computerBtn = (Button) findViewById(R.id.computer_btn);

        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, PlayActivity.class);
                intent.putExtra("player", 2);
                startActivity(intent);
            }
        });


        computerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, PlayActivity.class);
                intent.putExtra("player", 1);
                startActivity(intent);
            }
        });


    }


}
