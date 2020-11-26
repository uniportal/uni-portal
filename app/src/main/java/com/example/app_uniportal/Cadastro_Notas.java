package com.example.app_uniportal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro_Notas extends AppCompatActivity {
    Button btn_cadastrar_notas;
    EditText documento, Materia1,Materia2,Materia3,Materia4,Materia5,Nota1,Nota2,Nota3,Nota4,Nota5;

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
                String document = documento.getText().toString();
                String materia1 = Materia1.getText().toString();
                String materia2 = Materia2.getText().toString();
                String materia3 = Materia3.getText().toString();
                String materia4 = Materia4.getText().toString();
                String materia5 = Materia5.getText().toString();
                String nota1 = Nota1.getText().toString();
                String nota2 = Nota2.getText().toString();
                String nota3 = Nota3.getText().toString();
                String nota4 = Nota4.getText().toString();
                String nota5 = Nota5.getText().toString();
//
//                RequestParams insertGradesRequest = new RequestParams();
//                insertGradesRequest.put("document",document);
//                insertGradesRequest.put("matter1",materia1);
//                insertGradesRequest.put("matter2",materia2);
//                insertGradesRequest.put("matter3",materia3);
//                insertGradesRequest.put("matter4",materia4);
//                insertGradesRequest.put("matter5",materia5);
//                insertGradesRequest.put("grade1",nota1);
//                insertGradesRequest.put("grade2",nota2);
//                insertGradesRequest.put("grade3",nota3);
//                insertGradesRequest.put("grade4",nota4);
//                insertGradesRequest.put("grade5",nota5);
//                final AsyncHttpClient client = new AsyncHttpClient();
//                client.post("http://98d4f4bb3c65.ngrok.io/grades", insertGradesRequest, new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        Toast.makeText(Cadastro_Notas.this, "Notas cadastradas!", Toast.LENGTH_LONG).show();
//
//                        startActivity(new Intent(Cadastro_Notas.this, Painel_professor.class));
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                        Toast.makeText(Cadastro_Notas.this, error.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });

            }
        });

    }
}