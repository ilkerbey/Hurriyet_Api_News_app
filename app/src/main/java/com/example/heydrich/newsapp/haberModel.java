package com.example.heydrich.newsapp;

import java.util.ArrayList;

/**
 * Created by heydrich on 1.3.2018.
 */

public class haberModel {
    private String Aciklama,Baslik;
    private String Url;
    private ArrayList<haberGorsel> Files;
    public haberModel(){}

    public haberModel(String aciklama, String baslik, String url, ArrayList<haberGorsel> files) {
        Aciklama = aciklama;
        Baslik = baslik;
        Url = url;
        Files = files;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String baslik) {
        Baslik = baslik;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public ArrayList<haberGorsel> getFiles() {
        return Files;
    }

    public void setFiles(ArrayList<haberGorsel> files) {
        Files = files;
    }
}
