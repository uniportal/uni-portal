package com.example.app_uniportal.bussiness.login.control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.Painel_professor;
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


public class Login_Professor extends AppCompatActivity {
    EditText input_user_prof, input_senha_prof;
    Button btn_Entrar_Prof;
    OkHttpClient client = new OkHttpClient();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_professor);


        input_user_prof = (EditText) findViewById(R.id.input_user_prof);
        input_senha_prof = (EditText) findViewById(R.id. input_senha_prof);
        btn_Entrar_Prof = (Button) findViewById(R.id.btn_Entrar_Prof);



        btn_Entrar_Prof .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject authRequest = new JSONObject();
                    authRequest.put("login", input_user_prof.getText().toString());
                    authRequest.put("password", input_senha_prof.getText().toString());
                    Authenticated authSession = new Gson().fromJson(authenticate("http://4041496c62b0.ngrok.io/authenticate", authRequest), Authenticated.class);
                    if (authSession != null) {
                        SharedPreferences sharedpreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("document", authSession.getDocument());
                        editor.commit();
                        startActivity(new Intent(Login_Professor.this, Painel_professor.class));
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


    private String authenticate(String url, JSONObject json) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json.toString());
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