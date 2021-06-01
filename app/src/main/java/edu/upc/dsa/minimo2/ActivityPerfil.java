package edu.upc.dsa.minimo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPerfil extends AppCompatActivity {
    EditText username;
    TextView nombre;
    TextView correo;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    AdaptadorRecycleView myAdapter;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        progressBar = findViewById(R.id.progress);
        Bundle bundle = getIntent().getExtras();
        username = findViewById(R.id.userName);
        nombre = findViewById(R.id.usernameObtenido);
        correo = findViewById(R.id.correoObtenido);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        context = getApplicationContext();

    }



    public void getUsuario(View view)
    {
        progressBar.setVisibility(View.VISIBLE);
        Call<Usuario> call = ApiClient.getUserService().getUser(username.getText().toString());
        Intent intent = new Intent(this,MainActivity.class);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.code() == 200) {
                    Usuario usuario = response.body();
                    progressBar.setVisibility(View.INVISIBLE);
                    nombre.setText(usuario.getUsername());
                    correo.setText(usuario.getCorreo());
                } else if (response.code() == 404) {
                    AlertDialog alertDialog = new AlertDialog.Builder(ActivityPerfil.this).create();

                    alertDialog.setMessage("NO SE HA ENCONTRADO");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();

                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                AlertDialog alertDialog = new AlertDialog.Builder (ActivityPerfil.this).create();

                alertDialog.setMessage("NO CONEXIÓN");
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




