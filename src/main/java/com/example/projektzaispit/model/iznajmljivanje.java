package com.example.projektzaispit.model;

public class iznajmljivanje extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="DATETIME", size=6, isnull = false)
    String date;

    @ForeignKey(table = "cijena", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int cijena_id;

    @ForeignKey(table = "auto", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int auto_id;

    @ForeignKey(table = "korisnik", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int korisnik_id;

    @ForeignKey(table = "firma", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int firma_id;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCijena_id() {
        return cijena_id;
    }

    public void setCijena_id(int cijena_id) {
        this.cijena_id = cijena_id;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }
}

