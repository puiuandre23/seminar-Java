package seminar11.reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@interface InfoStud{
    String author();
    String version();
}


@InfoStud(author = "Demo Student", version = "1.0")
class Student{
    private String numeStud;
    private int varsta;

    public Student(){
        this.numeStud = "necunoscut";
        this.varsta = 0;
    }

    public Student(String numeStud) {
        this.numeStud = numeStud;
    }

    public Student(String numeStud, int varsta){
        this.numeStud = numeStud;
        this.varsta = varsta;
    }

    public void sayHello(){
        System.out.println("Salut! Ma numesc " + numeStud + ".");
    }

    private void secretMethod(){
        System.out.println("Aceasta este o metoda secreta.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "numeStud='" + numeStud +
                "', varsta=" + varsta +
                '}';
    }
}

public class ReflectionsExercises {
    public static void main(String[] args){
        try {
            Class<?> studentClass = Student.class;

            System.out.println("--- Class Info ---");
            System.out.println("Nume clasa: " + studentClass.getSimpleName());
            System.out.println("Package: " + studentClass.getPackage());
            System.out.println("Superclass: " + studentClass.getSuperclass().getName());
            System.out.println("Interfete: " + Arrays.toString(studentClass.getInterfaces()));

            System.out.println("--- Fields ---");
            for (Field f : studentClass.getDeclaredFields()){
                System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName());
            }

            System.out.println("--- Metode ---");
            for (Method m : studentClass.getDeclaredMethods()){
                System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getSimpleName() + " " + m.getName());
            }

            Constructor<?> constructor = studentClass.getConstructor();
            Object s1 = constructor.newInstance();

            System.out.println("\n --- Call method sayHello() ---");
            studentClass.getMethod("sayHello").invoke(s1);

            System.out.println("\n --- Access private field ---");
            Field nf = studentClass.getDeclaredField("numeStud");
            nf.setAccessible(true);
            nf.set(s1,"Maria");
            System.out.println("Student nou: " + nf.get(s1));

            System.out.println("\n--- Call Private Method ---");
            Method privateMethod = studentClass.getDeclaredMethod("secretMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(s1);

            System.out.println("\n --- Constructori ---");
            Constructor<?> constructor1 = studentClass.getConstructor(String.class);
            Object s2 = constructor1.newInstance("Gigel");
            Constructor<?> constructor2 = studentClass.getConstructor(String.class, int.class);
            Object s3 = constructor2.newInstance("Ion", 22);
            System.out.println(s2 + "\n" + s3);

            System.out.println("\n--- 9. Inspect Object ---");
            inspect(s3);

            // 10. JSON Serializer
            System.out.println("\n--- 10. JSON Serializer ---");
            System.out.println(toJson(s3));

            // 11. CSV Mapper
            System.out.println("\n--- 11. CSV Mapper ---");
            Student sCsv = fromCsv("Elena,25", Student.class);
            System.out.println("From CSV: " + sCsv);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void inspect(Object obj) throws IllegalAccessException {
        Class<?> cl = obj.getClass();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " = " + f.get(obj));
        }
    }

    // Task 10
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> cl = obj.getClass();
        List<String> pairs = new ArrayList<>();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            String value = f.get(obj) instanceof String ? "\"" + f.get(obj) + "\"" : f.get(obj).toString();
            pairs.add("\"" + f.getName() + "\":" + value);
        }
        return "{" + String.join(",", pairs) + "}";
    }

    // Task 11
    public static <T> T fromCsv(String row, Class<T> clazz) throws Exception {
        String[] values = row.split(",");
        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (int i = 0; i < Math.min(values.length, fields.length); i++) {
            fields[i].setAccessible(true);
            if (fields[i].getType() == int.class) {
                fields[i].set(obj, Integer.parseInt(values[i]));
            } else {
                fields[i].set(obj, values[i]);
            }
        }
        return obj;
    }
}
