package seminar4.BankApp;

public class BankAccount {
    private String nume;
    private double cont;

    public BankAccount(String nume, double capacitate) {
        this.nume = nume;
        this.cont = capacitate;
    }

    public double getCont() {
        return cont;
    }

    public void setCont(double cont) {
        this.cont = cont;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void Depozit(double bani) throws InvalidAmountException{
        if(bani<1){
            throw new InvalidAmountException("Suma este invalida -> cantitate negativa.");
        }
        this.cont +=bani;
    }
    public void WithDrawMoney(double amount) throws InsufficientFundsException{
        if (amount <= 0) {
            throw new InvalidAmountException("Suma dorita a fi extrasa din cont trebuie sa fie pozitiva.");
        }
        if(amount > this.cont){
            throw new InsufficientFundsException("Fonduri insuficiente.");
        }
        cont -=amount;
        System.out.println("Ai extras suma dorita. Suma curenta: " + cont);
    }
}
