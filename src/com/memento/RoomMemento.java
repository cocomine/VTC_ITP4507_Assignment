package com.memento;

import com.building.Building;
import com.building.Room;

public class RoomMemento implements Memento{
    private double length;
    private double width;
    private Room room;

    public RoomMemento(Room room){
        length = room.getLength();
        width = room.getWidth();
        this.room = room;
    }

    @Override
    public void restore(){
        room.setLength(length);
        room.setWidth(width);
    }

    public Room getOrig(){
        return room;
    }

    @Override
    public String toString(){
        return "Length: "+length+", Width: "+width;
    }
}
