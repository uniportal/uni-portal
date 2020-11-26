package com.example.app_uniportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Login_aluno extends AppCompatActivity {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    EditText inputusuario, inputsenha;
    Button btn_aluno_entrar;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_aluno);
        inputusuario = (EditText) findViewById(R.id.inputusuario);
        inputsenha = (EditText) findViewById(R.id.inputsenha);
        btn_aluno_entrar = (Button) findViewById(R.id.btn_aluno_entrar);


        Request request = new Request.Builder()
                .url("http://localhost:8080/")
                .build();
        btn_aluno_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            JSONObject auth  = new JSONObject();
                try {
                    auth.put("login", inputusuario.getText().toString());
                    auth.put("password", inputsenha.getText().toString());
                    ResponseBody authenticated = authenticate("authenticate", auth);
                    if (authenticated.string() != null && authenticated.string().contains("name")) {
                        startActivity(new Intent(Login_aluno.this, Painel_Aluno.class));
                    }
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    private ResponseBody authenticate(String url, JSONObject json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }


}