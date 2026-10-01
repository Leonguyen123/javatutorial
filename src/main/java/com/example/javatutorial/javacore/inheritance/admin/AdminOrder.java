package com.example.javatutorial.javacore.inheritance.admin;

import com.example.javatutorial.javacore.inheritance.order.Order;

public class AdminOrder extends Order {

    public AdminOrder(double totalAmount) {
        super(totalAmount);
    }

    public void showMyAmount() {
        // Tại sao totalAmount vẫn có thể được gọi trong khi nằm khác package.
        // AdminOrder được thừa hưởng totalAmount từ class cha.
        System.out.println(totalAmount);

        Order order = new Order(10.0);

        // Lỗi ?
        // System.out.println(order.totalAmount);
    }
}
