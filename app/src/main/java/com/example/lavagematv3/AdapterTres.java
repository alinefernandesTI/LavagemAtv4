package com.example.lavagematv3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTres extends RecyclerView.Adapter<AdapterTres.ViewHolder> {

    LayoutInflater inflater;
    List<Adicionais> adicionais;
    public AdapterTres(Context ctx, List<Adicionais> adicionais){
        this.inflater = LayoutInflater.from((ctx));
        this.adicionais= adicionais;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_adicionais,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tipo.setText(adicionais.get(position).getTipo());
        holder.valor.setText(adicionais.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return adicionais.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo, valor;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tipo = itemView.findViewById(R.id.textTipo);
            valor = itemView.findViewById(R.id.textTipoValor);

        }
    }
}