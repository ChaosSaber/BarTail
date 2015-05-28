package com.example.karsten_adolf.bartail_demo.DBFiles;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.example.karsten_adolf.bartail_demo.helper.Hash;



/**
 * Created by Rene on 11.05.2015.
 */

@DatabaseTable(tableName = "user")
public class User {

    @SuppressWarnings("unused")
    @DatabaseField(generatedId = true, columnName = "id")
    private int User_ID;

    @DatabaseField(unique = true, columnName = "Username")
    private String Username;

    @DatabaseField(columnName = "password")
    private String Passwort;

    @DatabaseField(columnName = "e_mail")
    private String E_mail;


    public User() {
        //an empty constructor is needed by ORMLite
    }

    public User(String name, String e_mail, String password) {

        Hash hashClass = new Hash();
        this.Username = name;
        this.Passwort = hashClass.hashing(password);
        this.E_mail = e_mail;
    }

    public User(String e_mail,String password) {


        Hash hashClass = new Hash();
        this.Passwort = hashClass.hashing(password);
        this.E_mail = e_mail;
    }


    @Override
    public String toString() {
        return "User{" + "User_ID=" + User_ID + ", Username='" + Username + '\'' + ", Passwort='" + Passwort + '\''
                + ", E_mail= " + E_mail + '}';
    }



    //Getter and Setter
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        this.Passwort = passwort;
    }

    public  Boolean login(String passwort)
    {
        if(Passwort==passwort)
            return true;
        return false;
    }

}