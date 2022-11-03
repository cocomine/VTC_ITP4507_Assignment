package com.factory;

import com.building.Room;

public class RoomFactory{

    /**
     * create Room
     * @param length Length
     * @param width Width
     * @return Room
     */
    public static Room createRoom(double length, double width){
        return new Room(length, width);
    }
}
