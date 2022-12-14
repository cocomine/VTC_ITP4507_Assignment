package com.factory;

import com.building.Building;
import com.building.House;

import java.util.HashMap;
import java.util.Scanner;

public class HouseFactory{
    /**
     * Create House
     * @param sc Scanner
     * @return House
     */
    public static House createHouse(HashMap<Integer, Building> buildings, Scanner sc){
        int id;
        do{
            System.out.print("Building No.: ");
            id = sc.nextInt();
        } while(buildings.containsKey(id));
        System.out.print("No. of Floors: ");
        int noOfFloors = sc.nextInt();
        System.out.print("Number of rooms: ");
        int noOfRooms = sc.nextInt();
        House house = new House(id, noOfRooms, noOfFloors);

        // Create Room
        for(int i = 0 ; i < noOfRooms ; i++){
            System.out.println("Room No. "+(i+1)+" :");
            System.out.print("Length: ");
            double length = sc.nextDouble();
            System.out.print("Width: ");
            double width = sc.nextDouble();
            house.addRoom(length, width);
        }
        return house;
    }
}
