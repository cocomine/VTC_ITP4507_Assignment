package com.command;

import com.building.Building;
import com.factory.CommandFactory;
import com.memento.RoomCaretaker;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class editRoomCmd implements Command{
    private final HashMap<Integer, Building> buildings;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private final RoomCaretaker roomCaretaker;


    public editRoomCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, RoomCaretaker roomCaretaker){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
        this.roomCaretaker = roomCaretaker;
    }

    @Override
    public void execute(){
        System.out.print("Building No.: ");
        int id = sc.nextInt();
        Building building = buildings.get(id);
        if(building == null) return; //if not match

        building.printBuilding();
        System.out.println();
        System.out.println("Please enter command: [a|d|m]");
        System.out.println("a = add room, d = delete room, m = modify room");
        Command cmd = CommandFactory.createRoomCmd(building, undoList, redoList, sc, roomCaretaker);
        if(cmd != null) cmd.execute();
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
