package com.oocl.cultivation;

import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingTicket addCar(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        cars.put(ticket, car);
        return ticket;
    }

    public Car findCar(ParkingTicket ticket) {
        return cars.remove(ticket);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    // 相减这里是故意写反的吗
    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }
}
