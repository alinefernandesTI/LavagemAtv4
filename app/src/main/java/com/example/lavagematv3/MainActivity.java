package com.example.lavagematv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button lavagens;
    private Button adicionais;
    private Button historico;
    private Button contatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lavagens = (Button)findViewById(R.id.lavagens);
        adicionais = (Button)findViewById(R.id.adicionais);
        historico = (Button)findViewById(R.id.historico);
        contatos = (Button)findViewById(R.id.contatos);


        lavagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TelaDois.class);
                startActivity(i);
            }

        });
        adicionais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TelaQuatro.class);
                startActivity(i);
            }

        });
        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TelaTres.class);
                startActivity(i);
            }

        });
        contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TelaCinco.class);
                startActivity(i);
            }

        });
    }
}