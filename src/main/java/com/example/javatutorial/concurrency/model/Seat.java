package com.example.javatutorial.concurrency.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Seat {
    String OccupiedBy;
    boolean isAvailable = true;

    public boolean isAvailable() {
        return OccupiedBy == null;
    }
}
