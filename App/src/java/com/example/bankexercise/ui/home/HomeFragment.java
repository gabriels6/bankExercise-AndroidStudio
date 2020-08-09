package com.example.bankexercise.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankexercise.R;
import com.example.bankexercise.adapters.paymentAdapter;
import com.example.bankexercise.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    RecyclerView recyclerPayment;
    paymentAdapter adapter;
    List<Payment> paymentList = new ArrayList<>();

    String Reciever,Value;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerPayment = root.findViewById(R.id.recyclerPayments);

        int amountPayments = paymentList.size();


        for(int i = 0;i < amountPayments; i++){
            Payment payment = paymentList.get(i);

            Reciever = payment.Reciever;
            Value = payment.Value;
        }

        adapter = new paymentAdapter(paymentList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerPayment.setLayoutManager(layoutManager);
        recyclerPayment.setAdapter(adapter);

        return root;
    }
}