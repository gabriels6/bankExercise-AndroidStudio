package com.example.bankexercise;

import java.io.Serializable;

public class ConnectionData implements Serializable {

    private static final String URL = "http://192.168.0.101"; //Change the numbers in URL to your server's IP

    public static String getURL() {
        return URL;
    }
}
