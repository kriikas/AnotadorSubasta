package com.otero.david.anotadorsubasta.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.otero.david.anotadorsubasta.R;

public class InfoPuxa extends AppCompatActivity {

    EditText puxa;
    Spinner playersPuxa;
    Spinner triunfo;
    Button puxaOk;
    Button puxaCancel;

    Integer numPuxa;
    String sPlayers;
    String sTriunfo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_puxa);
        puxa = (EditText) findViewById(R.id.puxa);
        puxa.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        playersPuxa = (Spinner) findViewById(R.id.playersPuxa);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.players, android.R.layout.simple_spinner_dropdown_item);

        playersPuxa.setAdapter(adapter);

        playersPuxa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sPlayers = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        triunfo = (Spinner) findViewById(R.id.triunfo);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.palos, android.R.layout.simple_spinner_dropdown_item);

        triunfo.setAdapter(adapter1);

        triunfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sTriunfo = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        puxaOk = (Button) findViewById(R.id.puxaOk);
        puxaCancel = (Button) findViewById(R.id.puxaCancel);

        puxaOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //numPuxa = Integer.parseInt(puxa.getText().toString());

                if(Integer.parseInt(puxa.getText().toString())%5 != 0 ||
                        Integer.parseInt(puxa.getText().toString()) > 230 ||
                            Integer.parseInt(puxa.getText().toString()) < 5){
                    Toast.makeText(InfoPuxa.this, "Comproba a puxa", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(InfoPuxa.this, MainActivity.class);
                    i.putExtra("puxa", puxa.getText().toString());
                    i.putExtra("players", sPlayers);
                    i.putExtra("triunfo", sTriunfo);

                    setResult(RESULT_OK, i);
                    finish();
                }

            }
        });

    }

}
