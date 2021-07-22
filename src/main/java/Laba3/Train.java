package Laba3;

import java.time.LocalTime;
import java.util.Hashtable;

public class Train {
    private String destination;
    private String id;
    private LocalTime time;
    private Hashtable<Seat.SeatType, Integer> seats = new Hashtable<>();

    public Train(String destination, String id, LocalTime time,
                 Seat... seats){
        this.destination = destination;
        this.id = id;
        this.time = time;
        for (Seat place: seats){
            this.seats.put(place.type, place.amount);
        }
    }


    public Train(){
        this.destination = "";
        this.id = "";
        this.time = LocalTime.now();
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String value){
        this.destination = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value){
        this.id = value;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime value){
        this.time = value;
    }

    public Hashtable<Seat.SeatType, Integer> getSeats() {
        return seats;
    }

    public void setSeats(Hashtable<Seat.SeatType, Integer> newSeats){
        this.seats = newSeats;
    }
    public void setSeat(Seat.SeatType seatType, int amount){
        if(amount >= 0){
            seats.replace(seatType, amount);
        }
        else{
            System.out.println("Amount is negative! " + amount);
        }
    }
    public void addSeats(Seat.SeatType seatType, int amount){
        if (amount < 0){
            System.out.println("Amount is negative!" + amount);
        }
        else{
            if (seats.containsKey(seatType)){
                int was = seats.get(seatType);
                int become = was + amount;
                seats.replace(seatType, become);
            }

            seats.put(seatType, amount);
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(
                "Train " + id + " is going to " + destination + " at " + time + "\n"
                + "Have seats:\n"
        );

        for (Seat.SeatType key: seats.keySet()){
            s.append(Seat.SeatType.getString(key) + ": " + seats.get(key) + "\n");
        }

        return s.toString();
    }

    public boolean hasSeat(Seat.SeatType seatType){
        return !this.seats.containsKey(seatType) || this.seats.get(seatType) == 0;
    }
}
