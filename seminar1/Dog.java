package seminar1;

public class Dog implements Behavior{
    private String name;
    private int age;
    private String race;

    public Dog(){
    }

    //right click mouse -> generate -> constructor -> select toti param
    public Dog(String name, int age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    //right click mouse -> generate -> getter & setter -> select toti param
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getRace() { return race; }

    public void setRace(String race) { this.race = race; }

    //right click mouse -> generate -> toString()
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", race='" + race + '\'' +
                '}';
    }

    @Override
    public void bark() {
        System.out.println("Ham Ham!");
    }
}
