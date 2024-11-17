package com.example.a258class;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);

        ArrayList<HashMap<String, String>> cartList = MainActivity.cartList;

        if (cartList != null && !cartList.isEmpty()) {
            CartAdapter cartAdapter = new CartAdapter(this, cartList);
            cartListView.setAdapter(cartAdapter);
        } else {
            Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
