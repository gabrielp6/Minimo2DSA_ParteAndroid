package edu.upc.dsa.minimo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void abrirInsignias(View view){
        Intent intent = new Intent(this, ActivityInsignias.class);
        startActivity(intent);

    }

    public void abrirPerfil(View view){
        Intent intent = new Intent(this, ActivityPerfil.class);
        startActivity(intent);
    }
}