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
import com.ankita.thirdtask.modal.FoodItem;

import java.util.ArrayList;

public class ItemFoodImgAdapter extends RecyclerView.Adapter<ItemFoodImgAdapter.ItemViewHolder> {
   private Context context;
   private ArrayList<FoodItem> arrayList;
   private ItemOnClick click;

  public ItemFoodImgAdapter(Context context, ArrayList<FoodItem> arrayList,ItemOnClick onClick){
      this.context=context;
      this.arrayList=arrayList;
      this.click=onClick;

  }

    @NonNull

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foodimages,parent,false);
        return new ItemViewHolder(view);
  }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
      holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tvDescription.setText(arrayList.get(position).getDescription());
        holder.tvPrice.setText(String.valueOf(arrayList.get(position).getPrice()));
        holder.tvQuantity.setText(String.valueOf(arrayList.get(position).getQuantity()));
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tvQuantity.setText(String.valueOf(Integer.parseInt(holder.tvQuantity.getText().toString())+1));
                arrayList.get(position).setQuantity(Integer.parseInt(holder.tvQuantity.getText().toString()));
                holder.tvPrice.setText(String.valueOf((Integer.parseInt(holder.tvQuantity.getText().toString()))*arrayList.get(position).getPrice()));
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(holder.tvQuantity.getText().toString())>1){
                    holder.tvQuantity.setText(String.valueOf(Integer.parseInt(holder.tvQuantity.getText().toString())-1));
                    arrayList.get(position).setQuantity(Integer.parseInt(holder.tvQuantity.getText().toString()));
                    holder.tvPrice.setText(String.valueOf((Integer.parseInt(holder.tvQuantity.getText().toString()))*arrayList.get(position).getPrice()));
                }
                else {
                    Toast.makeText(context, "you can not minus more", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.OnclickItem(position,holder);
            }
        });


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

