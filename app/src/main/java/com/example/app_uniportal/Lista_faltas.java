package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lista_faltas extends AppCompatActivity {

    Button btn_Add_nova_falta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_faltas);

        btn_Add_nova_falta = (Button) findViewById(R.id.btn_Add_nova_falta);

        btn_Add_nova_falta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirNovaFaltas();
            }
        });


    }

    private void AbrirNovaFaltas() {
        startActivity(new Intent(Lista_faltas.this, Cadastro_Faltas.class));

    }



}