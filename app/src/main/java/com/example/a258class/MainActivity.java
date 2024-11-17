package com.example.a258class;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    GridView edGrid;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    static ArrayList<HashMap<String, String>> cartList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edGrid = findViewById(R.id.edGrid);

        String url = "https://dummyjson.com/products";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("products");
                            for (int x = 0; x < jsonArray.length(); x++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(x);
                                String proName = jsonObject.getString("title");
                                String proPrice = jsonObject.getString("price");
                                String proPhoto = jsonObject.getString("thumbnail");
                                String des=jsonObject.getString("description");

                                hashMap = new HashMap<>();
                                hashMap.put("title", proName);
                                hashMap.put("price", proPrice);
                                hashMap.put("thumbnail", proPhoto);
                                hashMap.put("description",des);
                                arrayList.add(hashMap);
                            }
                            MyAdapter myAdapter = new MyAdapter();
                            edGrid.setAdapter(myAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjectRequest);


    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return arrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.layout1, parent, false);
            }

            HashMap<String, String> hashMap = arrayList.get(position);
            TextView proName = view.findViewById(R.id.proName);
            ImageView edPhoto = view.findViewById(R.id.edPhoto);
            TextView proPrice = view.findViewById(R.id.proPrice);
            ImageView addToCartButton = view.findViewById(R.id.addToCartButton);
            TextView des = view.findViewById(R.id.des);

            String productName = hashMap.get("title");
            String productPrice = hashMap.get("price");
            String productPhoto = hashMap.get("thumbnail");
            String productDes = hashMap.get("description");

            proName.setText(productName);
            proPrice.setText("Price: $" + productPrice);
            des.setText(productDes);

            Picasso.get().load(productPhoto).into(edPhoto);

            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                   ProductDetailsActivity.MalName=productName;
                   ProductDetailsActivity.MalPrice=productPrice;
                    ProductDetailsActivity.MalDes=productDes;
                    ProductDetailsActivity.image2=arrayList.get(position);






                    if (!cartList.contains(hashMap)) {
                        cartList.add(hashMap);
                        Toast.makeText(MainActivity.this, productName + " added to cart", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, productName + " is already in cart", Toast.LENGTH_SHORT).show();
                    }


                    Intent myIntent=new Intent(MainActivity.this,ProductDetailsActivity.class);
                    startActivity(myIntent);



                }
            });

            return view;
        }
    }
}
