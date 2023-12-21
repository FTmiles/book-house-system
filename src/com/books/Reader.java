package com.books;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reader {
    private String vartotojoVardas;
    private String telephone;
    private final LocalDate regDate;
    private Book pasirinktaKnyga;
    private LocalDate pasiemimoData;
    private int id;
    private static int nextId;


    public Reader(String vartotojoVardas, String telephone) {
        this.id = nextId++;
        this.regDate = LocalDate.now();

        this.vartotojoVardas = vartotojoVardas;
        this.telephone = telephone;
    }

    public String toFancyString() {
        return String.format("%3d. %20s --- %19s --- %8s",id, vartotojoVardas, telephone, regDate);

    }


    //<editor-fold desc="GETTERS/SETTERS">
    public String getVartotojoVardas() {
        return vartotojoVardas;
    }

    public void setVartotojoVardas(String vartotojoVardas) {
        this.vartotojoVardas = vartotojoVardas;
    }

    public Book getPasirinktaKnyga() {
        return pasirinktaKnyga;
    }

    public void setPasirinktaKnyga(Book pasirinktaKnyga) {
        this.pasirinktaKnyga = pasirinktaKnyga;
    }

    public LocalDate getPasiemimoData() {
        return pasiemimoData;
    }

    public void setPasiemimoData(LocalDate pasiemimoData) {
        this.pasiemimoData = pasiemimoData;
    }
    //</editor-fold>



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
