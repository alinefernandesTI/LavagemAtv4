package com.example.lavagematv3;

public class Lavagens {

    private  String nome;
    private  String valor;

    public Lavagens(){}

    public Lavagens(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }



}
