package com.example.karsten_adolf.bartail_demo.DBFiles;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by Rene on 11.05.2015.
 */

@DatabaseTable(tableName = "bar")
public class Bar {

    @DatabaseField(generatedId = true)
    private int ID;

    @DatabaseField(columnName = "Name")
    private String Name;

    @DatabaseField(columnName = "Adresse")
    private String Adresse;

    @DatabaseField(columnName = "PLZ")
    private String PLZ;

    @DatabaseField(columnName = "Ort")
    private String Ort;

    @DatabaseField(columnName = "Oeffnungszeiten")
    private String Oeffnungszeiten;

    @DatabaseField(columnName = "Schliessungszeiten")
    private String Schliessungszeiten;

    @DatabaseField(columnName = "Link")
    private String Link;

    @DatabaseField(columnName = "Beschreibung")
    private String Beschreibung;

    @DatabaseField(columnName = "Musikrichtung")
    private String Musikrichtung;

    public Bar()
    {
        //an empty constructor is needed by ORMLite
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



    @Override
    public String toString() {
        return "Bar{" + "ID=" + ID + ", Name='" + Name + '\'' + ", Adresse='" + Adresse +
                '\'' + ", PLZ=" + PLZ + ", Ort= " + Ort +  ", Oeffnungszeiten='" + Oeffnungszeiten + '\'' + ", Schliessungszeiten='" + Schliessungszeiten + '\'' +  ", Beschreibunge='" + Beschreibung + '\'' +  ", Musikrichtung='" + Musikrichtung + '\'' + '}';
    }



    //Getter and Setter

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
