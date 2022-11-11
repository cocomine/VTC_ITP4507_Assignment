package com.memento;

import com.building.Room;

public class RoomMemento implements Memento{
    private final double length;
    private final double width;
    private final Room room;

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
}
