package com.ontariotechu.sofe3980U;

import java.util.Objects;

public class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = validateName(name);
        this.age = validateAge(age);
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name;
    }

    private int validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = validateAge(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return age == passenger.age && Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/* justin
package com.ontariotechu.sofe3980U;

public class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void setName(String name){
	    this.name=name;
    }
    public String getName(){
	    return this.name;
    }
    public void setAge(int age){
	    this.age=age;
    }
    public int getAge(){
	    return this.age;
    }
}

 */