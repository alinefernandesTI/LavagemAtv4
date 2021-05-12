package com.example.lavagematv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

LayoutInflater inflater;
List<Lavagens> lavagens;
public Adapter(Context ctx, List<Lavagens> lavagens){
    this.inflater = LayoutInflater.from((ctx));
    this.lavagens= lavagens;

}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.lista,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nome.setText(lavagens.get(position).getNome());
        holder.valor.setText(lavagens.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return lavagens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome, valor;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textView);
            valor = itemView.findViewById(R.id.textView2);

        }
    }
}
