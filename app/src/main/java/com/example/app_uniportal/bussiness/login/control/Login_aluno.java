package com.example.app_uniportal.bussiness.login.control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.Painel_Aluno;
import com.example.app_uniportal.R;
import com.example.app_uniportal.bussiness.login.entity.Authenticated;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class Login_aluno extends AppCompatActivity {
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

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btn_aluno_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject authRequest = new JSONObject();
                    authRequest.put("login", inputusuario.getText().toString());
                    authRequest.put("password", inputsenha.getText().toString());
                    Authenticated authSession = new Gson().fromJson(authenticate("http://ff8697185340.ngrok.io/authenticate", authRequest).toString(), Authenticated.class);
                    if (authSession != null) {
                        SharedPreferences sharedpreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("document", authSession.getDocument());
                        editor.commit();
                        startActivity(new Intent(Login_aluno.this, Painel_Aluno.class));
                    } else {
                        alert("Login ou senha incorretas. Tente novamente!");
                    }
                } catch (JSONException | IOException e) {
                    alert(e.getMessage());
                    e.printStackTrace();
                }
            }
        });

    }

    private JSONObject authenticate(String url, JSONObject json) throws IOException {
        JSONObject authenticated = new JSONObject();
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json.toString());
        builder.post(body);
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        try {
            authenticated = new JSONObject(response.body().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return authenticated;
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}