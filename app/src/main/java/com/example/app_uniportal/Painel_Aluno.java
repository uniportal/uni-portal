package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Painel_Aluno extends AppCompatActivity {

    TextView btn_acessar;
    Button btn_acessar_Notas,btn_acessar_Faltas,btn_acessar_Atividades,btn_acessar_Mansalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_aluno);

        btn_acessar = (TextView) findViewById(R.id.btn_acessar);
        btn_acessar_Notas = (Button) findViewById(R.id.btn_acessar_Notas);
        btn_acessar_Faltas = (Button) findViewById(R.id.btn_acessar_Faltas);
        btn_acessar_Atividades = (Button) findViewById(R.id.btn_acessar_Atividades);
        btn_acessar_Mansalidade = (Button) findViewById(R.id.btn_acessar_Mansalidade);



        btn_acessar_Notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirNotas();
            }
        });

        btn_acessar_Faltas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirFaltas();
            }
        });


        btn_acessar_Atividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirAtividade();
            }
        });


        btn_acessar_Mansalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirMensalidade();
            }
        });


        btn_acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_acessarOpen();
            }
        });

    }


    private void AbrirMensalidade() {
        startActivity(new Intent(Painel_Aluno.this, Consultar_Mensalidade.class));

    }


    private void AbrirAtividade() {
        startActivity(new Intent(Painel_Aluno.this, Consultar_Atividades.class));

    }

    private void AbrirFaltas() {
        startActivity(new Intent(Painel_Aluno.this, Consultar_Faltas.class));

    }


    private void AbrirNotas() {
        startActivity(new Intent(Painel_Aluno.this, Consultar_Notas.class));

    }



    private void btn_acessarOpen() {
        startActivity(new Intent(Painel_Aluno.this, Tela_Blackboard.class));

    }



















}

