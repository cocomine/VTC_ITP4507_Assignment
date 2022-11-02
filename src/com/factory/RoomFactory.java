package com.factory;

import com.building.Room;

import java.util.Scanner;

public class RoomFactory{
    /**
     * Create Room
     * @param sc Scanner
     * @return Room
     */
    public static Room createRoom (Scanner sc){
        System.out.print("Length: ");
        double length = sc.nextDouble();
        System.out.print("Width: ");
        double width = sc.nextDouble();

        return new Room(length, width);
    }
}
