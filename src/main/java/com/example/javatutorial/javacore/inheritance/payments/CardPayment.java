package com.example.javatutorial.javacore.inheritance.payments;

import java.math.BigDecimal;

public class CardPayment extends Payment implements Refunable{
    public CardPayment(Long paymentId, BigDecimal amount) {
        super(paymentId, amount);
    }

    @Override
    public void process() {
        System.out.println("Card payment method");
    }

    @Override
    public void refund() {
        System.out.println("How to refund");
    }
}
