package Laba3;

import java.time.LocalTime;
import java.util.Iterator;

public class TrainArray {
    private Train[] trains;
    private int size;

    public TrainArray(){
        size++;
        trains = new Train[0];
    }

    public TrainArray(Train... trains){
        this.trains = trains.clone();
        this.size = trains.length;
    }

    public int getSize() {
        return size;
    }

    public void showTrains(){
        for (Train train: trains){
            System.out.println("--------------------------------");
            System.out.print(train.toString());
            System.out.println("--------------------------------");
        }
    }

    public void showWithDestination(String destination){
        destination = destination.strip();
        StringBuilder answer = new StringBuilder();
        for (Train train: trains){
            if (train.getDestination().equals(destination)){
                answer.append("--------------------------------\n");
                answer.append(train.toString());
                answer.append("--------------------------------\n");
            }
        }
        System.out.println("List of trains with destination " + destination);
        System.out.println(answer.toString());
    }

    public TrainArray getWithDestination(String destination){
        destination = destination.strip();
        TrainArray trainArray = new TrainArray();
        for (Train train: trains){
            if (train.getDestination().equals(destination)){
                trainArray.addTrain(train);
            }
        }
        return trainArray;
    }

    public void showWithDestinationAndTime(String destination, LocalTime after){
        TrainArray trainArray = this.getWithDestination(destination);
        for (Train train: trainArray.trains){
            if (train.getTime().isBefore(after)){
                trainArray.deleteTrain(train);
            }
        }
        System.out.println("Trains with destination " + destination + " which are leaving after " + after);
        trainArray.showTrains();
    }

    public void showWithDestinationAndCommonSeats(String destination){
        TrainArray trainArray = this.getWithDestination(destination);
        for (Train train: trainArray.trains){
            if (train.hasSeat(Seat.SeatType.CommonSeat)){
                trainArray.deleteTrain(train);
            }
        }

        if (trainArray.getSize() == 0){
            System.out.println("There is no such trains");
        }
        else{
            System.out.println("Trains with destination " + destination + " with common seats");
            trainArray.showTrains();
        }
    }

    public void addTrain(Train train){
        Train[] newTrains = new Train[trains.length + 1];
        System.arraycopy(trains, 0, newTrains, 0, trains.length);
        newTrains[newTrains.length - 1] = train;
        trains = newTrains;
        size++;
    }

    public void deleteTrain(Train train){
        Train[] newTrains = new Train[trains.length - 1];
        for (int i = 0, k = 0; i < trains.length; i++, k++){
            if(trains[i] == train){
                k--;
                continue;
            }
            newTrains[k] = trains[i];
        }
        trains = newTrains;
        size--;
    }
}
