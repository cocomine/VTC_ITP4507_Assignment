package com.command;

import com.building.Apartment;
import com.memento.BuildingCaretaker;

import java.util.Scanner;
import java.util.Stack;

public class modifyApartmentCmd implements Command{

    private final Apartment apartment;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private final BuildingCaretaker buildingCaretaker;
    private double monthlyRental;
    private String supportStaff;

    /**
     * Modify apartment Command
     * @param apartment Apartment
     * @param undoList undo command list
     * @param redoList redo command list
     * @param sc Scanner
     * @param buildingCaretaker Building Caretaker
     */
    public modifyApartmentCmd(Apartment apartment, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, BuildingCaretaker buildingCaretaker){
        this.apartment = apartment;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
        this.buildingCaretaker = buildingCaretaker;
    }

    @Override
    public void execute(){
        buildingCaretaker.saveClass(apartment);
        apartment.modifyBuilding(sc);

        monthlyRental = apartment.getMonthlyRental();
        supportStaff = apartment.getSupportStaff();

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

    public String toString(){
        return "Modify Building: Building No. "+apartment.getId()+", Support Staff: "+supportStaff+", Support Staff: "+monthlyRental;
    }
}
