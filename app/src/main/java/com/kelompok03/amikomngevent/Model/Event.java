package com.kelompok03.amikomngevent.Model;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private String ID;
    private String judul;
    private String tanggal;
    private String tempat;
    private String kategori;
    private String harga;
    private String deskripsi;
    private String id_user;

    String postValue;

    public Event(){}

    public Event(String postValue) {
        this.postValue = postValue;
    }

    public String getPostValue() {
        return postValue;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Event(String ID, String judul, String tanggal, String tempat, String kategori, String harga, String deskripsi, String id_user) {
        this.ID = ID;
        this.judul = judul;
        this.tanggal = tanggal;
        this.tempat = tempat;
        this.kategori = kategori;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.id_user = id_user;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("judul", judul);
        result.put("kategori", kategori);
        result.put("tanggal", tanggal);
        result.put("lokasi", tempat);
        result.put("harga", harga);
        result.put("deskripsi", deskripsi);

        return result;
    }
}
