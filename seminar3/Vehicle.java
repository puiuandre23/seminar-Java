package seminar3.VehicleManagementSystem;
import java.util.Date;
import java.util.Objects;

public abstract class Vehicle {
    private String brand;
    private double speed;
    private static int counter = 1;
    private final String ID;
    int mileage;
    boolean rented;

    public Vehicle(String brand, double speed, int mileage, boolean rented) {
        this.ID = "Veh" + counter++;
        this.brand = brand;
        this.speed = speed;
        this.mileage = mileage;
        this.rented = rented;
    }


    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public double getSpeed() { return speed; }

    public void setSpeed(double speed) { this.speed = speed; }

    public String getID() { return ID; }

    public int getMileage() { return mileage; }

    public void setMileage(int mileage) { this.mileage = mileage; }

    public boolean isRented() { return rented; }

    public void setRented(boolean rented) { this.rented = rented; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle)obj;
        return Double.compare(speed, vehicle.speed) == 0 && Objects.equals(brand, vehicle.brand);
    }

    @Override
    public int hashCode() { return Objects.hash(brand,speed); }

    public void rent(){
        if(rented) {
            throw new RuntimeException("Acest vehicul este deja inchiriat.");
        }
    }

    public void returnVehicle(int drivenKm){
        if(!rented){
            throw new RuntimeException("Acest vehicul nu este inchiriat.");
        }
        else {
            if(drivenKm > 0){
                mileage += drivenKm;
                rented = false;
            }
        }
    }

    @Override
    public String toString() {
        return  "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", ID='" + ID + '\'';
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}
