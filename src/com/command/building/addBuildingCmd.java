package com.command.building;

import com.building.Building;
import com.command.Command;

import java.util.*;

public class addBuildingCmd implements Command{

    private final HashMap<Integer, Building> buildings;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;

    /**
     * Add Building Command
     * @param buildings Building list
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     */
    public addBuildingCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        System.out.println("Enter Building Type (a=Apartment/h=House):");
        String type = sc.next();
        Command cmd;
        while(true){
            if(type.equals("a")){
                cmd = new addApartmentCmd(buildings, undoList, redoList, sc);
                break;
            }
            if(type.equals("h")){
                cmd = new addHouseCmd(buildings, undoList, redoList, sc);
                break;
            }
        }
        cmd.execute();
    }

    @Override
    public void undo(){
    }

    @Override
    public void redo(){
    }
}
