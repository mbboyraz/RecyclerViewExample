package com.example.mbura.staj10;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbura on 21.07.2017.
 */

public class ListAdapter  extends ArrayAdapter<CitiyProperties> implements CompoundButton.OnCheckedChangeListener {

    private ArrayList<CitiyProperties> list;
    private OnCheckChanged onCheckChanged;

    public ListAdapter(Context context, ArrayList<CitiyProperties> list, OnCheckChanged onCheckChanged) {
        super(context, R.layout.itemlistrow,  list);

        this.list = list;
        this.onCheckChanged = onCheckChanged;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        onCheckChanged.onCheckChanged();
    }

    static class ViewHolder {
        protected TextView text;
        protected CheckBox checkbox;
    }

   @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("hata","getView");
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.itemlistrow, null);
            final ViewHolder viewHolder = new ViewHolder();

            viewHolder.text = (TextView) v.findViewById(R.id.categoryId);
            viewHolder.checkbox = (CheckBox) v.findViewById(R.id.sec);
            viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,
                                                     boolean isChecked) {
                            CitiyProperties element = (CitiyProperties) viewHolder.checkbox.getTag();
                            viewHolder.checkbox.setSelected(buttonView.isChecked());

                        }
                    });
            v.setTag(viewHolder);
            viewHolder.checkbox.setTag(list.get(position));
        } else {
            v = convertView;
            ((ViewHolder) v.getTag()).checkbox.setTag(list.get(position));
        }
       ViewHolder holder = (ViewHolder) v.getTag();
       holder.text.setText(list.get(position).getCityName());
       holder.checkbox.setChecked(list.get(position).equals(true));





        CitiyProperties p = list.get(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.id);
            TextView tt2 = (TextView) v.findViewById(R.id.categoryId);
            TextView tt3 = (TextView) v.findViewById(R.id.description);
            CheckBox son=(CheckBox) v.findViewById(R.id.sec);
            if (tt1 != null) {
                tt1.setText(p.getCityName());
            }

            if (tt2 != null) {
                tt2.setText(p.getArea());
            }

            if (tt3 != null) {
                tt3.setText(p.getCityPlaka());
            }
        }

        holder.checkbox.setOnCheckedChangeListener(this);

        return v;
    }
}
