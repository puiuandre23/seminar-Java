package seminar5;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<String> students = new ArrayList<>();
        students.add("Andrei");
        students.add("Bogdan");
        students.add("Camelia");
        students.add("David");
        System.out.println(students);

        for(String i: students){
            System.out.println(i);
        }

        students.remove(2);
        System.out.println();
        System.out.println(students);

        for(String i: students){
            System.out.println(i);
        }

        ArrayList<Integer> sir = new ArrayList<>();
        sir.add(10);
        sir.add(5);
        Collections.addAll(sir, new Integer[]{30, 40, 50, 60, 23, 70, 10, 35, 67});


        float sum = 0.0F;
        for(Integer i : sir){
            sum += (float)i;
        }
        System.out.println("Suma nr. este: " + sum);
        float medie = sum/(float)sir.size();
        System.out.println("Media nr. este: " + medie);

        for(Integer i : sir) {
            System.out.print(i + " ");
        }
        ArrayList<Integer> reversedSir = new ArrayList<>();
        for(int i = sir.size()-1; i>=0; --i){
            reversedSir.add((Integer)sir.get(i));
        }

        System.out.println("\nReversed Sir: ");

        for(Integer i : reversedSir) {
            System.out.print(i + " ");
        }

        System.out.println();
        Set<String> sir2 = new HashSet<>();
        String sentence = "Ana are are mere si pere dar de fapt nu are mere";
        String[] s = sentence.split(" ");

        for(String i : s){
            sir2.add(i);
        }

        System.out.println("Cuvintele unice: ");
        for(String i : sir2) {
            System.out.print(i + " ");
        }

        System.out.println("\nNr de cuvinte unice: " + sir2.size());

        Map<String, Integer> fraza = new HashMap<>();
        String s2 = "apple banana apple orange banana apple";
        String[] string = s2.split(" ");

        for(String i : string){
            if(fraza.containsKey(i)){
                fraza.put(i, (Integer)fraza.get(i)+1);
            }
            else{
                fraza.put(i,1);
            }
        }

        for(Map.Entry<String, Integer> entry: fraza.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, String> bn = new HashMap<>();
        bn.put("Marcel", "0712345678");
        bn.put("Carmen", "0722355628");
        bn.put("Ana", "0742349698");
        String nume = "Costel";
        if(bn.containsKey(nume)){
            System.out.println("Nr. lui " + nume + " este " + (String)bn.get((nume)));
        }
        else{
            System.out.println("Contactul nu exista.");
        }

        ArrayList<Student> catalog = new ArrayList<>();
        catalog.add(new Student("Ana", 5));
        catalog.add(new Student("Bogdan", 9));
        catalog.add(new Student("Ion", 8));
        catalog.add(new Student("Victor", 10));
        catalog.add(new Student("Ana", 5));
        catalog.add(new Student("Bogdan", 9));
        Student maxgrade = (Student)catalog.get(0);

        for(Student stud : catalog){
            if(stud.grade > maxgrade.grade){
                maxgrade = stud;
            }
        }

        System.out.println("Studentul cu nota cea mai mare este: " + maxgrade.nume + ", cu nota: " + maxgrade.grade);
        catalog.sort(Comparator.comparing((Student stx) -> stx.nume));
        System.out.println("Dupa nume: \n" + String.valueOf(catalog));
        catalog.sort(Comparator.comparingInt((Student stx) -> stx.grade).reversed());
        System.out.println("Dupa nota (desc): \n" + String.valueOf(catalog));
        System.out.println("Removed duplicates:");
        Set<Student> listStudent = new HashSet<>(catalog);
        System.out.println(listStudent);
    }
}
