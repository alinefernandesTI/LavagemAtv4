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

public class TelaTres extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Historico> historicos;
    private static String JSON_URL = "https://my-json-server.typicode.com/alinefernandesTI/atividade01/Historico";
    AdapterDois adapterDois;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tres);
        recyclerView = findViewById(R.id.historico_lista);
        historicos = new ArrayList<>();

        extrairHistoricos();
    }

    private void extrairHistoricos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject lavagensObject = response.getJSONObject(i);
                        Historico historico = new Historico();
                        historico.setData(lavagensObject.getString("Data").toString());
                        historico.setLavagem(lavagensObject.getString("Lavagem").toString());
                        historico.setValor(lavagensObject.getString("valor").toString());

                        historicos.add(historico);




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapterDois = new AdapterDois(getApplicationContext(), historicos);
                recyclerView.setAdapter(adapterDois);
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