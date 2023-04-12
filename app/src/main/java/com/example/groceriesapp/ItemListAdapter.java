package com.example.groceriesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;

    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){

        // Editing values
        holder.editItem.setOnClickListener(view -> {
            int iPosition = holder.getAdapterPosition();
            if (holder.editName.getVisibility() == View.VISIBLE) {
                Item item = Storage.getInstance().getItem(iPosition);
                item.setName(holder.editName.getText().toString());
                item.setNotes(holder.editNotes.getText().toString());
                holder.editName.setVisibility(View.GONE);
                holder.editNotes.setVisibility(View.GONE);

                notifyDataSetChanged();
            }
            else {
                holder.editName.setVisibility(View.VISIBLE);
                holder.editNotes.setVisibility(View.VISIBLE);
            }
        });

        // Deleting values
        holder.itemName.setText(items.get(position).getName());
        holder.itemNotes.setText(items.get(position).getNotes());
        holder.editName.setText(items.get(position).getName());
        holder.editNotes.setText(items.get(position).getNotes());
        holder.deleteItem.setOnClickListener(view -> {
            int iPosition = holder.getAdapterPosition();
            Storage.getInstance().deleteItem(items.get(iPosition).getName());
            notifyItemRemoved(iPosition);
        });

    }

    @Override
    public int getItemCount() {return items.size();}
}
