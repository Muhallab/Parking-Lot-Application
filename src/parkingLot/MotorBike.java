/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;

import java.time.LocalDateTime;

/**
 *
 * @author almuh
 */
public class MotorBike extends Vehicle {
    MotorBikeSpot tempSpot = new MotorBikeSpot();
    public MotorBike(String licensePlate, String floorNumber) {
    super(VehicleType.MOTORBIKE, licensePlate);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));

  }
    public MotorBike(String licensePlate, long ticketNumber, LocalDateTime date, String floorNumber) {
    super(VehicleType.MOTORBIKE, licensePlate, ticketNumber,date);
    this.assignSpot(tempSpot.getFreeParkingSpot(floorNumber));

  }
    
}
