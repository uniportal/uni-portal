package com.example.app_uniportal;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.bussiness.authentication.control.AuthenticateStudent;
import com.example.app_uniportal.bussiness.authentication.control.AuthenticateTeacher;

public class MainActivity extends AppCompatActivity {

    private ImageView icon_Capa;
    private TextView Uniportal, BemVindo;
    private Button SouAluno, SouProfessor;
    private Animation popup;
    private Animation popdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // --------------------- animação Tela 1 Code-------------------------------

        icon_Capa = (ImageView) findViewById(R.id.icon_Capa);
        Uniportal = (TextView) findViewById(R.id.Uniportal);
        BemVindo = (TextView) findViewById(R.id.BemVindo);
        SouAluno = (Button) findViewById(R.id.SouAluno);
        SouProfessor = (Button) findViewById(R.id.SouProfessor);

        popup = AnimationUtils.loadAnimation(this, R.anim.popup);
        popdown = AnimationUtils.loadAnimation(this, R.anim.popdown);

        icon_Capa.startAnimation(popup);
        Uniportal.startAnimation(popdown);
        BemVindo.startAnimation(popdown);
        SouAluno.startAnimation(popdown);
        SouProfessor.startAnimation(popdown);

        // --------------------- Fim animação Tela 1 Code-------------------------------;

        // -------------------- Ação Botões abrir Telas ----------------------------;



SouAluno.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SouAlunoOpen();
    }
});


SouProfessor.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SouProfessorOpen();
    }
});


    }



    private void SouProfessorOpen() {
        startActivity(new Intent(MainActivity.this, AuthenticateTeacher.class));

    }


    private void SouAlunoOpen() {
        startActivity(new Intent(MainActivity.this, AuthenticateStudent.class));
    }


    // -------------------- Fim Ação Botões abrir Telas ----------------------------


}