package com.books;

public interface UI {
    void spausdinkMenu();
    String getVartotojoPasirinkimas();
    String getUserInput(String msg);
    void infoOut(String msg);
    void goodbyeAction();
    void start(Biblioteka mainLogic);
}
