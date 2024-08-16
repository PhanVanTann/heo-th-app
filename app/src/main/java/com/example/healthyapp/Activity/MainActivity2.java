package com.example.healthyapp.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyapp.Adapter.BestDealAdapter;
import com.example.healthyapp.Adapter.CategoryAdapter;
import com.example.healthyapp.Domain.CategoryDomain;
import com.example.healthyapp.Domain.ItemsDomain;
import com.example.healthyapp.R;


import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter,bestDealAdapter;
    private RecyclerView recyclerViewCat,recyclerViewBestDeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initRecyclerviewCat();
        initLocation();
        initRecyclerViewBestDeal();
    }

    private void initLocation() {
        String [] items= new String[]{"LosAngeles, USA", "NewYork, USA"};
        final Spinner locationSpin=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items=new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetable"));
        items.add(new CategoryDomain("cat2","Fruits"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat=findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        catAdapter=new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);
    }
    public  void initRecyclerViewBestDeal(){
        recyclerViewBestDeal=findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);

    }
    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain>items=new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",6.2,"With its vibrant orange hue and a burst of refreshing" +
                " citrus flavor, the juicy orange is a natural source of" +
                " vitamin C, invigorating your senses and" +
                " supporting your immune system. A delightful snack" +
                " that combines health and taste",4.2));
        items.add(new ItemsDomain("apple","Fresh Apple",6.5,"Crisp and succulent, apples are nature's candy. Each bite offers a symphony of sweetness and a satisfying crunch. Packed with fiber and antioxidants, apples make for a wholesome snack, keeping you energized throughout the day.",4.8));
        items.add(new ItemsDomain("watermelon","Fresh berry",5.1,"",4.9));
        items.add(new ItemsDomain("berry","Fresh Berry",6,"",4.5));
        items.add(new ItemsDomain("pineapple","Fresh Pineapple",10,"",3));
        items.add(new ItemsDomain("strawberry","Fresh Strawberry",12,"",4));
        return items;
    }
}