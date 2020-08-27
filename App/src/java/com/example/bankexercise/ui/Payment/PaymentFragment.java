package com.example.bankexercise.ui.Payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bankexercise.R;
import com.example.bankexercise.database.DBClassController;

public class PaymentFragment extends Fragment {

    private String UserID;
    private String RecieverID;
    private String Password;
    private String Value;

    EditText edtIDReciever;
    EditText edtPassword;
    EditText edtIDUser;
    EditText edtValue;

    private TextView txtRecieverUsername;

    Button btnConfirmPayment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_payment, container, false);

        edtIDReciever = root.findViewById(R.id.edtIDReciever);
        edtPassword = root.findViewById(R.id.edtPassword);
        edtIDUser = root.findViewById(R.id.edtIDUser);
        edtValue = root.findViewById(R.id.edtValue);

        txtRecieverUsername = root.findViewById(R.id.txtRecieverUsername);

        btnConfirmPayment = root.findViewById(R.id.btnConfirmPayment);

        //Instantiating Database Controller Class

        final DBClassController dbClassController = new DBClassController();

        final PaymentFragment paymentFragment = this;

        //Executing query for ID everytime User types some ID for the reciever of the payment

        edtIDReciever.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!(edtIDReciever.getText().toString().equals(""))){
                dbClassController.verifyUserById(edtIDReciever.getText().toString().trim(),paymentFragment);
                }
            }
        });

        btnConfirmPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Settings Values for query

                setUserID(edtIDUser.getText().toString().trim());
                setRecieverID(edtIDReciever.getText().toString().trim());
                setPassword(edtPassword.getText().toString().trim());
                setValue(edtValue.getText().toString().trim());




                //Executing Query
                try {

                    dbClassController.doPayment(getContext(), Integer.parseInt(getUserID()), Integer.parseInt(getRecieverID()), Double.parseDouble(getValue()));
                }catch(NumberFormatException ex){
                    Toast.makeText(getContext(),"Some of the values are in incorrect format.",Toast.LENGTH_LONG).show();
                }

            }
        });

        return root;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getRecieverID() {
        return RecieverID;
    }

    public void setRecieverID(String recieverID) {
        RecieverID = recieverID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public TextView getTxtRecieverUsername() {
        return txtRecieverUsername;
    }

    public void setTxtRecieverUsername(TextView txtRecieverUsername) {
        this.txtRecieverUsername = txtRecieverUsername;
    }
}