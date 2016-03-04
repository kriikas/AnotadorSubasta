package com.otero.david.anotadorsubasta.activities;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.otero.david.anotadorsubasta.Puxa;
import com.otero.david.anotadorsubasta.R;
import com.otero.david.anotadorsubasta.adapters.PuxaAdapter;
import com.otero.david.anotadorsubasta.adapters.SumaAdapter;
import com.otero.david.anotadorsubasta.utils.Globals;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener{

    ListView sumaNos, sumaVos, listPuxaNos, listPuxaVos, prueba;
    FloatingActionButton novaPuxa;
    CharSequence puxa;
    //ArrayAdapter<CharSequence> adapterPuxasNos, adapterPuxasVos, adapterSumaNos, adapterSumaVos;
    PuxaAdapter adapterPuxasNos, adapterPuxasVos;
    List<Puxa> puxasNos, puxasVos, sumasNos, sumasVos;
    SumaAdapter adapterSumaNos, adapterSumaVos;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumaNos = (ListView) findViewById(R.id.listaNos);
        sumaVos = (ListView) findViewById(R.id.listaVos);
        listPuxaNos = (ListView) findViewById(R.id.puxaNos);
        listPuxaVos = (ListView) findViewById(R.id.puxaVos);

        novaPuxa = (FloatingActionButton) findViewById(R.id.novaPuxa);

        puxasVos = new ArrayList<>();
        puxasNos = new ArrayList<>();
        sumasNos = new ArrayList<>();
        sumasVos = new ArrayList<>();

        adapterPuxasNos = new PuxaAdapter(this, puxasNos);
        adapterPuxasVos = new PuxaAdapter(this, puxasVos);

        adapterSumaNos = new SumaAdapter(this, sumasNos);
        adapterSumaVos = new SumaAdapter(this, sumasVos);

        listPuxaNos.setAdapter(adapterPuxasNos);
        listPuxaVos.setAdapter(adapterPuxasVos);
        sumaNos.setAdapter(adapterSumaNos);
        sumaVos.setAdapter(adapterSumaVos);

        listPuxaNos.setOnItemClickListener(this);
        listPuxaNos.setOnItemLongClickListener(this);

        listPuxaVos.setOnItemClickListener(this);
        listPuxaVos.setOnItemLongClickListener(this);

        novaPuxa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoPuxa.class);
                startActivityForResult(i, 1234);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK) {
            List<Puxa> puxas;
            if (data.getExtras().getString("players").equals("Nos")) {
                puxas = puxasNos;
            } else {
                puxas = puxasVos;
            }
            Puxa puxa = new Puxa(data.getExtras().getString("puxa"), data.getExtras().getString("players"), puxas.size());
            puxas.add(puxa);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //parent.getSelectedView().setBackgroundResource(R.color.verde);
        view.setBackgroundResource(R.color.verde);
        //view.invalidate();
        Puxa puxa = (Puxa) parent.getItemAtPosition(position);
        if(puxa.isAnotadas()){
            if(sumasNos.contains(puxa)){
                sumasNos.remove(puxa);
                puxa.setAnotadas(false);
            }
            if(sumasVos.contains(puxa)){
                sumasVos.remove(puxa);
                puxa.setAnotadas(false);
            }
        }
        puxa.setFeitas(true);
        //puxa.setAnotadas(true);
        sumaPuxas(puxa);
        sumaNos.setAdapter(adapterSumaNos);
        sumaVos.setAdapter(adapterSumaVos);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        view.setBackgroundResource(R.color.rojo);
        //(TextView)view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        Puxa puxa = (Puxa) parent.getItemAtPosition(position);
        if(puxa.isAnotadas()){
            if(sumasNos.contains(puxa)){
                sumasNos.remove(puxa);
                puxa.setAnotadas(false);
            }
            if(sumasVos.contains(puxa)){
                sumasVos.remove(puxa);
                puxa.setAnotadas(false);
            }
        }
        puxa.setFeitas(false);
        //puxa.setAnotadas(true);
        sumaPuxas(puxa);
        sumaNos.setAdapter(adapterSumaNos);
        sumaVos.setAdapter(adapterSumaVos);
        return true;
    }

    private void sumaPuxas(Puxa puxa){
        switch (puxa.getJugadores().toString()){
            case Globals.TITLE_NOS:
                if(!puxa.isAnotadas()) {
                    if (puxa.isFeitas()) {
                        if(puxa.getPos() <= sumasNos.size()) {
                            sumasNos.add(puxa.getPos(), puxa);
                        }else{
                            sumasNos.add(puxa);
                        }
                    }else{
                        if(puxa.getPos() <= sumasVos.size()) {
                            sumasVos.add(puxa.getPos(), puxa);
                        }else{
                            sumasVos.add(puxa);
                        }
                    }
                }
                break;
            case Globals.TITLE_VOS:
                if(!puxa.isAnotadas()) {
                    if (puxa.isFeitas()) {
                        if(puxa.getPos() <= sumasVos.size()) {
                            sumasVos.add(puxa.getPos(), puxa);
                        }else{
                            sumasVos.add(puxa);
                        }
                    }else{
                        if(puxa.getPos() <= sumasNos.size()) {
                            sumasNos.add(puxa.getPos(), puxa);
                        }else{
                            sumasNos.add(puxa);
                        }
                    }
                }
                break;
        }
        puxa.setAnotadas(true);
    }

}


