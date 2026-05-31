package seminar1;

public class Test {
    public static void main(String[] args){
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Laila", 2, "Golden Retriever");
        System.out.println(dog1);
        System.out.println(dog2.toString());
        dog1.bark();
        //exercitiu: de creat 2-3 clase(entitati) pt online.ase.ro
    }
}
