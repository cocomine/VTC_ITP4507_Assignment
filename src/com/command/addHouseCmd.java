package com.command;

import com.building.Building;
import com.building.House;
import com.factory.HouseFactory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class addHouseCmd implements Command{
    private final HashMap<Integer, Building> buildings;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private House house;
    private int noOfFloors;

    /**
     * Add House Command
     * @param buildings Building list
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     */
    public addHouseCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        house = HouseFactory.createHouse(buildings, sc);

        System.out.println("New Building Added:");
        house.printBuilding();
        noOfFloors = house.getNoOfFloors();

        buildings.put(house.getId(), house);
        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        if(house != null) buildings.remove(house.getId());
    }

    @Override
    public void redo(){
        if(house != null) buildings.put(house.getId(), house);
    }

    public String toString(){
        return "Add Building: Building No.: "+house.getId()+", No. of Floor: "+noOfFloors;
    }
}
