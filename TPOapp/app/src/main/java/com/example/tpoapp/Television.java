package com.example.tpoapp;

import java.util.ArrayList;

public class Television {

    public String ime;
    public String ip_naslov;

    Television(String ime, String ip_naslov) {
        this.ime = ime;
        this.ip_naslov = ip_naslov;
    }

    public String connect() {
        return "Povezava s " + this.ime + " je vzpostavljena.";
    }

    public String connectToServer(String imeServer){
        return "Povezano s " + imeServer + ".";
    }
}
