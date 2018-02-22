package pset0;

import com.sun.istack.internal.NotNull;

public class Student {

    private int id;
    private String name;
    private int age;
    private int gender;// 1 female 2 male
    private String city;
    private int marks;

    public Student( ) {

    }

    public Student(int id, String name, int age, int gender, String city, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return id+" - "+name+"-"+gender+" - "+age+" - "+city;

    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}