package com.javaweb.Task9HideComputerRealisation;

import com.javaweb.Task9HideComputerRealisation.commands.Command;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class ComputerButton {
    private Command command;

    public ComputerButton(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void press(){
        command.execute();
    }
}
