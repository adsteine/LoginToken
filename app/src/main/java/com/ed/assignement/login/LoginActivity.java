package com.ed.assignement.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ed.assignement.R;


/**
 * Login screen activity.
 * if successful open item interface
 */
public class LoginActivity extends Activity {
    private Button btnLogin;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        this.btnLogin = findViewById(R.id.btn_login);
        this.btnLogin.setOnClickListener(view -> doLogin());
    }



    private void doLogin() {
        RequestQueue volleyQueue = Volley.newRequestQueue(this);
        String url = "https://run.mocky.io/v3/7db11c21-6991-4e7e-b426-97c0dade1ccb";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    LoginObject parser = new LoginJsonParser(response).mapObject;
                    if (parser.getauthSuccess()) {
                        Log.d("show token: ",parser.getToken());
                    } else {
                        Toast.makeText(this, R.string.error_login, Toast.LENGTH_LONG).show();
                    }
                },
                error -> {
                    Toast.makeText(this, R.string.error_server, Toast.LENGTH_LONG).show();
                }
        );
        volleyQueue.add(jsonObjectRequest);
    }




}
