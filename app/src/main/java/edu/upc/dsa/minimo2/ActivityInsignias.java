package edu.upc.dsa.minimo2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ActivityInsignias extends AppCompatActivity {
    ProgressBar progressBar;
    RecyclerView recyclerView;
    AdaptadorRecycleView myAdapter;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insignias);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        progressBar = findViewById(R.id.progress);
        Bundle bundle = getIntent().getExtras();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        getAllInsignias();
        context = getApplicationContext();

    }



    public void getAllInsignias()
    {
        Call<List<Insignia>> call = ApiClient.getUserService().getAllInsignias();
        call.enqueue(new Callback<List<Insignia>>()
        {
            @Override
            public void onResponse(Call<List<Insignia>> call, Response<List<Insignia>> response)
            {
                List<Insignia> insignias = response.body();
                myAdapter = new AdaptadorRecycleView();
                myAdapter.setData(insignias);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<List<Insignia>> call, Throwable t)
            {
                AlertDialog alertDialog = new AlertDialog.Builder (ActivityInsignias.this).create();

                alertDialog.setMessage("ERROR");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();

            }
        });


    }

}