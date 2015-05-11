package com.example.karsten_adolf.bartail_demo;

/**
 * Created by René on 11.05.2015.
 */
public class Bar {
    private int ID;
    private String Name;
    private String Adresse;
    private String PLZ;
    private String Ort;
    private String Oeffnungszeiten;
    private String Schliessungszeiten;
    private String Link;
    private String Beschreibung;
    private String Musikrichtung;

    public Bar()
    {
        ID=0;
        Name="";
        Adresse="";
        PLZ="";
        Ort="";
        Oeffnungszeiten="";
        Schliessungszeiten="";
        Link="";
        Beschreibung="";
    }


    public Bar(int ID, String name, String adresse, String PLZ, String ort, String oeffnungszeiten, String schliessungszeiten, String link, String beschreibung, String musikrichtung) {
        this.ID = ID;
        Name = name;
        Adresse = adresse;
        this.PLZ = PLZ;
        Ort = ort;
        Oeffnungszeiten = oeffnungszeiten;
        Schliessungszeiten = schliessungszeiten;
        Link = link;
        Beschreibung = beschreibung;
        Musikrichtung = musikrichtung;
    }

    public String getOeffnungszeiten() {
        return Oeffnungszeiten;
    }

    public void setOeffnungszeiten(String oeffnungszeiten) {
        Oeffnungszeiten = oeffnungszeiten;
    }

    public String getSchliessungszeiten() {
        return Schliessungszeiten;
    }

    public void setSchliessungszeiten(String schliessungszeiten) {
        Schliessungszeiten = schliessungszeiten;
    }

    public String getMusikrichtung() {
        return Musikrichtung;
    }

    public void setMusikrichtung(String musikrichtung) {
        Musikrichtung = musikrichtung;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }


}
