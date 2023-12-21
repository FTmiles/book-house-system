package com.books;

import java.util.Scanner;


public class Ui {
    Scanner sc = new Scanner(System.in);

    public void spausdinkMenu() {
        System.out.println("""
           ===BIBLIOTEKAS VALDYMO PROGRAMA===
               1. Prideti knyga
               2. Pasalinti knyga
               3. Rodyti knygu sarasa
               
               4. Prideti skaitytoja
               5. Pasalinti skaitytoja
               6. Rodyti skaitytoju sarasa
               7. Ieskoti knygos
               X. Baigti darba
                                
               Pasirinkite veiksma
                """);
    }

    public String getVartotojoPasirinkimas() {
        String input = sc.nextLine();
        if (input.isEmpty()) return "";
        return input.substring(0, 1);
    }

    public void scannerClose() {
        if (sc != null) sc.close();
    }

    public String getUserInput(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }
}