package com.command;

import java.util.Stack;

public class undoCmd implements Command{

    private Stack<Command> undoList;
    private Stack<Command> redoList;

    /**
     * Undo Command
     *
     * @param undoList Undo List
     * @param redoList Redo List
     */
    public undoCmd(Stack<Command> undoList, Stack<Command> redoList){
        this.undoList = undoList;
        this.redoList = redoList;
    }

    @Override
    public void execute(){
        if(!undoList.isEmpty()){
            Command com = undoList.pop();
            com.undo();
            redoList.push(com);
        }else{
            System.out.println("Nothing to undo!");
        }
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
