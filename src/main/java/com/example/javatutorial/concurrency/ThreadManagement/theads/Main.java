package com.example.javatutorial.concurrency.ThreadManagement.theads;

public class Main {
    public static void main(String args[]){
        BookingService bookingService = new BookingService();
        System.out.println("Seat available: " + bookingService.seats.get("seat1").isAvailable());

        boolean booking =  bookingService.booking("seat1", "visitor123");
        boolean booking2 =  bookingService.booking("seat1", "visitor122");

        System.out.println("Booking 1 status: " + booking);
        System.out.println("Booking 2 status: " + booking2);

    }
}

