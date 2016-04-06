package com.aymerichaase.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Reponse extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse);
        txtResult = (TextView) findViewById(R.id.txtResult);


        Bundle extras = getIntent().getExtras();
        String result = extras.getString("reponse");
        int nb = extras.getInt("nb");

        txtResult.setText("Le resultat est : " + nb*10 + " %");

    }
}
