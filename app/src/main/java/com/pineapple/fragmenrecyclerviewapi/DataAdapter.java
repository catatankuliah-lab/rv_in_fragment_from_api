package com.pineapple.fragmenrecyclerviewapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// TODO : langkah 4, extends ke RecyclerView.Adapter<DataAdapter.DataViewHolder>
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    // TODO : langkah 5, buat sebuah attribute ArrayList atau list untuk menampung data yang akan di generate dari API
    private final ArrayList<Data> dataArrayList;

    // TODO : langkah 6, buat constructor dari class DataAdapter


    public DataAdapter(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // TODO : langkah 7, buat layout inflater dan assignment dari parent.getContext()
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // TODO : langkah 8, buat View dan assignment dari layout inflater pada todo 7, kemudian masukan item_data.xml
        View view = layoutInflater.inflate(R.layout.item_data, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        // TODO : langkah 9, assignment attribute pada ViewHolder dari ArrayList yang dibuat
        holder.tvData1.setText(dataArrayList.get(position).getData1());
        holder.tvData2.setText(dataArrayList.get(position).getData2());
    }

    @Override
    public int getItemCount() {
        // TODO : langkah 10, return sebuah int yang merupakan panjang dari ArrayList yang dibuat
        return (dataArrayList != null) ? dataArrayList.size() : 0;
    }

    // TODO : langkah 1, buat sebuah inner class dengan nama DataViewHolder
    static class DataViewHolder extends RecyclerView.ViewHolder {

        // TODO : langkah 2, buat deklarasi attribute yang dibutuhkan
        TextView tvData1;
        TextView tvData2;

        // TODO : langkah 3, buat sebuah constructor dari class DataViewHolder
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            // TODO : 3, buat assignment dari masing masing attribute dengan id pada layout item_data
            tvData1 = itemView.findViewById(R.id.tv_data1);
            tvData2 = itemView.findViewById(R.id.tv_data2);
        }
    }

}
