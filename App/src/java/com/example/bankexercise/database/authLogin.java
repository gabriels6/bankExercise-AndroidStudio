package com.example.bankexercise.database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankexercise.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class authLogin extends AsyncTask<String,String,String> {

    Context context;

    public authLogin(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        String Username = strings[0];
        String Password = strings[1];



        try {

            String data = URLEncoder.encode("Username", "UTF-8")
                    + "=" + URLEncoder.encode(Username, "UTF-8");
            data += "&" + URLEncoder.encode("Password", "UTF-8")
                    + "=" + URLEncoder.encode(Password, "UTF-8");
            data += "&" + URLEncoder.encode("Route", "UTF-8")
                    + "=" + URLEncoder.encode("authLogin", "UTF-8");


            String text = "";
            BufferedReader reader = null;

            try {
                URL url = new URL("http://192.168.0.101/Routes.php"); //cahange ip number in url for the one of your local machine

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

        String[] splitString = resp.split("\n");

        if(splitString.length > 1){
            Intent getMenu;

            getMenu = new Intent(context, Menu.class);
            Bundle params = new Bundle();

            ((AppCompatActivity) context).startActivityForResult(getMenu, 1);

        }
    }
}
