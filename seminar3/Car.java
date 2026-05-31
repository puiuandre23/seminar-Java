package seminar3.VehicleManagementSystem;

public class Car extends Vehicle{

    private int doors;
    public Car(String brand, double speed, int mileage, boolean rented, int doors, int days) {
        super(brand, speed, mileage, rented);
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                ", doors=" + doors +
                ", mileage= " + mileage +
                ", rented= " + rented +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean needsService() {
        return mileage >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        if(doors>=4){
            return 50*days + 50*days*0.1;
        }
        else{
            return 50*days;
        }
    }
}
