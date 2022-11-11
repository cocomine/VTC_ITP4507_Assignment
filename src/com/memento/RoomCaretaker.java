package com.memento;

import com.building.Apartment;
import com.building.Building;
import com.building.House;
import com.building.Room;

import java.util.Stack;

public class RoomCaretaker{
    private final Stack<RoomMemento> undoList; //undo Memento list
    private final Stack<RoomMemento> redoList; //redo Memento list

    public RoomCaretaker(){
        undoList = new Stack<>();
        redoList = new Stack<>();
    }

    /**
     * Save Class stats
     * @param room Room
     */
    public void saveClass(Room room){
        redoList.clear();
        RoomMemento memento = new RoomMemento(room);
        undoList.push(memento);
    }

    /**
     * undo stats
     */
    public void undo(){
        if(!undoList.isEmpty()){
            RoomMemento memento = undoList.pop();
            Room tmp = memento.getOrig();

            RoomMemento new_memento = new RoomMemento(tmp);
            redoList.push(new_memento);
            memento.restore();
        }else {
            System.out.println("Nothing to redo.");
        }
    }

    /**
     * redo stats
     */
    public void redo(){
        if(!redoList.isEmpty()){
            RoomMemento memento = redoList.pop();
            Room tmp = memento.getOrig();

            RoomMemento new_memento = new RoomMemento(tmp);
            undoList.push(new_memento);
            memento.restore();
        }else {
            System.out.println("Nothing to redo.");
        }
    }
}
