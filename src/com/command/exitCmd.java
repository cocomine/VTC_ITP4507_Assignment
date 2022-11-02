package com.command;

public class exitCmd implements Command{

    /**
     * Exit Command
     */
    public exitCmd(){
    }

    @Override
    public void execute(){
        System.exit(0);
    }

    @Override
    public void undo(){

    }

    @Override
    public void redo(){

    }
}
