package com.ankita.thirdtask.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.ankita.thirdtask.R;
import com.ankita.thirdtask.adapter.CartAdapter;
import com.ankita.thirdtask.database.Cart;
import com.ankita.thirdtask.database.CartDao;

import java.util.ArrayList;

public class ViewCartActivity extends AppCompatActivity {

    RecyclerView rvItemCart;
    TextView tvTotalPrice;
    ArrayList<Cart> cartList;
    Cart cart;
     int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        rvItemCart=findViewById(R.id.rvItemCart);
        tvTotalPrice=findViewById(R.id.tvTotalPrice);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvItemCart.setLayoutManager(linearLayoutManager);
        CartAdapter cartAdapter=new CartAdapter(this, MainActivity.list);
        cartList=MainActivity.list;
       rvItemCart.setAdapter(cartAdapter);
       setTotalPrice();
    }

    private void setTotalPrice() {
        for (int i=0;i<cartList.size();i++){
            cart =cartList.get(i);
            total+=cart.getPrice()*cart.getQuantity();
        }
        tvTotalPrice.setText("total Price is  ".concat(String.valueOf(total)));

    }
}
