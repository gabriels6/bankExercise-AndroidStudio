package com.example.bankexercise.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankexercise.R;

public class paymentViewHolder extends RecyclerView.ViewHolder {

    public TextView txtReciever;
    public TextView txtValue;

    public paymentViewHolder(@NonNull View itemView) {
        super(itemView);

        View view = itemView;

        txtReciever = view.findViewById(R.id.txtReciever);
        txtValue = view.findViewById(R.id.txtValue);

    }
}
