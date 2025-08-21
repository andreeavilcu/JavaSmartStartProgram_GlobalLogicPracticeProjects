package org.example;


public class Person {
    private String name;
    private int age;


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

    private void sayHello(){
        System.out.println("Hello, my name is " + getName());
    }
}
