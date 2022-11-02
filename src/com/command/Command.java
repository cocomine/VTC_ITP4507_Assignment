package com.command;

public interface Command{

    /**
     * Execute command
     */
    void execute();

    /**
     * Undo command
     */
    void undo();

    /**
     * Redo command
     */
    void redo();
}
