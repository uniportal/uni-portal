package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Painel_professor extends AppCompatActivity {

    Button btn_add_ativ,btn_add_nota,btn_add_faltas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_professor);

        btn_add_ativ = (Button) findViewById(R.id.btn_add_ativ);
        btn_add_nota = (Button) findViewById(R.id.btn_add_nota);
        btn_add_faltas = (Button) findViewById(R.id.btn_add_faltas);


        // <-- Abrindo tela Lista Atividades -->

        btn_add_ativ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirListaAtividades();
            }
        });

// <-- Abrindo tela Lista Notas -->

        btn_add_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirListaNotas();
            }
        });

        // <-- Abrindo tela Lista Faltas -->

        btn_add_faltas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirListaFaltas();
            }
        });

    }

    private void AbrirListaAtividades() {
        startActivity(new Intent(Painel_professor.this, Lista_Atividade.class));

    }

    private void AbrirListaNotas() {
        startActivity(new Intent(Painel_professor.this, Lista_Notas.class));

    }

    private void AbrirListaFaltas() {
        startActivity(new Intent(Painel_professor.this, Lista_faltas.class));

    }

}