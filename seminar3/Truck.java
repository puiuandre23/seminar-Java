package seminar3.VehicleManagementSystem;

public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(String brand, double speed, int mileage, boolean rented, double loadCapacity) {
        super(brand, speed, mileage, rented);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                ", loadCapacity=" + loadCapacity +
                ", mileage=" + mileage +
                ", rented=" + rented +
                '}';
    }

    @Override
    public boolean needsService() {
        return mileage >= 15000;
    }

    @Override
    public double rentalPrice(int days) {
        return 80 + (0.02*loadCapacity)*days;
    }
}
