package com.example.bankexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bankexercise.database.DBClassController;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);

        btnLogin = findViewById(R.id.btnLogin);

    }

    public void clickAuthLogin(View view){

        DBClassController dbClassController = new DBClassController();

        dbClassController.authLogin(this,edtName.getText().toString(),edtPass.getText().toString());

    }
}