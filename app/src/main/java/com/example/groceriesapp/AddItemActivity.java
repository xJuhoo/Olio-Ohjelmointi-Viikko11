package com.example.groceriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    private EditText itemName, itemNotes;

    private Button buttonAddItem;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        itemName = findViewById(R.id.itemName);
        itemNotes = findViewById(R.id.itemNotes);
        buttonAddItem = findViewById(R.id.itemSave);
        context = this;
    }

    // For adding items
    public void addItem(View view){
        // The creation time can be compared with the size of the current list of items
        // After first item the size is 1 and after second item its 2, so we know which one came first
        Item item = new Item(itemName.getText().toString(), itemNotes.getText().toString(), Storage.getInstance().getItems().size());
        Storage.getInstance().addItem(item);

        // For switching back to main page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}