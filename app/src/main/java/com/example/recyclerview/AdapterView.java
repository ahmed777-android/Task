package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<AdapterView.viewHolder> {
    public   ArrayList<User> users= new ArrayList<>();



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.customview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.onBind(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //////////////////////////////////////////////////////////////////////
    public class viewHolder extends RecyclerView.ViewHolder{
        TextView nameTV,phoneTV;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV= itemView.findViewById(R.id.nameTV);
            phoneTV= itemView.findViewById(R.id.passwordTV);
        }
         void onBind(User user) {
            nameTV.setText(user.getName());
            phoneTV.setText(user.getphone());
        }
    }
}
