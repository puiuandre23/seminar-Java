package seminar5;

import java.util.Objects;

public class Student implements Comparable<Student>{
    String nume;
    int grade;

    public Student(String nume, int grade) {
        this.nume = nume;
        this.grade = grade;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", grade=" + grade +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.grade, o.grade);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(nume, student.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, grade);
    }
}
