package com.building;

import java.util.Scanner;

public class House extends Building{
    private int noOfFloors;

    /**
     * House
     * @param id Building No.
     * @param noOfRooms Number of rooms
     * @param noOfFloors No of Floors
     */
    public House(int id, int noOfRooms, int noOfFloors){
        super(id, noOfRooms);
        this.noOfFloors = noOfFloors;
    }

    /**
     * Get No of Floors
     * @return No of Floors
     */
    public int getNoOfFloors(){
        return noOfFloors;
    }

    /**
     * Set No of Floors
     * @param noOfFloors No of Floors
     */
    public void setNoOfFloors(int noOfFloors){
        this.noOfFloors = noOfFloors;
    }

    @Override
    public void modifyBuilding(Scanner sc){
        System.out.println(this);
        System.out.print("No. of Floors: ");
        noOfFloors = sc.nextInt();

        System.out.println("Building is modified:");
        System.out.println(this);
    }

    @Override
    public void printBuilding(){
        System.out.println("Building No: " + getId());
        System.out.println("No of Floors: " + noOfFloors);
        printRooms();
    }

    @Override
    public String toString(){
        return "Building No.: " + getId() + ", No. of Floor: " + noOfFloors;
    }
}
