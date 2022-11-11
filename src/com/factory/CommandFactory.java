package com.factory;

import com.building.Building;
import com.command.*;
import com.memento.BuildingCaretaker;

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
    public static Command createCmd(HashMap<Integer, Building> buildings, Stack<Command> undoList, Stack<Command> redoList, Scanner sc, BuildingCaretaker buildingCaretaker){
        return switch(sc.next()){
            case "a" -> new addBuildingCmd(buildings, undoList, redoList, sc);
            case "d" -> new displayBuildingCmd(buildings, sc);
            case "m" -> new modifyBuildingCmd(buildings, undoList, redoList, sc, buildingCaretaker);
            case "e" -> new editRoomCmd(buildings, undoList, redoList, sc);
            case "u" -> new undoCmd(undoList, redoList);
            case "r" -> new redoCmd(undoList, redoList);
            case "l" -> new listUndoRedoCmd(undoList, redoList);
            case "x", "X" -> new exitCmd();
            default -> null;
        };


    }

    /**
     * Create Edit Room Command
     * @param building Building
     * @param undoList Undo list
     * @param redoList Redo list
     * @param sc Scanner
     * @return Command
     */
    public static Command createRoomCmd(Building building, Stack<Command> undoList, Stack<Command> redoList, Scanner sc){
        return switch(sc.next()){
            case "a" -> new addRoomCmd(building, undoList, redoList, sc);
            case "d" -> new deleteRoomCmd(building, undoList, redoList, sc);
            case "m" -> new modifyRoomCmd(building, undoList, redoList, sc);
            default -> null;
        };
    }
}
