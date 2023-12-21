package com.books;

public class Book {
    private String title;
    private String author;
    private String year;
    private int id;
    private static int nextId = 0;

    public Book(String title, String author, String year) {
        this.id = nextId++;

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toFancyString() {
        return String.format("%3d. %20s --- %30s --- %4s",id, author, title, year);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //<editor-fold desc="GETTERS/SETTERS">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    //</editor-fold>
}
