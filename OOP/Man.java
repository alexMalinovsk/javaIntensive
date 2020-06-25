package OOP;

import java.util.Scanner;

public class Man {
    private int mass;
    private int age;
    private String name;
    private String gender;

    public Man(String name, int age,String gender,int mass)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.mass=mass;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
