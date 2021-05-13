package com.example.lavagematv3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDois extends RecyclerView.Adapter<AdapterDois.ViewHolder> {

    LayoutInflater inflater;
    List<Historico> historicos;
    public AdapterDois(Context ctx, List<Historico> historicos){
        this.inflater = LayoutInflater.from((ctx));
        this.historicos= historicos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_historico,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.data.setText(historicos.get(position).getData());
        holder.lavagem.setText(historicos.get(position).getLavagem());
        holder.valor.setText(historicos.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return historicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView data,lavagem, valor;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.textData);
            lavagem = itemView.findViewById(R.id.textLav);
            valor = itemView.findViewById(R.id.textValor);

        }
    }
}