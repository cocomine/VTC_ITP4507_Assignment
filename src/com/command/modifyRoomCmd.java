package com.command;

import com.building.Building;
import com.building.Room;
import com.memento.RoomMemento;

import java.util.Scanner;
import java.util.Stack;

public class modifyRoomCmd implements Command{
    private final Building building;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private int index;
    private RoomMemento memento;
    private RoomMemento currently;

    public modifyRoomCmd(Building building, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.building = building;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        System.out.println("Room No.:");
        index = sc.nextInt() - 1;
        Room room = building.getRooms().get(index);
        if(room == null) return;//if not match

        //modify
        memento = new RoomMemento(room);
        System.out.print("Length: ");
        double length = sc.nextDouble();
        System.out.print("Width: ");
        double width = sc.nextDouble();
        building.modifyRoom(index, length, width);
        currently = new RoomMemento(room);

        System.out.println("Updated Building:");
        building.printBuilding();
        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        Room tmp = memento.getOrig();
        RoomMemento amemento = new RoomMemento(tmp);
        memento.restore();
        memento = amemento;
    }

    @Override
    public void redo(){
        Room tmp = memento.getOrig();
        RoomMemento amemento = new RoomMemento(tmp);
        memento.restore();
        memento = amemento;
    }

    @Override
    public String toString(){
        return "Modify Room: Building No. " + building.getId() + ", Room No. " + (index + 1) + ", " + currently;
    }
}
