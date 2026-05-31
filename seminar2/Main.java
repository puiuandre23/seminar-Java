package seminar2;

public class Main {
    public static void main(String[] args){
        System.out.print("Hello and welcome!\n");

        for (int i = 1; i <= 5; i++) {
             System.out.println("i = " + i);
        }
        Book b1=new Book();
        Book b2=new Book("Amintiri din copilărie","Ion Creangă",15.5);
        System.out.println(b2);
        System.out.println(b2.getPret());
    }
}

//1. creati o clasa Books -> adaugati 3 atribute
// creati: constructori; 2 obiecte: unul gol si altul cu 3 param
//2. incapsulare pt clasa books


