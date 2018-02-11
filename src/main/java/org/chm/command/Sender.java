package org.chm.command;

/**
 * Created by charming on 2018/1/3.
 */
public class Sender
{
    private Command command;

    public Sender(Command command) {
        this.command = command;
    }

    public void invoke()
    {
        command.execute();
    }

}
