package seminar3.VehicleManagementSystem;

public class Main {
    public static void main(String[] args){
        Car c1 = new Car("Porsche", 230,10001, true,2, 5);
        Truck t1 = new Truck("Toyota", 200, 10, true,30);
        Motorcycle m1 = new Motorcycle("Kawasaki", 200, 1000, false, false);
        Vehicle[] v = new Vehicle[5];
        v[0] = c1;
        v[1] = t1;
        v[2] = m1;
        v[3]=new Car("Porsche",300, 100,false, 3,4);
        v[4]=new Motorcycle("Honda",150, 0, false, true);

        System.out.println(v[0].equals(v[3]));
        v[0].setSpeed(300);
        System.out.println(v[0].equals(v[3]));

        Garage garaj = new Garage(v,5);

        //Vehicle[] v1 = new Vehicle[1];
        //v1[0] = new Car("Seat", 150,100,true,4,6);

        //garaj.add(v1[0]);
        System.out.println("Toate vehiculele din garaj:");
        garaj.Afisare();

        System.out.println("\nVehicule disponibile:");
        garaj.printAvailable();

        System.out.println("\nVehicule care au nevoie de service:");
        garaj.printNeedsService();
    }
}
