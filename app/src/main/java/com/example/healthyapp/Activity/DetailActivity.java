package com.example.healthyapp.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyapp.Adapter.SimilarAdapter;
import com.example.healthyapp.Domain.ItemsDomain;
import com.example.healthyapp.R;


public class DetailActivity extends AppCompatActivity {
    private ItemsDomain object;
    private ImageView backBtn, itemImg;
    private TextView priceKgTxt, titleTxt, descriptionTxt, ratingTxt;
    private RatingBar ratingBar;
    private TextView weightTxt,plusBtn,minusBtn,totalTxt;
    private int weight =1;
    private RecyclerView.Adapter similarAdapter;
    private RecyclerView recyclerViewSimilar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getBundles();
        initView();
        setVariable();
        initSimilarList();
    }

    private void initSimilarList() {
        recyclerViewSimilar=findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        similarAdapter=new SimilarAdapter(new MainActivity2().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
        @SuppressLint("DiscouragedApi") int drawableResourceId = getResources().getIdentifier(object.getImgPath(), "drawable", DetailActivity.this.getPackageName());
//        Glide.with(DetailActivity.this)
//                .load(drawableResourceId)
//                .into(itemImg);
        priceKgTxt.setText(object.getPrice()+"$/Kg");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText("("+object.getRate()+")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText(weight*object.getPrice()+"$");

        plusBtn.setOnClickListener(view -> {
            weight=weight+1;
            weightTxt.setText(weight+" kg");
            totalTxt.setText((weight*object.getPrice())+"$");
        });

        minusBtn.setOnClickListener(view -> {
            if(weight>1){
                weight=weight-1;
                weightTxt.setText(weight+" kg");
                totalTxt.setText((weight*object.getPrice())+ "$");
            }
        });
    }

    private void initView() {
        backBtn=findViewById(R.id.backBtn);
        itemImg=findViewById(R.id.img);
        priceKgTxt=findViewById(R.id.priceKgTxt);
        titleTxt=findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        ratingBar=findViewById(R.id.ratingBar);
        ratingTxt=findViewById(R.id.ratingTxt);
        weightTxt=findViewById(R.id.weightTxt);
        plusBtn=findViewById(R.id.minusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        totalTxt=findViewById(R.id.totalTxt);
    }

    private void getBundles() {
        object= (ItemsDomain) getIntent().getSerializableExtra("object");
    }
}