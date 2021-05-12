package com.example.lavagematv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class telaDois extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Lavagens> lavagem;
    private static String JSON_URL = "https://my-json-server.typicode.com/alinefernandesTI/atividade01/Lavagens";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);
        recyclerView = findViewById(R.id.lavagensList);
        lavagem = new ArrayList<>();
        
        extrairLavagens();

    }

    private void extrairLavagens() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject lavagensObject = response.getJSONObject(i);
                        Lavagens lavagens = new Lavagens();
                        lavagens.setNome(lavagensObject.getString("nome").toString());
                        lavagens.setValor(lavagensObject.getString("valor").toString());
                            lavagem.add(lavagens);




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(), lavagem);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error){
                Log.d("tag", "onErrosResponse: "+ error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
}