package com.command;

import com.building.Building;
import com.building.Room;
import com.factory.RoomFactory;
import com.memento.Memento;
import com.memento.RoomMemento;

import java.util.Scanner;
import java.util.Stack;

public class addRoomCmd implements Command{
    private Building building;
    private Room room;
    private int index;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Scanner sc;
    private RoomMemento memento;

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
        room = RoomFactory.createRoom(sc);
        building.addRoom(room);
        index = building.getRooms().indexOf(room);
        memento = new RoomMemento(room);

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
        return "Add Room: Building No. " + building.getId() + ", Room No. " + (index + 1) + ", " + memento;
    }
}
