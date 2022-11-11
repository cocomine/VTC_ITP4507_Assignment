package com.command;

import com.building.Apartment;
import com.building.House;
import com.memento.BuildingCaretaker;

import java.util.Scanner;
import java.util.Stack;

public class modifyHouseCmd implements Command{
    private House house;
    private Stack<Command> undoList;
    private Stack<Command> redoList;
    private Scanner sc;
    private BuildingCaretaker buildingCaretaker;
    private int noOfFloors;

    /**
     * Modify House Command
     * @param house House
     * @param undoList undo command list
     * @param redoList redo command list
     * @param sc Scanner
     * @param buildingCaretaker Building Caretaker
     */
    public modifyHouseCmd(House house, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, BuildingCaretaker buildingCaretaker){
        this.house = house;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
        this.buildingCaretaker = buildingCaretaker;
    }

    @Override
    public void execute(){
        buildingCaretaker.saveClass(house);
        house.modifyBuilding(sc);

        noOfFloors = house.getNoOfFloors();

        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        buildingCaretaker.undo();
    }

    @Override
    public void redo(){
        buildingCaretaker.redo();
    }
}
