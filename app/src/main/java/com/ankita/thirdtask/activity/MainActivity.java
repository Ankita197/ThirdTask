package com.ankita.thirdtask.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ankita.thirdtask.R;
import com.ankita.thirdtask.adapter.ItemFoodImgAdapter;
import com.ankita.thirdtask.adapter.ItemOnClick;
import com.ankita.thirdtask.database.Cart;
import com.ankita.thirdtask.database.CartDataBase;
import com.ankita.thirdtask.modal.FoodItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItemFood;
    Button btnViewCart;
    ArrayList<FoodItem> arrayList;
    public static ArrayList<Cart> list=new ArrayList<>();
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvItemFood=findViewById(R.id.rvItemFood);
        btnViewCart=findViewById(R.id.btnViewCart);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvItemFood.setLayoutManager(linearLayoutManager);
        arrayList=new ArrayList<>();
        arrayList.add(new FoodItem(R.drawable.sandwich,"Sandwidtch","this is called vageterian Sendwidtch",100,1));
        arrayList.add(new FoodItem(R.drawable.sandwich,"dhosa","this is called vageterian dhosa",200,1));
        arrayList.add(new FoodItem(R.drawable.sandwich,"pizza","this is called vageterian piza",150,1));
        arrayList.add(new FoodItem(R.drawable.sandwich,"berger","this is called vageterian berger",250,1));
        arrayList.add(new FoodItem(R.drawable.sandwich,"Sandwidtch","this is called vageterian fryRice",90,1));
        ItemFoodImgAdapter itemFoodImgAdapter=new ItemFoodImgAdapter(this, arrayList, new ItemOnClick() {
            @Override
            public void OnclickItem(int pos, ItemFoodImgAdapter.ItemViewHolder holder) {
                FoodItem item=arrayList.get(pos);
                cart=new Cart();
                cart.setDescription(item.getDescription());
                cart.setPrice(item.getPrice());
                cart.setQuantity(item.getQuantity());
                cart.setTitle(item.getTitle());
                Log.d("&&&",item.getDescription());

                if(!list.contains(cart)){
                    list.add(cart);
                    Toast.makeText(MainActivity.this,"item inserted Succesfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"this item is already in cart",Toast.LENGTH_SHORT).show();
                }
               // CartDataBase.getDatabase(MainActivity.this).cartDao().insertAll(cart);



            }
        });
        rvItemFood.setAdapter(itemFoodImgAdapter);
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewCartActivity.class));
            }
        });
    }

}
