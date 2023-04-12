package com.example.groceriesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Storage itemStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        itemStorage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), itemStorage.getItems()));
    }

    // For sorting items by order of adding
    public void sortOrder(View view){
        List<Item> itemsByOrder = Storage.getInstance().getItems();
        Collections.sort(itemsByOrder, Item.sortOrders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), itemStorage.getItems()));
    }

    // For sorting items in alphabetical order
    public void sortName(View view){
        List<Item> itemsByName = Storage.getInstance().getItems();
        Collections.sort(itemsByName, Item.sortNames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), itemStorage.getItems()));
    }

    // Method for switching layout
    public void switchToAddItem(View view){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }
}