package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lista_Notas extends AppCompatActivity {

    Button btn_Add_nova_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista__notas);

        btn_Add_nova_nota = (Button) findViewById(R.id.btn_Add_nova_nota);

        btn_Add_nova_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirNovaNota();
            }
        });

    }

    private void AbrirNovaNota() {
        startActivity(new Intent(Lista_Notas.this, Cadastro_Notas.class));

    }
}