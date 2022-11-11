package com.command.building;

import com.building.Apartment;
import com.building.Building;
import com.building.House;
import com.command.Command;
import com.memento.BuildingCaretaker;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class modifyBuildingCmd implements Command{
    private final HashMap<Integer, Building> buildings;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private final BuildingCaretaker buildingCaretaker;

    /**
     * Modify Building Command
     * @param buildings building save list
     * @param undoList undo command list
     * @param redoList redo command list
     * @param sc Scanner
     * @param buildingCaretaker Building Caretaker
     */
    public modifyBuildingCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, BuildingCaretaker buildingCaretaker){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
        this.buildingCaretaker = buildingCaretaker;
    }

    @Override
    public void execute(){
        //get building
        System.out.print("Enter Building No.: ");
        int id = sc.nextInt();
        Building building = buildings.get(id);
        if(building == null) return; //if not match

        //modify
        Command cmd;
        if(building.getClass().equals(Apartment.class)){
            cmd = new modifyApartmentCmd((Apartment) building, undoList, redoList, sc, buildingCaretaker);
        }else {
            cmd = new modifyHouseCmd((House) building, undoList, redoList, sc, buildingCaretaker);
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
