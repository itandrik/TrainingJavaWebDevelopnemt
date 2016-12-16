package com.javaweb.Task9HideComputerRealisation.commands;

import com.javaweb.Task9HideComputerRealisation.Computer;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class TurnComputerOff implements Command{
    private Computer computer;

    public TurnComputerOff(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.off();
    }
}
