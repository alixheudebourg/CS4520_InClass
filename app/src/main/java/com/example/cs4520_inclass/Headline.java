package com.example.cs4520_inclass;


import java.util.ArrayList;

public class Headline {

    private String country;
    private String category;
    private ArrayList<String> sources;
    private String q;

    public Headline() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getSources() {
        return sources;
    }

    public void setSources(ArrayList<String> sources) {
        this.sources = sources;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
