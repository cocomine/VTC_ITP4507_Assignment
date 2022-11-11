package com.factory;

import com.building.Building;
import com.command.*;
import com.command.room.editRoomCmd;
import com.command.building.addBuildingCmd;
import com.command.building.modifyBuildingCmd;
import com.memento.BuildingCaretaker;
import com.memento.RoomCaretaker;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class CommandFactory{
    /**
     * Create Command
     * @param buildings Building list
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     * @return Command
     */
    public static Command createCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, BuildingCaretaker buildingCaretaker, RoomCaretaker roomCaretaker){
        return switch(sc.next()){
            case "a" -> new addBuildingCmd(buildings, undoList, redoList, sc);
            case "d" -> new displayBuildingCmd(buildings, sc);
            case "m" -> new modifyBuildingCmd(buildings, undoList, redoList, sc, buildingCaretaker);
            case "e" -> new editRoomCmd(buildings, undoList, redoList, sc, roomCaretaker);
            case "u" -> new undoCmd(undoList, redoList);
            case "r" -> new redoCmd(undoList, redoList);
            case "l" -> new listUndoRedoCmd(undoList, redoList);
            case "x", "X" -> new exitCmd();
            default -> null;
        };


    }
}
