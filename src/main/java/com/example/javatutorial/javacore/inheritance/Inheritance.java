package com.example.javatutorial.javacore.inheritance;

public class Inheritance {
    public static void main(String[] args){
        System.out.println("test Inheritance");

        // Thay chỗ, Dog có thể đại diện cho Animal
        Animal animal1 = new Animal();
        animal1 = new Dog();

        // Dymanic Binding.
        Animal animal = new Dog();

        // Polymorphism - tính đa hình
        animal.sound();

        // Casting
        Employee staff = new Manager();
        staff.work();
        // staff.manage(); // Lỗi tham chiếu biến.complie !

        Manager manager = (Manager) staff;
    }
}
