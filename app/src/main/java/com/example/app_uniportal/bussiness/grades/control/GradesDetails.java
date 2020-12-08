package com.example.app_uniportal.bussiness.grades.control;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.R;
import com.example.app_uniportal.bussiness.grades.entity.Grade;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class GradesDetails extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_notas);
        SharedPreferences sharedpreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
        try {
            String url = "http://10.0.2.2:8080/grades/" + sharedpreferences.getString("document", null);
            Grade response = new Gson().fromJson(getGrades(url), Grade.class);
            if (response != null) {
                TextView NomeAluno_item = (TextView) findViewById(R.id.NomeAluno_item);
                NomeAluno_item.setText(sharedpreferences.getString("name", "Nome Aluno"));
                if (response.getEvaluations() != null) {
                    TextView materia1_text = (TextView) findViewById(R.id.materia1_text);
                    materia1_text.setText(response.getEvaluations().get(0).getMatter());

                    TextView materia2_text = (TextView) findViewById(R.id.materia2_text);
                    materia2_text.setText(response.getEvaluations().get(1).getMatter());

                    TextView materia3_text = (TextView) findViewById(R.id.materia3_text);
                    materia3_text.setText(response.getEvaluations().get(2).getMatter());

                    TextView materia4_text = (TextView) findViewById(R.id.materia4_text);
                    materia4_text.setText(response.getEvaluations().get(3).getMatter());

                    TextView materia5_text = (TextView) findViewById(R.id.materia5_text);
                    materia5_text.setText(response.getEvaluations().get(4).getMatter());

                    TextView M1_Nota_n1 = (TextView) findViewById(R.id.M1_Nota_n1);
                    M1_Nota_n1.setText(response.getEvaluations().get(0).getGrade());

                    TextView M2_Nota_n1 = (TextView) findViewById(R.id.M2_Nota_n1);
                    M2_Nota_n1.setText(response.getEvaluations().get(1).getGrade());

                    TextView M3_Nota_n1 = (TextView) findViewById(R.id.M3_Nota_n1);
                    M3_Nota_n1.setText(response.getEvaluations().get(2).getGrade());

                    TextView M4_Nota_n1 = (TextView) findViewById(R.id.M4_Nota_n1);
                    M4_Nota_n1.setText(response.getEvaluations().get(3).getGrade());

                    TextView M5_Nota_n1 = (TextView) findViewById(R.id.M5_Nota_n1);
                    M5_Nota_n1.setText(response.getEvaluations().get(4).getGrade());
                }
            } else {
                alert("Não foi possivel buscar as notas. Tente novamente!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String getGrades(String url) throws IOException {
        System.out.println(url);
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.get();
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