package org.chm.command;

/**
 * Created by charming on 2018/1/3.
 */
public class LiftCommand extends Command {

    public LiftCommand(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void execute() {
        elevator.lift();
    }
}
