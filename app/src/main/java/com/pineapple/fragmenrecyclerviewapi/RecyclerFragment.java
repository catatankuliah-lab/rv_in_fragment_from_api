package com.pineapple.fragmenrecyclerviewapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RecyclerFragment extends Fragment {

    // TODO : langkah 1, buat sebuah attribute ArrayList atau list untuk menampung data yang akan di generate dari API
    private ArrayList<Data> dataArrayList;

    // TODO : langkah 2, deklarasikan sebuah RecyclerView
    RecyclerView rvData;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // TODO : langkah 3, buat layout inflater dan assignment dari getContext()
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        // TODO : langkah 4, buat View dan assignment dari layout inflater pada todo 3, kemudian masukan layout fragment
        View view = layoutInflater.inflate(R.layout.fragment_recycler, container, false);

        // TODO : langkah 5, assignment RecyclerView dengan id recycler view pada fragment_recycler.xml
        rvData = view.findViewById(R.id.rv_view);

        // TODO : langkah 6, set layout manager
        rvData.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // TODO : langkah 7, set adapter
        rvData.setAdapter(new DataAdapter(dataArrayList));

        // TODO : langkah 9, jalankan method getData()
        getData();

        return view;
    }

    // TODO : langkah 8, buat method untuk mengambil data dari API
    private void getData() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://lapor.desa.cisantana.id/API/Profile/Search?nama=Riza&api_key=QDZQQBQOMUFUJoAa7pstFXEmiwwZPPac";
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                ArrayList<Data> dataArrayList = new ArrayList<>();
                String result = new String(responseBody);
                Log.d("Success", result);
                try {
                    JSONObject jsonObject1 = new JSONObject(result);
                    JSONArray dataArray = jsonObject1.getJSONArray("data");
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject jsonObject = dataArray.getJSONObject(i);
                        String id = jsonObject.getString("ID");
                        String nama = jsonObject.getString("Nama");
                        dataArrayList.add(new Data(
                                id,nama
                        ));
                    }
                    DataAdapter adapter = new DataAdapter(dataArrayList);
                    rvData.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        }
        );
    }
}