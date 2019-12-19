package com.example.minim2_v4;
import android.app.AlertDialog;
import android.app.ProgressDialog;
//import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;

///import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private LinearLayout linear;
    public Recycler recycler;
    public RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recycler = new Recycler(this);
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);


        textViewNombre = findViewById(R.id.nombremuseo);
        imageViewMuseo = findViewById(R.id.imagenmuseo);




        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando museos...");
        progressDialog.setMessage("Espere a que el servidor responda");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();


        myMuseoApi = MuseoApi.retrofit.create(MuseoApi.class);

        getData();



    }
    private void getData(){

        Call<Museums> elementCall = myMuseoApi.getData(1,11);

        elementCall.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                if(response.isSuccessful()){
                    Museums museo = response.body();

                    data = museo.getElements();
                    recycler.rellenarLista(data);
                    progressDialog.hide();

                }else{
                    progressDialog.hide();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListActivity.this);

                    alertDialogBuilder
                            .setTitle("Error")
                            .setMessage(response.message())
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();


                }

            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {

                progressDialog.hide();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListActivity.this);

                alertDialogBuilder
                        .setTitle("Error")
                        .setMessage(t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });


    }

}
