package com.example.bankexercise.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.bankexercise.ConnectionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class doPayment extends AsyncTask<String,String,String> {

    @SuppressLint("StaticFieldLeak")
    Context context;

    public doPayment(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        String IDUser = strings[0];
        String IDReciever = strings[1];
        String Value = strings[2];


        try {

            String data = URLEncoder.encode("IDUser", "UTF-8")
                    + "=" + URLEncoder.encode(IDUser, "UTF-8");
            data += "&" + URLEncoder.encode("IDReciever", "UTF-8")
                    + "=" + URLEncoder.encode(IDReciever, "UTF-8");
            data += "&" + URLEncoder.encode("Value", "UTF-8")
                    + "=" + URLEncoder.encode(Value, "UTF-8");
            data += "&" + URLEncoder.encode("Route", "UTF-8")
                    + "=" + URLEncoder.encode("doPayment", "UTF-8");


            String text = "";
            BufferedReader reader = null;

            try {



                URL url = new URL(ConnectionData.getURL()+"/Routes.php"); //change ip number in url for the one of your local machine

                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                OutputStreamWriter OStreamWritter = new OutputStreamWriter(connection.getOutputStream());
                OStreamWritter.write(data);
                OStreamWritter.flush();

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;

                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                text = stringBuilder.toString();


            }catch (MalformedURLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String resp) {
        Toast.makeText(context,resp,Toast.LENGTH_LONG).show();
    }
}
