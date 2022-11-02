package com.command;

import com.building.Building;
import com.factory.ApartmentFactory;
import com.factory.HouseFactory;
import com.factory.BuildingMementoFactory;
import com.memento.Memento;

import java.util.*;

public class addBuildingCmd implements Command{

    private HashMap<Integer, Building> buildings;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Building building;
    private Scanner sc;
    private Memento now;

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
        while(true){
            if(type.equals("a")){
                building = ApartmentFactory.createApartment(buildings, sc);
                break;
            }
            if(type.equals("h")){
                building = HouseFactory.createHouse(buildings, sc);
                break;
            }
        }

        System.out.println("New Building Added:");
        building.printBuilding();
        buildings.put(building.getId(), building);

        now = BuildingMementoFactory.createBuildingMemento(building);
        redoList.clear();
        undoList.push(this);
    }

    @Override
    public void undo(){
        if(building != null) buildings.remove(building.getId());
    }

    @Override
    public void redo(){
        if(building != null) buildings.put(building.getId(), building);;
    }

    @Override
    public String toString(){
        return "Add Building: "+now;
    }
}
