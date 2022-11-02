package com.memento;

import com.building.Apartment;

public class ApartmentMemento implements BuildingMemento{
    private Apartment apartment;
    private double monthlyRental;
    private String supportStaff;

    /**
     * Apartment Memento
     * @param apartment Apartment
     */
    public ApartmentMemento(Apartment apartment){
        this.apartment = apartment;
        monthlyRental = apartment.getMonthlyRental();
        supportStaff = apartment.getSupportStaff();
    }

    public Apartment getOrig(){
        return apartment;
    }

    public void restore(){
        apartment.setMonthlyRental(monthlyRental);
        apartment.setSupportStaff(supportStaff);
    }

    @Override
    public String toString(){
        return "Building No.: " + apartment.getId() + ", Support Staff: " + supportStaff + ", Monthly Rental: " + monthlyRental;
    }
}
