package com.example.javatutorial.javacore.inheritance;

public class Dog extends Animal{
    static void Test(){
        System.out.println("Dog");
    }

    @Override
    void sound() {
       System.out.println("Dog");
    }
}
