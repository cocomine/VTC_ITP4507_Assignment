package com.command;

import com.building.Apartment;
import com.building.Building;
import com.factory.ApartmentFactory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class addApartmentCmd implements Command{
    private final HashMap<Integer, Building> buildings;
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;
    private final Scanner sc;
    private Apartment apartment;
    private double monthlyRental;
    private String supportStaff;

    /**
     * Add Apartment Command
     * @param buildings Building list
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     */
    public addApartmentCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        this.buildings = buildings;
        this.undoList = undoList;
        this.redoList = redoList;
        this.sc = sc;
    }

    @Override
    public void execute(){
        apartment = ApartmentFactory.createApartment(buildings, sc);

        System.out.println("New Building Added:");
        apartment.printBuilding();
        supportStaff = apartment.getSupportStaff();
        monthlyRental = apartment.getMonthlyRental();

        buildings.put(apartment.getId(), apartment);
        undoList.push(this);
        redoList.clear();
    }

    @Override
    public void undo(){
        if(apartment != null) buildings.remove(apartment.getId());
    }

    @Override
    public void redo(){
        if(apartment != null) buildings.put(apartment.getId(), apartment);
    }

    public String toString(){
        return "Add Building: Building No.: "+apartment.getId()+", Support Staff: "+supportStaff+", Monthly Rental: "+monthlyRental;
    }
}
