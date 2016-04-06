package com.aymerichaase.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    String question;
    String[] choice;
    String reponse;
    TextView txtQuestion = null;
    ListView lvChoix = null;
    int j = 1;
    Button btnStart = null;
    Intent unIntent;
    ArrayList<String> resultat = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvChoix = (ListView) findViewById(R.id.lvChoix);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        btnStart = (Button) findViewById(R.id.btnStart);
        unIntent = new Intent(this, Reponse.class);

        question = getResources().getString(R.string.quizz0);
        choice = getResources().getStringArray(R.array.choix0);
        reponse = getResources().getString(R.string.reponse0);

        txtQuestion.setText(question);

        ArrayAdapter<String> monAdapteur = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, choice);
        lvChoix.setAdapter(monAdapteur);

        lvChoix.setItemsCanFocus(false);
        lvChoix.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                selection();
            }
        });
    }


// ------------------------------ BUILD QUIZZ ---------------------------------
    public void Start() {
if (j<=9) {
    question = getResources().getString(R.string.quizz0 + j);
    choice = getResources().getStringArray(R.array.choix0 + j);
    reponse = getResources().getString(R.string.reponse0 + j);

    txtQuestion.setText(question);


    ArrayAdapter<String> monAdapteur = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_single_choice, choice);
    lvChoix.setAdapter(monAdapteur);

    lvChoix.setItemsCanFocus(false);
    lvChoix.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    btnStart.setOnClickListener(new Button.OnClickListener() {
        public void onClick(View v) {
            selection();
        }
    });
}
        else
{
    Toast.makeText(MainActivity.this, "fin", Toast.LENGTH_SHORT).show();
    unIntent.putExtra("nb",resultat.size());
    unIntent.putExtra("reponse", String.valueOf(resultat));
    startActivity(unIntent);
}
    }



public void selection() {
    String selection = "";
    int nbChoix = lvChoix.getCount();
    int choix = lvChoix.getCheckedItemCount();
    SparseBooleanArray sparseBooleanArray = lvChoix.getCheckedItemPositions();

    if (choix < 1) {
        Toast.makeText(MainActivity.this, "Selctionner une reponse!!", Toast.LENGTH_SHORT).show();
    } else {
        for (int i = 0; i < nbChoix; i++) {
            if (sparseBooleanArray.get(i)) {
                selection = lvChoix.getItemAtPosition(i).toString();
            }
        }
    }
    String rep = reponse.trim();
    String selec = selection.trim();

    //unIntent.putExtra("result" + j, String.valueOf(point));

    if (selec.equals(rep))
    {
        resultat.add(rep);
        Start();

        j++;

    }
    else
    {
        Start();
        j++;
    }

}

}
