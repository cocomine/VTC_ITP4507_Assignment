package com.memento;

import com.building.Apartment;
import com.building.Building;
import com.building.House;

import java.util.Stack;

public class BuildingCaretaker{
    private Stack<BuildingMemento> undoList;
    private Stack<BuildingMemento> redoList;

    public BuildingCaretaker(){
        undoList = new Stack<>();
        redoList = new Stack<>();
    }

    /**
     *
     * @param building
     */
    public void saveClass(Building building){
        redoList.clear();
        BuildingMemento memento;
        if(building.getClass().equals(Apartment.class)){
            memento = new ApartmentMemento((Apartment) building);
        }else {
            memento = new HouseMemento((House) building);
        }
        undoList.push(memento);
    }

    /**
     *
     */
    public void undo(){
        if(!undoList.isEmpty()){
            BuildingMemento memento = undoList.pop();
            Building tmp = memento.getOrig();

            BuildingMemento new_memento;
            if(tmp.getClass().equals(Apartment.class)){
                new_memento = new ApartmentMemento((Apartment) tmp);
            }else {
                new_memento = new HouseMemento((House) tmp);
            }

            redoList.push(new_memento);
            memento.restore();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    /**
     *
     */
    public void redo(){
        if(!redoList.isEmpty()){
            BuildingMemento memento = redoList.pop();
            Building tmp = memento.getOrig();

            BuildingMemento new_memento;
            if(tmp.getClass().equals(Apartment.class)){
                new_memento = new ApartmentMemento((Apartment) tmp);
            }else {
                new_memento = new HouseMemento((House) tmp);
            }

            redoList.push(new_memento);
            memento.restore();
        }else {
            System.out.println("Nothing to redo.");
        }
    }
}
