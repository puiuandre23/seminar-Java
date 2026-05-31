package seminar3.VehicleManagementSystem;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(Vehicle[] fleet, int size) {
        this.fleet = fleet;
        this.size = size;
    }

    public void add(Vehicle v){
        if(size >= fleet.length){
            throw new RuntimeException("Garajul este plin.");
        }

        for(int i = 0; i < size; i++){
            if(fleet[i].getID().equals(v.getID())){
                throw new RuntimeException("Exista deja un vehicul cu acest ID.");
            }
        }
        fleet[size] = v;
        size++;
    }

    public Vehicle findById(String id){
        for(int i = 0; i < size; i++){
            if(fleet[i].getID().equals(id)){
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id){
        for(int i = 0; i < size; i++){
            if(fleet[i].getID().equals(id)){
                fleet[i].setRented(true);
            }
        }
    }

    public void returnById(String id, int drivenKm){
        for(int i = 0; i < size; i++){
            if(fleet[i].getID().equals(id)){
                fleet[i].setMileage(fleet[i].getMileage()+drivenKm);
            }
        }
    }

    public void printAvailable(){
        for(int i = 0; i < size; i++){
            if(!fleet[i].isRented()){
                System.out.println(fleet[i]);
            }
        }
    }

    public void printNeedsService(){
        for(int i = 0; i < size; i++){
            if(fleet[i].needsService()){
                System.out.println(fleet[i]);
            }
        }
    }

    public void printRentalEstimate(String id, int days){
        for(int i = 0; i < size; i++){
            if(fleet[i].getID().equals(id)){
                System.out.println(fleet[i].rentalPrice(days));
            }
        }
    }

    public void Afisare(){
        for(int i = 0; i < size; i++){
            System.out.println(fleet[i]);

        }
    }
}
