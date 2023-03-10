package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Helicopter {
    private int id = 100;
    private String model;
    private double currentAltitude;
    private double maxAltitude;
    private double fuelCapacity;
    private double currentFuel;
    private static Helicopter instance;

    public static Helicopter getInstance() {
        if (instance == null) {
            instance = new Helicopter();
        }
        return instance;
    }
    public void takeOff(){ currentAltitude += 100; }
    public void ascend(int altitude){ currentAltitude += altitude; }
    public void descend(int altitude){
        currentAltitude -= altitude;
        if (currentAltitude < 0) { currentAltitude = 0; }
    }
    public void refuel(int fuel){
        currentFuel += fuel;
        if (currentFuel > fuelCapacity){
            currentFuel = fuelCapacity;
            System.out.println("tank is full");
        }
    }

    public static void main(String[] args){
        Helicopter[] helicopters = new Helicopter[4];

        helicopters[0] = new Helicopter();
        helicopters[1] = new Helicopter(123, "AH-156", 3400.0, 7000.0, 150.0, 79.0);
        helicopters[2] = getInstance();
        helicopters[3] = getInstance();

        for(int i = 0; i < helicopters.length; i++){
            System.out.println(helicopters[i]);
        }
    }
}
