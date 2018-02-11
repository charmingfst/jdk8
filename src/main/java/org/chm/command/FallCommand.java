package org.chm.command;

/**
 * Created by charming on 2018/1/3.
 */
public class FallCommand extends Command {

    public FallCommand(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void execute() {
        elevator.fall();
    }
}
