package com.example.karsten_adolf.bartail_demo;


import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jonas on 26.05.15.
 */
public class Hash {

    private static final String TAG = "Hash";
    private MessageDigest md;

    public Hash(){
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            Log.d(TAG, "Hash(): Fehler in der Algorithmus-Angabe! " + e.getMessage());
        }
    }

    public String hashing (String toHash){
        String hash;
        md.reset();

        try {
            md.update(toHash.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
            Log.d(TAG, "hashing(): falsche Encodierung! " + e.getMessage());
        }

        byte[] hash_value = md.digest();
        StringBuffer hexString = new StringBuffer();

        for (int i=0; i<hash_value.length; i++){
            hexString.append(Integer.toHexString(0xFF & hash_value[i]));
        }
        hash = hexString.toString();

        return hash;
    }
}
