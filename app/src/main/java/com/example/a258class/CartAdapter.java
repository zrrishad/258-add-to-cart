package com.example.a258class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HashMap<String, String>> cartList;

    public CartAdapter(Context context, ArrayList<HashMap<String, String>> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public int getCount() {
        return cartList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recycle the view if convertView is available, to optimize performance
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cart_item, parent, false);
        }

        HashMap<String, String> cartItem = cartList.get(position);

     //   TextView productName = convertView.findViewById(R.id.cartProductName);
      //  TextView productPrice = convertView.findViewById(R.id.cartProductPrice);
      //  ImageView productImage = convertView.findViewById(R.id.cartProductImage);

        // Safely retrieve values from the map
        String name = cartItem.get("title");
        String price = cartItem.get("price");
        String imageUrl = cartItem.get("thumbnail");

        // Set product details
     //   productName.setText(name);
      //  productPrice.setText("Price: " + price);

        // Load image using Picasso and handle errors gracefully
     //   Picasso.get()
         //       .load(imageUrl)
               // .placeholder(R.drawable.placeholder_image) // Set a placeholder image
                //.error(R.drawable.error_image) // Set an error image in case of failure
           //     .into(productImage);

        return convertView;
    }
}
