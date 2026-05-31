package seminar4.BankApp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args){
        String nume;
        double amount;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nume proprietar cont:");
        nume = scan.nextLine();
        System.out.println("Suma curenta a contului:");
        amount = scan.nextDouble();
        BankAccount b = new BankAccount(nume, amount);

        try{
            b.Depozit(100);
            b.WithDrawMoney(101);
        }catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        }catch(InsufficientFundsException e){
                System.out.println(e.getMessage());
        }finally{
            System.out.println("Toate operatiunile s-au finalizat cu succes.");
        }

    }
}
