package com.example.lavagematv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterQuatro extends RecyclerView.Adapter<AdapterQuatro.ViewHolder> {

    LayoutInflater inflater;
    List<Contatos> contatos;
    public AdapterQuatro(Context ctx, List<Contatos> contatos){
        this.inflater = LayoutInflater.from((ctx));
        this.contatos= contatos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_contatos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.unidade.setText(contatos.get(position).getUnidade());
        holder.endereco.setText(contatos.get(position).getEndereco());
        holder.numero.setText("Numero: "+contatos.get(position).getNumero());
        holder.telefone.setText("Telefone: "+contatos.get(position).getTelefone());
        holder.email.setText("E-mail: "+contatos.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView unidade,endereco,numero,telefone,email;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            unidade = itemView.findViewById(R.id.textUnidade);
            endereco = itemView.findViewById(R.id.textEnd);
            numero = itemView.findViewById(R.id.textNum);
            telefone = itemView.findViewById(R.id.textTel);
            email = itemView.findViewById(R.id.textEmail);

        }
    }
}
