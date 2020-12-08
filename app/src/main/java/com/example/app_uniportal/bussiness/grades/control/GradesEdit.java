package com.example.app_uniportal.bussiness.grades.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.Painel_professor;
import com.example.app_uniportal.R;
import com.example.app_uniportal.bussiness.grades.entity.Evaluation;
import com.example.app_uniportal.bussiness.grades.entity.Grade;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradesEdit extends AppCompatActivity {
    Button btn_cadastrar_notas;
    EditText documento, Materia1,Materia2,Materia3,Materia4,Materia5,Nota1,Nota2,Nota3,Nota4,Nota5;
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notas);

        btn_cadastrar_notas = (Button) findViewById(R.id.btn_cadastrar_notas);


        documento = (EditText) findViewById(R.id.documento);
        Materia1 = (EditText) findViewById(R.id.Materia1);
        Materia2 = (EditText) findViewById(R.id.Materia2);
        Materia3 = (EditText) findViewById(R.id.Materia3);
        Materia4 = (EditText) findViewById(R.id.Materia4);
        Materia5 = (EditText) findViewById(R.id.Materia5);
        Nota1 = (EditText) findViewById(R.id.Nota1);
        Nota2 = (EditText) findViewById(R.id.Nota2);
        Nota3 = (EditText) findViewById(R.id.Nota3);
        Nota4 = (EditText) findViewById(R.id.Nota4);
        Nota5 = (EditText) findViewById(R.id.Nota5);



        btn_cadastrar_notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Evaluation> evaluations = new ArrayList<Evaluation>();
                    evaluations.add(new Evaluation(Materia1.getText().toString(), Nota1.getText().toString()));
                    evaluations.add(new Evaluation(Materia2.getText().toString(), Nota2.getText().toString()));
                    evaluations.add(new Evaluation(Materia3.getText().toString(), Nota3.getText().toString()));
                    evaluations.add(new Evaluation(Materia4.getText().toString(), Nota4.getText().toString()));
                    evaluations.add(new Evaluation(Materia5.getText().toString(), Nota5.getText().toString()));
                    Grade grade = new Grade(documento.getText().toString(), evaluations);

                    Boolean response = new Gson().fromJson(insertGrade("http://10.0.2.2:8080/grades", new Gson().toJson(grade, Grade.class)), Boolean.class);
                    if (response) {
                        startActivity(new Intent(GradesEdit.this, Painel_professor.class));
                    } else {
                        alert("Não foi possivel inserir as notas. Tente novamente!");
                    }
                } catch (IOException e) {
                    alert(e.getMessage());
                    e.printStackTrace();
                }
            }
        });

    }

    private String insertGrade(String url, String json) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        builder.post(body);
        Request request = builder.build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}