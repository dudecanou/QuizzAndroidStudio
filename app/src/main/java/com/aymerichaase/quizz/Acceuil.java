package com.aymerichaase.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


public class Acceuil extends Activity {
    Intent unIntent;
    Button btnQuizz = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        btnQuizz = (Button) findViewById(R.id.btnStart);
        unIntent = new Intent(this, MainActivity.class);

        btnQuizz.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(unIntent);
            }
        });

    }

}
