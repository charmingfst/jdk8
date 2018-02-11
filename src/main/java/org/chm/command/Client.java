package org.chm.command;

/**
 * Created by charming on 2018/1/3.
 */
public class Client {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        Command commandUp = new LiftCommand(elevator);

        Command commandDown = new FallCommand(elevator);


        Sender sender = new Sender(commandDown);
        sender.invoke();
    }
}
