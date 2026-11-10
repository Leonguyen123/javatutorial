package com.example.javatutorial.concurrency.ThreadManagement.theads;
import com.example.javatutorial.concurrency.model.Seat;

import java.util.HashMap;
import java.util.Map;

public class BookingService {
    Map<String, Seat> seats = new HashMap<>();

    public BookingService() {
        seats.put("seat1", new Seat());
        seats.put("seat2", new Seat());
        seats.put("seat3", new Seat());
    }

    public Boolean booking(String seatId, String visitorId){
        Seat seat = seats.get(seatId);
        if (seat.isAvailable()){
            seat.setOccupiedBy(visitorId);
            return true;
        }
        return false;
    }
}
