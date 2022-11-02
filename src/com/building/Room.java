package com.building;

public class Room{
    private double length;
    private double width;

    /**
     * Room
     * @param length Length
     * @param width Width
     */
    public Room(double length, double width){
        this.length = length;
        this.width = width;
    }

    /**
     * Get Length
     * @return Length
     */
    public double getLength(){
        return length;
    }

    /**
     * Set Length
     * @param length Length
     */
    public void setLength(double length){
        this.length = length;
    }

    /**
     * Get Width
     * @return Width
     */
    public double getWidth(){
        return width;
    }

    /**
     * Set Width
     * @param width Width
     */
    public void setWidth(double width){
        this.width = width;
    }

    @Override
    public String toString(){
        return "Length: "+length+", Width: "+width;
    }
}
