package com.example.app_uniportal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Consultar_Notas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_notas);

//        final AsyncHttpClient client = new AsyncHttpClient();
//
//        final SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//
//        client.get("http://98d4f4bb3c65.ngrok.io/grades/"+sharedpreferences.getString("document", null), null, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                try {
//                    JSONObject grades = new JSONObject(new String(response, StandardCharsets.UTF_8));
//                    JSONArray  evaluations = grades.getJSONArray("evaluations");
//                    if (evaluations != null && evaluations.length() > 0) {
//                        TextView NomeAluno_item = (TextView) findViewById(R.id.NomeAluno_item);
//                        NomeAluno_item.setText(sharedpreferences.getString("name", "Nome Aluno"));
//
//                        TextView materia1_text = (TextView) findViewById(R.id.materia1_text);
//                        materia1_text.setText(evaluations.getJSONObject(0).get("matter").toString());
//
//                        TextView materia2_text = (TextView) findViewById(R.id.materia2_text);
//                        materia2_text.setText(evaluations.getJSONObject(1).get("matter").toString());
//
//                        TextView materia3_text = (TextView) findViewById(R.id.materia3_text);
//                        materia3_text.setText(evaluations.getJSONObject(2).get("matter").toString());
//
//                        TextView materia4_text = (TextView) findViewById(R.id.materia4_text);
//                        materia4_text.setText(evaluations.getJSONObject(3).get("matter").toString());
//
//                        TextView materia5_text = (TextView) findViewById(R.id.materia5_text);
//                        materia5_text.setText(evaluations.getJSONObject(4).get("matter").toString());
//
//                        TextView M1_Nota_n1 = (TextView) findViewById(R.id.M1_Nota_n1);
//                        M1_Nota_n1.setText(evaluations.getJSONObject(0).get("grade").toString());
//
//                        TextView M2_Nota_n1 = (TextView) findViewById(R.id.M2_Nota_n1);
//                        M2_Nota_n1.setText(evaluations.getJSONObject(1).get("grade").toString());
//
//                        TextView M3_Nota_n1 = (TextView) findViewById(R.id.M3_Nota_n1);
//                        M3_Nota_n1.setText(evaluations.getJSONObject(2).get("grade").toString());
//
//                        TextView M4_Nota_n1 = (TextView) findViewById(R.id.M4_Nota_n1);
//                        M4_Nota_n1.setText(evaluations.getJSONObject(3).get("grade").toString());
//
//                        TextView M5_Nota_n1 = (TextView) findViewById(R.id.M5_Nota_n1);
//                        M5_Nota_n1.setText(evaluations.getJSONObject(4).get("grade").toString());
//                    }
//                } catch (JSONException e) {
//                    Toast.makeText(Consultar_Notas.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                Toast.makeText(Consultar_Notas.this, e.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

    }
}