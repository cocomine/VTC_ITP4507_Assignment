package com.command;

import com.building.Building;
import com.building.Room;
import com.memento.RoomCaretaker;

import java.util.Scanner;
import java.util.Stack;

public class modifyRoomCmd implements Command{
    private final Building building;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private final RoomCaretaker roomCaretaker;
    private int index;
    private double length, width;

    /**
     * Modify Room Command
     * @param building Building
     * @param undoList undo command list
     * @param redoList redo command list
     * @param sc Scanner
     * @param roomCaretaker Room Caretaker
     */
    public modifyRoomCmd(Building building, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, RoomCaretaker roomCaretaker){
        this.building = building;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
        this.roomCaretaker = roomCaretaker;
    }

    @Override
    public void execute(){
        System.out.println("Room No.:");
        index = sc.nextInt() - 1;
        Room room = building.getRooms().get(index);
        if(room == null) return;//if not match

        //modify
        roomCaretaker.saveClass(room);
        System.out.print("Length: ");
        length = sc.nextDouble();
        System.out.print("Width: ");
        width = sc.nextDouble();
        building.modifyRoom(index, length, width);

        System.out.println("Updated Building:");
        building.printBuilding();
        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        roomCaretaker.undo();
    }

    @Override
    public void redo(){
        roomCaretaker.redo();
    }

    @Override
    public String toString(){
        return "Modify Room: Building No. " + building.getId() + ", Room No. " + (index + 1) + "Length: "+length+", Width: "+width;
    }
}
