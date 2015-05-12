package com.example.karsten_adolf.bartail_demo;

/**
 * Created by René on 11.05.2015.
 */
public class Bewertung {
    private int userid;
    private int barid;
    private int rating;
    private String Kommentar;

    public Bewertung() {
        userid=0;
        barid=0;
        rating=0;
        Kommentar="";
    }

    public Bewertung(int userid, int barid, int rating, String kommentar) {
        this.userid = userid;
        this.barid = barid;
        this.rating = rating;
        Kommentar = kommentar;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBarid() {
        return barid;
    }

    public void setBarid(int barid) {
        this.barid = barid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getKommentar() {
        return Kommentar;
    }

    public void setKommentar(String kommentar) {
        Kommentar = kommentar;
    }
}
