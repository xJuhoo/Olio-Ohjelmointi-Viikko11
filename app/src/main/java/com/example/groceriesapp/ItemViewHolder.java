package com.example.groceriesapp;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView editItem, deleteItem;
    ImageView sortOrder, sortName;
    TextView itemName, itemNotes;
    EditText editName, editNotes;

    public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        editItem = itemView.findViewById(R.id.iconEditItem);
        deleteItem = itemView.findViewById(R.id.iconDeleteItem);
        itemName = itemView.findViewById(R.id.txtItemName);
        itemNotes = itemView.findViewById(R.id.txtItemNotes);
        editName = itemView.findViewById(R.id.txtEditName);
        editNotes = itemView.findViewById(R.id.txtEditNotes);
        sortOrder = itemView.findViewById(R.id.calendarIcon);
        sortName = itemView.findViewById(R.id.sortingIcon);
    }
}