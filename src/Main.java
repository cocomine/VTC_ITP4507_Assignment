import com.building.Building;
import com.command.*;
import com.factory.CommandFactory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        HashMap<Integer, Building> buildings = new HashMap<>();
        Stack<Command> undoList = new Stack<>();
        Stack<Command> redoList = new Stack<>();

        while(true){
            System.out.println();
            System.out.println("Building Management System (BMS)");
            System.out.println("Please enter command: [a|d|m|e|u|r|l|x]");
            System.out.println("a = add building, d = display buildings, m = modify building, e = edit rooms, u = undo, r = redo, l = list undo/redo, x = exit system");
            Command cmd = CommandFactory.createCmd(buildings, undoList, redoList, sc);
            if(cmd != null) cmd.execute();
        }
    }
}