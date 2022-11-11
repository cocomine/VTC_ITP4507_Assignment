package com.command;

import java.util.Stack;

public class redoCmd implements Command{
    private final Stack<Command> undoList;
    private final Stack<Command> redoList;

    /**
     * Redo Command
     *
     * @param undoList Undo List
     * @param redoList Redo List
     */
    public redoCmd(Stack<Command> undoList, Stack<Command> redoList){
        this.undoList = undoList;
        this.redoList = redoList;
    }

    @Override
    public void execute(){
        if(!redoList.isEmpty()){
            Command com = redoList.pop();
            com.redo();
            undoList.push(com);
        }else{
            System.out.println("Nothing to redo!");
        }
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
