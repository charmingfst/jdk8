package org.chm.command;

/**
 * Created by charming on 2018/1/3.
 * 命令模式
 */
public abstract class Command {
    protected Elevator elevator;

    public Command(Elevator elevator) {
        this.elevator = elevator;
    }

    public abstract void execute();
}
