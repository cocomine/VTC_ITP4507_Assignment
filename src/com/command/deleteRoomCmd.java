package com.command;

import com.building.Building;
import com.building.Room;
import com.memento.RoomMemento;

import java.util.Scanner;
import java.util.Stack;

public class deleteRoomCmd implements Command{
    private Building building;
    private Room room;
    private int index;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Scanner sc;
    private RoomMemento memento;

    /**
     * Delete Room Command
     *
     * @param building Building
     * @param undoList Undo List
     * @param redoList Redo List
     * @param sc       Scanner
     */
    public deleteRoomCmd(Building building, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.building = building;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        System.out.println("Room No.:");
        index = sc.nextInt() - 1;
        if(index < building.getRoomQty() && index >= 0){
            room = building.getRooms().remove(index); //remove
            memento = new RoomMemento(room);

            System.out.println("Updated Building:");
            building.printBuilding();
            redoList.clear();
            undoList.push(this);
        }else{
            System.out.println("index is out of range.");
        }
    }

    @Override
    public void undo(){
        if(room != null){
            building.getRooms().add(index, room);
        }
    }

    @Override
    public void redo(){
        if(room != null) building.deleteRooms(index);
    }

    @Override
    public String toString(){
        return "Delete Room: Building No. " + building.getId() + ", Room No. " + (index + 1) + ", " + memento;
    }
}