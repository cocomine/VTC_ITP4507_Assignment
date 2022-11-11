package com.command;

import java.util.Stack;

public class listUndoRedoCmd implements Command{
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;

    /**
     * List Undo Redo list
     * @param undoList Undo List
     * @param redoList Redo List
     */
    public listUndoRedoCmd(Stack<Command> undoList, Stack<Command> redoList){
        this.undoList = undoList;
        this.redoList = redoList;
    }

    @Override
    public void execute(){
        System.out.println("Undo List:");
        if(!undoList.isEmpty()){
            for(int i = undoList.size() - 1 ; i >= 0 ; i--){
                System.out.println(undoList.get(i));
            }
        }else{
            System.out.println("Nothing in Undo list!");
        }
        System.out.println("Redo List:");
        if(!redoList.isEmpty()){
            for(int i = redoList.size() - 1 ; i >= 0 ; i--){
                System.out.println(redoList.get(i));
            }
        }else{
            System.out.println("Nothing in Redo list!");
        }
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
