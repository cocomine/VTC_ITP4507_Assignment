package com.command;

import com.building.Building;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class displayBuildingCmd implements Command{

    private HashMap<Integer, Building> buildings;
    private Scanner sc;

    /**
     * Display Building Command
     * @param buildings Building
     * @param sc Scanner
     */
    public displayBuildingCmd(HashMap<Integer, Building> buildings, Scanner sc){
        this.buildings = buildings;
        this.sc = sc;
    }

    @Override
    public void execute(){
        System.out.println("Enter Building No.(* to display all):");
        String id = sc.next();

        if(id.equals("*")){
            // list all
            for(Building building : buildings.values()){
                System.out.println(building);
            }
        }else {
            // print
            try{
                int building_id = Integer.parseInt(id);
                Building building = buildings.get(building_id);
                if(building != null) building.printBuilding(); //if match
            }catch(NumberFormatException ignored){

            }
        }
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
