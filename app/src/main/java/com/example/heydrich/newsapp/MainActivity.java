package com.example.heydrich.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<haberModel> haberListesi=new ArrayList<>();
        final Gson gson = new Gson();
        ListView listView =findViewById(R.id.listView);
        haberAdapter haberAdapter=new haberAdapter(this,haberListesi);
        String url="http://www.hurriyet.com.tr/teknoloji";
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
                        for (int i=0;i<jsonArray.size();i++){
                            haberModel haberModel=gson.fromJson(jsonArray.get(i), com.example.heydrich.newsapp.haberModel.class);
                            haberListesi.add(haberModel);
                        }
                    }


                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("responseErr",error.getMessage());

                    }
                }

        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("accept","applşcatşon/json");
                params.put("apikey","8bc7da5df7db485290b290832f0e383c");


                return params;

            }
        };
        requestQueue.add(stringRequest);
        listView.setAdapter(haberAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url =haberListesi.get(i).getUrl();
                Intent intent = new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }
}
