package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lista_Atividade extends AppCompatActivity {

    Button btn_Add_nova_atividade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista__atividade);

        btn_Add_nova_atividade = (Button) findViewById(R.id.btn_Add_nova_atividade);

        btn_Add_nova_atividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirNovaAtividade();
            }
        });

    }

    private void AbrirNovaAtividade() {
        startActivity(new Intent(Lista_Atividade.this, Cadastro_Atividade.class));

    }
}