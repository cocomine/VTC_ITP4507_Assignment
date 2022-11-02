package com.command;

import com.building.Building;
import com.factory.CommandFactory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class editRoomCmd implements Command{
    private HashMap<Integer, Building> buildings;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Scanner sc;


    public editRoomCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
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
        Command cmd = CommandFactory.createRoomCmd(building, undoList, redoList, sc);
        if(cmd != null) cmd.execute();
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
