package Laba3;

import java.awt.*;

public class Seat {
    SeatType type;
    Integer amount;

    public enum SeatType {
        Luxury("Luxury"),
        CommonSeat("Common seat"),
        Coupe("Coupe"),
        ReservedSeat("Reserved seat");
        private String stringFormat;
        SeatType(String stringFormat){
            this.stringFormat = stringFormat;
        }


        public static String getString(SeatType placetype){
            return placetype.stringFormat;
        }
    };

    public Seat(SeatType type, Integer amount){
        this.type = type;
        this.amount = amount;
    }
}


