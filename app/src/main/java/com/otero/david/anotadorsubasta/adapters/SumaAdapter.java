package com.otero.david.anotadorsubasta.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.otero.david.anotadorsubasta.Puxa;
import com.otero.david.anotadorsubasta.R;
import com.otero.david.anotadorsubasta.utils.Globals;

import java.util.List;

/**
 * Created by David on 23/02/2016.
 */
public class SumaAdapter extends ArrayAdapter<Puxa> {

    private List<Puxa> puxas;
    private Activity context;

    public SumaAdapter(Activity context, List<Puxa> puxas) {
        super(context, R.layout.suma_item, puxas);
        this.puxas = puxas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return puxas.size();
    }

    @Override
    public Puxa getItem(int position) {
        return (Puxa) puxas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;
        if(item == null){
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.suma_item, null);

            holder = new ViewHolder();
            holder.total = (TextView) item.findViewById(R.id.total);
            holder.suma = (TextView) item.findViewById(R.id.nuevaSuma);
            item.setTag(holder);
            if(position == 0){
                holder.total.setText(puxas.get(position).getStringPuxa());
            }else{
                View itemAnterior = parent.getChildAt(position - 1);
                ViewHolder holderAnterior = new ViewHolder();
                holderAnterior.suma = (TextView) itemAnterior.findViewById(R.id.nuevaSuma);
                holder.total = (TextView) item.findViewById(R.id.total);
                itemAnterior.setTag(holderAnterior);
                item.setTag(holder);
                holderAnterior.suma.setText(puxas.get(position).getStringPuxa());
                holder.total.setText(getTotal(puxas, position));
            }
        }else{
            holder = (ViewHolder) item.getTag();
        }
        return (item);
    }

    private String getTotal(List<Puxa> puxas, int pos){
        int total = 0;
        for (int i = 0; i <= pos; i++) {
            Puxa puxa = puxas.get(i);
            total += puxa.getPuxa();
        }
        return String.valueOf(total);
    }

    class ViewHolder {
        TextView total;
        TextView suma;
    }

}
