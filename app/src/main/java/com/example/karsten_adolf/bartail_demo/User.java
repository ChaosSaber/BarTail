package com.example.karsten_adolf.bartail_demo;

/**
 * Created by René on 11.05.2015.
 */
public class User {
    private int User_ID;
    private String Username;
    private String E_mail;
    private String Passwort;

    public User()
    {
        User_ID=0;
        Username="";
        E_mail="";
        Passwort="";
    }

    public User(String username,String e_mail,String passwort)
    {
        Username=username;
        E_mail=e_mail;
        Passwort=passwort;
    }

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


}
