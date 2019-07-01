package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (parkingLot.getAvailableParkingPosition() <= 0) {
            return (ParkingTicket) handleError("Not enough position.");
        }
        return getParkingTicket(car);
    }

    private Object handleError(String errorMessage) {
        lastErrorMessage = errorMessage;
        return null;
    }

    private ParkingTicket getParkingTicket(Car car) {
        ParkingTicket ticket = parkingLot.addCar(car);
        if (ticket != null) {
            clearLastErrorMessage();
        }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket == null) {
            return (Car) handleError("Please provide your parking ticket.");
        }
        return getCar(ticket);
    }

    private Car getCar(ParkingTicket ticket) {
        Car car = parkingLot.findCar(ticket);
        if (car == null) {
            lastErrorMessage = "Unrecognized parking ticket.";
        } else {
            clearLastErrorMessage();
        }
        return car;
    }

    private void clearLastErrorMessage() {
        lastErrorMessage = null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
