package com.example.javatutorial.javacore.inheritance;

public class Bird extends Animal implements Flyable{

    @Override
    void sound() {
        System.out.println("Bird");
    }

    @Override
    public void fly() {
        System.out.println("Quick");
    }
}
