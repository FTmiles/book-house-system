package com.books;

public class Main {
    public static void main(String[] args) {

        Biblioteka bl = new Biblioteka(new GUI());
//        Biblioteka bl = new Biblioteka(new CLI());
        bl.start();

    }
}
