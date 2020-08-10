package com.example.bankexercise.database;

import android.content.Context;

public class DBClassController {

    public void authLogin(Context context, String Username, String Password){

        authLogin authLogin = new authLogin(context);

        authLogin.execute(Username,Password);

    }

}
