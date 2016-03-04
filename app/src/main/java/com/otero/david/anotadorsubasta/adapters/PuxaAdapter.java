package com.otero.david.anotadorsubasta.adapters;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.otero.david.anotadorsubasta.Puxa;
import com.otero.david.anotadorsubasta.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by David on 16/02/2016.
 */
public class PuxaAdapter extends ArrayAdapter<Puxa>{

    List<Puxa> puxas;
    Activity context;

    public PuxaAdapter(Activity context, List puxas) {
        super(context, R.layout.puxa_item, puxas);
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
            item = inflater.inflate(R.layout.puxa_item, null);

            holder = new ViewHolder();
            holder.textView = (TextView) item.findViewById(R.id.textItemPuxa);
            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }
        holder.textView.setText(puxas.get(position).getStringPuxa());
        if(!puxas.get(position).isFeitas() && puxas.get(position).isAnotadas()){
            holder.textView.setPaintFlags(holder.textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        return (item);
    }

    class ViewHolder{
        TextView textView;
    }


}
