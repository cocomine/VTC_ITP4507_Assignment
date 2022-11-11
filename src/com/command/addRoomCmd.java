package com.command;

import com.building.Building;
import com.building.Room;
import com.memento.RoomMemento;

import java.util.Scanner;
import java.util.Stack;

public class addRoomCmd implements Command{
    private final Building building;
    private Room room;
    private int index;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private double length, width;

    /**
     * Add Room Command
     *
     * @param building Building
     * @param undoList Undo List
     * @param redoList Redo List
     * @param sc       Scanner
     */
    public addRoomCmd(Building building, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.building = building;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        //create
        System.out.print("Length: ");
        length = sc.nextDouble();
        System.out.print("Width: ");
        width = sc.nextDouble();
        room = building.addRoom(length, width);
        index = building.getRooms().indexOf(room);

        //print
        System.out.println("Updated Building:");
        building.printBuilding();
        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        if(room != null) building.deleteRooms(index);
    }

    @Override
    public void redo(){
        if(room != null){
            building.getRooms().add(index, room);
        }
    }

    @Override
    public String toString(){
        return "Add Room: Building No. " + building.getId() + ", Room No. " + (index + 1) + ", Length: "+length+", Width: "+width;
    }
}
