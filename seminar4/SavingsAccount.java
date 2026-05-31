package seminar4.BankApp;

public class SavingsAccount extends BankAccount{
    private double economii;
    public SavingsAccount(String nume, double capacitate, double economii) {
        super(nume, capacitate);
        this.economii = economii;
    }

    public double getEconomii() {
        return economii;
    }

    public void setEconomii(double economii) {
        this.economii = economii;
    }

}
