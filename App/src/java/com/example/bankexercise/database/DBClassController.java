package com.example.bankexercise.database;

import android.content.Context;

import com.example.bankexercise.ui.Payment.PaymentFragment;

public class DBClassController {


    public void authLogin(Context context, String Username, String Password){

        authLogin authLogin = new authLogin(context);

        authLogin.execute(Username,Password);

    }

    public void doPayment(Context context,int IDUser,int IDReciever,Double Value){

        doPayment doPayment = new doPayment(context);

        doPayment.execute(""+IDUser,""+IDReciever,""+Value);

    }



    public void verifyUserById(String IDUser, PaymentFragment paymentFragment){

        verifyUserByID verifyUserByID = new verifyUserByID(paymentFragment);

        verifyUserByID.execute(IDUser);

    }

}
