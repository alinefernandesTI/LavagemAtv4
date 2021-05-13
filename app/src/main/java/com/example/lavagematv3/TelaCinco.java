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

public class TelaCinco extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Contatos> contatos;
    private static String JSON_URL = "https://my-json-server.typicode.com/alinefernandesTI/atividade01/Contatos";
    AdapterQuatro adapterQuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cinco);
        recyclerView = findViewById(R.id.contatos_list);
        contatos = new ArrayList<>();

        extrairContatos();
    }

    private void extrairContatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject lavagensObject = response.getJSONObject(i);
                        Contatos contatos1 = new Contatos();
                        contatos1.setUnidade(lavagensObject.getString("Unidade").toString());
                        contatos1.setEndereco(lavagensObject.getString("Endereço").toString());
                        contatos1.setNumero(lavagensObject.getString("Numero").toString());
                        contatos1.setTelefone(lavagensObject.getString("Telefone").toString());
                        contatos1.setEmail(lavagensObject.getString("Email").toString());

                        contatos.add(contatos1);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapterQuatro = new AdapterQuatro(getApplicationContext(), contatos);
                recyclerView.setAdapter(adapterQuatro);
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
