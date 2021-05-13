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

public class TelaQuatro extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Adicionais> adicionais;
    private static String JSON_URL = "https://my-json-server.typicode.com/alinefernandesTI/atividade01/Adicionais";
    AdapterTres adapterTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quatro);
        recyclerView = findViewById(R.id.adicionais_lista);
        adicionais = new ArrayList<>();

        extrairAdicionais();
    }

    private void extrairAdicionais() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject lavagensObject = response.getJSONObject(i);
                        Adicionais adicionais1 = new Adicionais();
                        adicionais1.setTipo(lavagensObject.getString("tipo").toString());
                        adicionais1.setValor(lavagensObject.getString("valor").toString());

                        adicionais.add(adicionais1);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapterTres = new AdapterTres(getApplicationContext(), adicionais);
                recyclerView.setAdapter(adapterTres);
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