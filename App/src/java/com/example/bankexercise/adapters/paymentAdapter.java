package com.example.bankexercise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankexercise.R;
import com.example.bankexercise.entities.Payment;
import com.example.bankexercise.holders.paymentViewHolder;

import java.util.List;

public class paymentAdapter extends RecyclerView.Adapter<paymentViewHolder> {

    List<Payment> paymentList;

    public paymentAdapter(List<Payment> payments){
        this.paymentList = payments;
    }

    @NonNull
    @Override
    public paymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cardView = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_payment,parent,false);
        return new paymentViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull paymentViewHolder holder, int position) {
        if((paymentList != null) && (paymentList.size() != 0)){
            Payment item = paymentList.get(position);

            holder.txtReciever.setText(item.Reciever);
            holder.txtValue.setText(item.Value);
        }
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }
}
