package edu.upc.dsa.minimo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorRecycleView extends RecyclerView.Adapter<AdaptadorRecycleView.ViewHolder>
{

    private Context context;
    private List<Insignia> insignias;

    public void setData (List<Insignia> insignias )
    {
        this.insignias = insignias;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AdaptadorRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        context = parent.getContext();
        return new AdaptadorRecycleView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.rowusuario_layout,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycleView.ViewHolder holder, int position)
    {
        Insignia insignia = insignias.get(position);
        String nombre = insignia.getNombre();
        String imagen = insignia.getUrl_Imagen();
        holder.nombre.setText(nombre);
        holder.imagen.setText(imagen);

    }

    @Override
    public int getItemCount() {
        return insignias.size();
    }



    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView nombre;
        TextView imagen;
        public View layout;

        public ViewHolder(@NonNull View itemView)
        {

            super(itemView);
            layout = itemView;

            imagen = itemView.findViewById(R.id.fotoInsignia);
            nombre = itemView.findViewById(R.id.nombreInsignia);

        }
    }

}
