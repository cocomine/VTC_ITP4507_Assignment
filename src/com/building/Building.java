package com.building;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Building{
    private int id;
    private ArrayList<Room> rooms;

    /**
     * Building
     * @param id Building No.
     * @param noOfRooms Number of rooms
     */
    public Building(int id, int noOfRooms){
        this.id = id;
        this.rooms = new ArrayList<>(noOfRooms);
    }

    /**
     * Get Building No.
     * @return Building No.
     */
    public int getId(){
        return id;
    }

    /**
     * Get room list
     * @return room list
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }

    /**
     * Add room
     * @param room Room
     */
    public void addRoom(Room room){
        rooms.add(room);
    }

    /**
     * Modify Room
     * @param roomNo Room No.
     * @param length Length
     * @param width Width
     */
    public void modifyRoom(int roomNo, double length, double width){
        Room room = rooms.get(roomNo);
        room.setLength(length);
        room.setWidth(width);
    }

    public void printRooms(){
        for(int i = 0 ; i < rooms.size() ; i++){
            System.out.println("Room No.: " + (i + 1) + ", " + rooms.get(i));
        }
    }

    /**
     * Delete Room
     * @param roomNo Room No.
     */
    public void deleteRooms(int roomNo){
        rooms.remove(roomNo);
    }

    /**
     * Get Qty of Rooms
     * @return Qty of Rooms
     */
    public int getRoomQty(){
        return rooms.size();
    }

    /**
     * Modify Building
     */
    public abstract void modifyBuilding(Scanner sc);

    /**
     * Print Building
     */
    public abstract void printBuilding();
}
