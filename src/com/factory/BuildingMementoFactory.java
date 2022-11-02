package com.factory;

import com.building.Apartment;
import com.building.Building;
import com.building.House;
import com.memento.ApartmentMemento;
import com.memento.BuildingMemento;
import com.memento.HouseMemento;

public class BuildingMementoFactory{

    /**
     * Create Building Memento
     * @param building Building
     * @return Building Memento
     */
    public static BuildingMemento createBuildingMemento(Building building){
        if(building.getClass().equals(Apartment.class)){
            return new ApartmentMemento((Apartment) building);
        }else {
            return new HouseMemento((House) building);
        }
    }
}
