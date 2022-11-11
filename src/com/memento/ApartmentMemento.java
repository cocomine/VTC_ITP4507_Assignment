package com.memento;

import com.building.Apartment;

public class ApartmentMemento implements BuildingMemento{
    private final Apartment apartment;
    private final double monthlyRental;
    private final String supportStaff;

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
}
