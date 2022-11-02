package com.command;

import com.building.Building;
import com.factory.BuildingMementoFactory;
import com.memento.BuildingMemento;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class modifyBuildingCmd implements Command{
    private HashMap<Integer, Building> buildings;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Scanner sc;
    private BuildingMemento memento;
    private BuildingMemento currently;

    /**
     * Modify Building Command
     * @param buildings Building list
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     */
    public modifyBuildingCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        //get building
        System.out.print("Enter Building No.: ");
        int id = sc.nextInt();
        Building building = buildings.get(id);
        if(building == null) return; //if not match

        //modify
        memento = BuildingMementoFactory.createBuildingMemento(building);
        building.modifyBuilding(sc);
        currently = BuildingMementoFactory.createBuildingMemento(building);

        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        Building tmp = memento.getOrig();
        BuildingMemento amemento = BuildingMementoFactory.createBuildingMemento(tmp);
        memento.restore();
        memento = amemento;
    }

    @Override
    public void redo(){
        Building tmp = memento.getOrig();
        BuildingMemento amemento = BuildingMementoFactory.createBuildingMemento(tmp);
        memento.restore();
        memento = amemento;
    }

    @Override
    public String toString(){
        return "Modify Building: " + currently;
    }
}
