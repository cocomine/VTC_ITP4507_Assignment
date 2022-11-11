package com.building;

import java.util.Scanner;

public class Apartment extends Building{
    private double monthlyRental;
    private String supportStaff;

    /**
     * Apartment
     * @param id Building No.
     * @param noOfRooms Number of rooms
     * @param monthlyRental Monthly Rental
     * @param supportStaff Support Staff
     */
    public Apartment(int id, int noOfRooms, double monthlyRental, String supportStaff){
        super(id, noOfRooms);
        this.monthlyRental = monthlyRental;
        this.supportStaff = supportStaff;
    }

    /**
     * Set Monthly Rental
     * @param monthlyRental Monthly Rental
     */
    public void setMonthlyRental(double monthlyRental){
        this.monthlyRental = monthlyRental;
    }

    /**
     * Get Monthly Rental
     * @return Monthly Rental
     */
    public double getMonthlyRental(){
        return monthlyRental;
    }

    /**
     * Get Support Staff
     * @return Support Staff
     */
    public String getSupportStaff(){
        return supportStaff;
    }

    /**
     * Set Support Staff
     * @param supportStaff Support Staff
     */
    public void setSupportStaff(String supportStaff){
        this.supportStaff = supportStaff;
    }

    @Override
    public void modifyBuilding(Scanner sc){
        System.out.println(this);
        System.out.print("Modify Monthly Rental: ");
        monthlyRental = sc.nextDouble();
        System.out.print("Modify Support Staff: ");
        sc.nextLine();
        supportStaff = sc.nextLine();

        System.out.println("Building is modified:");
        System.out.println(this);
    }

    @Override
    public void printBuilding(){
        System.out.println("Building No: " + getId());
        System.out.println("Support Staff: " + supportStaff);
        System.out.println("Monthly Rental: " + monthlyRental);
        printRooms();
    }

    @Override
    public String toString(){
        return "Building No.: " + getId() + ", Support Staff: " + supportStaff + ", Monthly Rental: " + monthlyRental;
    }
}
