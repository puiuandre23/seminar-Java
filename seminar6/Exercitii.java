package seminar6;

import seminar4.BankApp.InvalidAmountException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Exercitii {
    public static <T> void PrintTwice (T value){
        System.out.println(value + " " + value);
    }

    public static <T extends Comparable<T>> T max(T a, T b){
        return (T)(a.compareTo(b) >= 0 ? a : b);
    }

    public static <T> int countElements(List<T> array){
        return array.size();
    }

    public static <T> void copy(List<T> source, List<T> destination){
        destination.addAll(source);
    }

    public static void main(String[] args){
        Miau<Integer> val = new Miau<>(5);
        Miau<String> sir = new Miau<>("Pisica");
        System.out.println(val.getValue());
        System.out.println(sir.getValue());
        PrintTwice(val.getValue());
        PrintTwice(sir.getValue());
        System.out.println(max(val.getValue(), 40));
        System.out.println(max("Catelus", sir.getValue()));
        List<Integer> i = new ArrayList();
        List<String> s = new ArrayList();
        Collections.addAll(s, new String[]{"S", "O", "S"});
        i.add(10);
        i.add(20);
        i.add(30);
        i.add(40);
        System.out.println("Nr de elem din lista i:");
        System.out.println(countElements(i));
        System.out.println("Nr de elem din lista s:");
        System.out.println(countElements(s));

        List<Integer> iris = new ArrayList();
        copy(i, iris);

        for(Integer j : iris) {
            System.out.print(j + " ");
        }

        System.out.println("\n");
        System.out.println("Nr elem din lista iris:");
        System.out.println(countElements(iris));
        System.out.println("Stiva:");
        Stack<Integer> stack = new Stack<>();
        stack.Push(20);
        stack.Push(40);
        stack.getStack();
        System.out.println(stack.Pop());
        System.out.println(stack.Peek());
        System.out.println(stack.isEmpty());
    }

    static class Miau<T>{
        private T value;

        public Miau(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
    static class Stack<T>{
        private List<T> value = new ArrayList<>();

        public Stack() {
        }
        public void Push(T val){
            this.value.add(val);
        }
        public T Pop(){
            T val = (T)this.value.get(this.value.size()-1);
            this.value.remove(this.value.size()-1);
            return val;
        }
        public T Peek(){
            T val = (T)this.value.get(this.value.size()-1);
            return val;
        }

        public boolean isEmpty(){
            return this.value.isEmpty();
        }

        public void getStack() {
            for(T i: this.value){
                System.out.println(i);
            }
        }
    }
}
