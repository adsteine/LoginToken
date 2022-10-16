package com.ed.assignement.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ed.assignement.R;
import com.ed.assignement.items.ItemsListActivity;

import java.util.HashMap;
import java.util.Map;

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
                        // using the token directly as a bundle
                        // it would be better to use a Shared preference, but since we only gonna use it once,
                        // there was no need for an SP
                        getItens(parser.getToken());
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

    private void getItens(String token) {
        RequestQueue volleyQueue = Volley.newRequestQueue(this);
        String url = "https://run.mocky.io/v3/4805b078-08fa-4ae4-bd2b-b86b8c3b77ff";
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            if (!response.equals(null)) {
                showDataList(response);
            } else {
                Toast.makeText(this, "Data null", Toast.LENGTH_LONG).show();
                Log.e("Your Array Response", "Data Null");
            }
        }, error -> {
            Log.e("error is ", "" + error);
            Toast.makeText(this, R.string.error_server, Toast.LENGTH_LONG).show();
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("token", token);
                return params;
            }

        };
        volleyQueue.add(request);
    }

    private void showDataList(String data) {
        final Intent intent = new Intent(this, ItemsListActivity.class);
        intent.putExtra("data", data);
        this.startActivity(intent);
    }

}
