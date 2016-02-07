package com.otero.david.anotadorsubasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listNos, listVos, listPuxaNos, listPuxaVos;
    FloatingActionButton novaPuxa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNos = (ListView) findViewById(R.id.listaNos);
        listVos = (ListView) findViewById(R.id.listaVos);
        listPuxaNos = (ListView) findViewById(R.id.puxaNos);
        listPuxaVos = (ListView) findViewById(R.id.puxaVos);

        novaPuxa = (FloatingActionButton) findViewById(R.id.novaPuxa);

    }

    public void prueba(View v){
        Toast.makeText(getApplicationContext(), "Prueba", Toast.LENGTH_LONG).show();
    }

}
