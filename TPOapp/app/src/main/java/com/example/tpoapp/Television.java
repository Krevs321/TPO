package com.example.tpoapp;

import java.util.ArrayList;

public class Television {

    public String ime;
    public ArrayList<String> ip_naslovi;

    Television(String ime, ArrayList<String> ip_naslovi) {
        this.ime = ime;
        this.ip_naslovi = ip_naslovi;
    }

    public String connect() {
        return "Povezava s " + this.ime + " je vzpostavljena.";
    }

    

}
