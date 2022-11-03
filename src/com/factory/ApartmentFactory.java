package com.factory;

import com.building.Apartment;
import com.building.Building;

import java.util.HashMap;
import java.util.Scanner;

public class ApartmentFactory{
    /**
     * Create Apartment
     * @param sc Scanner
     * @return Apartment
     */
    public static Apartment createApartment(HashMap<Integer, Building> buildings, Scanner sc){
        int id;
        do{
            System.out.print("Building No.: ");
            id = sc.nextInt();
        } while(buildings.containsKey(id));
        System.out.print("Monthly Rental: ");
        double monthlyRental = sc.nextDouble();
        System.out.print("Support Staff: ");
        sc.nextLine();
        String supportStaff = sc.nextLine();
        System.out.print("Number of rooms: ");
        int noOfRooms = sc.nextInt();
        Apartment apartment = new Apartment(id, noOfRooms, monthlyRental, supportStaff);

        // Create Room
        for(int i = 0 ; i < noOfRooms ; i++){
            System.out.println("Room No. "+(i+1)+" :");
            System.out.print("Length: ");
            double length = sc.nextDouble();
            System.out.print("Width: ");
            double width = sc.nextDouble();
            apartment.addRoom(length, width);
        }
        return apartment;
    }
}
