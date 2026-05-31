package seminar3.VehicleManagementSystem;

public class Motorcycle extends Vehicle{
    private boolean hasSidecar;

    public Motorcycle(String brand, double speed, int mileage, boolean rented, boolean hasSidecar) {
        super(brand, speed, mileage, rented);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorcycle{" + super.toString() +
                ", hasSidecar=" + hasSidecar +
                ", mileage=" + mileage +
                ", rented=" + rented +
                '}';
    }

    @Override
    public boolean needsService() {
        return mileage >= 6000;
    }

    @Override
    public double rentalPrice(int days) {
        if(hasSidecar){
            return 30*days + 15/days;
        }
        else {
            return 30*days;
        }
    }
}
