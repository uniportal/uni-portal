package com.example.app_uniportal.bussiness.login.control;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_uniportal.R;


public class Login_Professor extends AppCompatActivity {


    EditText input_user_prof, input_senha_prof;
    Button btn_Entrar_Prof;


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

                String login =  input_user_prof.getText().toString();
                String password = input_senha_prof.getText().toString();
//                RequestParams loginRequest = new RequestParams();
//                loginRequest.put("login", login);
//                loginRequest.put("password", password);
//                AsyncHttpClient client = new AsyncHttpClient();
//                client.post("http://98d4f4bb3c65.ngrok.io/authenticate", loginRequest, new AsyncHttpResponseHandler() {
//
//
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                        try {
//                            JSONObject authenticated = new JSONObject(new String(response, StandardCharsets.UTF_8));
//                            SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedpreferences.edit();
//                            editor.putString("document", authenticated.getString("document"));
//                            editor.commit();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        startActivity(new Intent(Login_Professor.this, Painel_professor.class));
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                        Toast.makeText(Login_Professor.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });

            }

        });


    }

    private void alert (String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }





}