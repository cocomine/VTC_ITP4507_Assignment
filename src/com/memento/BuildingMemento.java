package com.memento;

import com.building.Building;

public interface BuildingMemento extends Memento{
    Building getOrig();
}
