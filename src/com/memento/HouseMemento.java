package com.memento;

import com.building.Building;
import com.building.House;

public class HouseMemento implements BuildingMemento{
    private House house;
    private int noOfFloors;

    public HouseMemento(House house){
        this.house = house;
        noOfFloors = house.getNoOfFloors();
    }

    @Override
    public void restore(){
        house.setNoOfFloors(noOfFloors);
    }

    public Building getOrig(){
        return house;
    }

    @Override
    public String toString(){
        return "Building No.: " + house.getId() + ", No. of Floor: " + noOfFloors;
    }
}
