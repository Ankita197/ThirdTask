package com.ankita.thirdtask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.thirdtask.R;
import com.ankita.thirdtask.database.Cart;
import com.ankita.thirdtask.modal.FoodItem;

import java.util.ArrayList;

public class CartAdapter  extends RecyclerView.Adapter<CartAdapter.ItemViewHolder>{
    private Context context;
    private ArrayList<Cart> arrayList;
    private ItemOnClick click;

    public CartAdapter(Context context, ArrayList<Cart> arrayList){
        this.context=context;
        this.arrayList=arrayList;


    }

    @NonNull

    @Override
    public CartAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new CartAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.ItemViewHolder holder, final int position) {
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tvDescription.setText(arrayList.get(position).getDescription());
        holder.tvPrice.setText(String.valueOf(arrayList.get(position).getPrice()));
        holder.tvQuantity.setText(String.valueOf(arrayList.get(position).getQuantity()));





    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvDescription,tvPrice,tvQuantity;
        Button btnPlus,btnMinus,btnAddToCart;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvQuantity=itemView.findViewById(R.id.tvQuantity);
            btnPlus=itemView.findViewById(R.id.btnPlus);
            btnMinus=itemView.findViewById(R.id.btnMinus);
            btnAddToCart=itemView.findViewById(R.id.btnAddToCart);
        }
    }

}
