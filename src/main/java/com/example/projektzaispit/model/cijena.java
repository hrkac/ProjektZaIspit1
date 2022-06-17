package com.example.projektzaispit.model;

public class cijena extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type="INTEGER", size=50, isnull = false)
    String price;

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

