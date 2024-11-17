package com.example.a258class;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView edName2, edPrice2,edDes;
    ImageSlider imageSli;
    ImageView edImsge2;



    public static String MalName="";
    public static String MalPrice="";
    public static String MalDes="";
    public static HashMap<SlideModel> image2=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        edName2=findViewById(R.id.edName2);
        edPrice2=findViewById(R.id.edPrice2);
        edDes=findViewById(R.id.edDes);
        imageSli= imageSli;


        edName2.setText(MalName);
        edPrice2.setText(MalPrice);
        edDes.setText(MalDes);





    }
}
