import com.building.Building;
import com.command.*;
import com.factory.CommandFactory;
import com.memento.BuildingCaretaker;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        HashMap<Integer, Building> buildings = new HashMap<>(); //building save list
        Stack<Command> undoList = new Stack<>(); //undo command list
        Stack<Command> redoList = new Stack<>(); //redo command list
        BuildingCaretaker buildingCaretaker = new BuildingCaretaker();

        while(true){
            System.out.println();
            System.out.println("Building Management System (BMS)");
            System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
            System.out.println("a = add building, d = display buildings, m = modify building, e = edit rooms, u = undo, r = redo, l = list undo/redo, x = exit system");
            Command cmd = CommandFactory.createCmd(buildings, undoList, redoList, sc, buildingCaretaker);
            if(cmd != null) cmd.execute();
        }
    }
}