package com.example.minim2_v4;
import android.app.AlertDialog;
import android.app.ProgressDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
//import android.support.v7.widget.LinearLayoutManager;
///import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;

public class ListActivity extends MainActivity{
    private MuseoApi myMuseoApi;
    TextView textViewNombre;
    ImageView  imageViewMuseo;
    public List<Element> data;

    public Recycler recycler;
    public RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
