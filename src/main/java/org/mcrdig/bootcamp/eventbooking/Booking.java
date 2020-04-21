package org.mcrdig.bootcamp.eventbooking;

public class Booking {

    private int userId;
    private int eventId;

    public Booking(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId=" + userId +
                ", eventId=" + eventId +
                '}';
    }
}
