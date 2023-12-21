package com.books;

import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    Ui ui;
    List<Book> bookArr = new ArrayList<>();
    List<Reader> readerArr = new ArrayList<>();

    public Biblioteka(Ui ui) {
        this.ui = ui;
    }

    public void start() {
        //add test data
        bookArr.add(new Book("To Kill a Mockingbird", "Harper Lee", "1960"));
        bookArr.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", "1955"));
        bookArr.add(new Book("Animal Farm", "George Orwell", "1945"));
        bookArr.add(new Book("The Catcher in the Rye", "J.D. Salinger", "1951"));
        bookArr.add(new Book("A Clockwork Orange", "Anthony Burgess", "1962"));
        bookArr.add(new Book("Slaughterhouse-Five", "Kurt Vonnegut Jr.", "1969"));
        bookArr.add(new Book("On the Road", "Jack Kerouac", "1959"));

        readerArr.add(new Reader("Barbara Liskov", "+370-612-65613"));
        readerArr.add(new Reader("Brendan Eich","+86-186-5013-1853"));
        readerArr.add(new Reader("Homer Simpson", "+1 (234) 53583"));

        //---------------test data END


        boolean nebaigti = true;
        while (nebaigti) {
            ui.spausdinkMenu();
            String vartotojoPasirinkimas = ui.getVartotojoPasirinkimas();
            nebaigti = apdorokPasirinkima(vartotojoPasirinkimas);
        }
        ui.scannerClose();
    }

    boolean apdorokPasirinkima(String str) {
        if (str.equalsIgnoreCase("x")) return false;
        switch (str) {
            case "1" -> addBook();
            case "2" -> removeBook();
            case "3" -> printBookList(bookArr);
            case "4" -> addReader();
            case "5" -> removeReader();
            case "6" -> printAllReaders();
            case "7" -> ieskotiKnygos();
        }
        return true;
    }

    private void ieskotiKnygos() {
        String searchText = ui.getUserInput("Knygos paieska \n Iveskite knygos pavadinima, autoriu, arba metus\n").toLowerCase();
        List<Book> fltrBookArr = bookArr.stream().filter(book-> book.getTitle().toLowerCase().contains(searchText) ||
                                                book.getAuthor().toLowerCase().contains(searchText) ||
                                                book.getYear().toLowerCase().contains(searchText)).toList();

        System.out.println(fltrBookArr);
        printBookList(fltrBookArr);

    }

    private void addBook() {
        System.out.println("Knygos ivestis. Iveskite knygos");

        String title = ui.getUserInput("\t• Pavadinima: ");
        String author = ui.getUserInput("\t• Autoriu: ");
        String year = ui.getUserInput("\t• Metus: ");

        bookArr.add( new Book(title, author, year));

    }

    private void removeBook(){
        printBookList(bookArr);
        String pasirinkimasStr = ui.getUserInput("Kuria knyga istrinti?\n\t•ID:");
        int pasirinkimas = -1;
        try{
            pasirinkimas = Integer.parseInt(pasirinkimasStr);
        } catch (NumberFormatException e) {
            System.out.println("Blogai ivedei ID - knyga nebuvo istrinta");
        }

        for (Book book : bookArr) {
            if (book.getId() == pasirinkimas){
                bookArr.remove(book);
                System.out.println("Knyga istrinta\n" + book.toFancyString());
                break;
            }

        }

    }

    private void printBookList(List<Book> bookList){
        ui.infoOut(String.format("%3s. %20s --- %30s --- %4s", "ID", "Author", "Title", "Year"));

        for (Book book : bookList) {
            ui.infoOut(book.toFancyString());
        }

    }


    private void addReader(){
        ui.infoOut("Skaitytojo ivestis. Iveskite skaitytojo");

        String vardas = ui.getUserInput("\t•Varda: ");
        String telephone = ui.getUserInput("\t•Telephone: ");

        readerArr.add( new Reader(vardas, telephone));

    }

    private void removeReader(){
        printAllReaders();
        String pasirinkimasStr = ui.getUserInput("Kuri skaitytoja istrinti?\n\t•ID:");
        int pasirinkimas = -1;
        try{
            pasirinkimas = Integer.parseInt(pasirinkimasStr);
        } catch (NumberFormatException e) {
            ui.infoOut("Blogai ivedei ID - skaitytojas nebuvo istrintas");
        }

        for (Reader reader : readerArr) {
            if (reader.getId() == pasirinkimas){
                readerArr.remove(reader);
                ui.infoOut("Skaitytojas istrintas\n" + reader.toFancyString());
                break;
            }
        }

    }

    private void printAllReaders() {
        ui.infoOut(String.format("%3s. %20s --- %19s --- %8s", "id", "Vardas", "telephone", "regDate"));

        for (Reader reader : readerArr) {
            ui.infoOut(reader.toFancyString());
        }
    }






};



