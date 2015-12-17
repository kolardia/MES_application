package com.kolardia.mesapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DaneActivityActivity extends ActionBarActivity {

    //deklarowanie zmiennych
    EditText wprowadzIloscElementowLokalnych;
    EditText wprowadzIloscPrzedzialow;
    EditText wprowadzP;
    EditText wprowadzL;
    EditText wprowadzF;
    EditText wprowadzJ;
    EditText wprowadzE;
    EditText wprowadzA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dane);

        //Przypisanie do zmiennych obiektow
        wprowadzIloscElementowLokalnych = (EditText) findViewById(R.id.edit_lokalne_elementy);
        wprowadzIloscPrzedzialow = (EditText)findViewById(R.id.edit_przedzial_elementow);
        wprowadzP = (EditText)findViewById(R.id.edit_P);
        wprowadzL = (EditText)findViewById(R.id.edit_L);
        wprowadzF = (EditText)findViewById(R.id.edit_F);
        wprowadzE = (EditText)findViewById(R.id.edit_E);
        wprowadzJ = (EditText)findViewById(R.id.edit_J);
        wprowadzA = (EditText)findViewById(R.id.edit_A);
        Button btnWykaz = (Button)findViewById(R.id.button_wykaz);

        //W³¹czenie nas³uchu dla zdarzeñ
        btnWykaz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Wywo³anie nowej aktywnoœci
                Intent nowyEkran = new Intent(getApplicationContext(), MesActivity.class);

                //Wysy³anie danych do drugiej aktywnoœci
                nowyEkran.putExtra("IloscElementowLokalnych", wprowadzIloscElementowLokalnych.getText().toString());
                nowyEkran.putExtra("IloscPrzedzialow",wprowadzIloscPrzedzialow.getText().toString());
                nowyEkran.putExtra("L",wprowadzL.getText().toString());
                nowyEkran.putExtra("F",wprowadzF.getText().toString());
                nowyEkran.putExtra("P",wprowadzP.getText().toString());
                nowyEkran.putExtra("J",wprowadzJ.getText().toString());
                nowyEkran.putExtra("E",wprowadzE.getText().toString());
                nowyEkran.putExtra("A",wprowadzA.getText().toString());
                startActivity(nowyEkran);
            }
        });
    }

}