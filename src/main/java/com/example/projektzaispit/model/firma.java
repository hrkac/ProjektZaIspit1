package com.example.projektzaispit.model;

public class firma extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String name;

    @Entity(type="VARCHAR", size=50, isnull = false)
    String address;

    @ForeignKey(table = "zaposlenik", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int zaposlenik_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZaposlenik_id() {
        return zaposlenik_id;
    }

    public void setZaposlenik_id(int zaposlenik_id) {
        this.zaposlenik_id = zaposlenik_id;
    }
}

