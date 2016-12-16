package com.javaweb.Task9HideComputerRealisation;

import com.javaweb.Task9HideComputerRealisation.commands.SayComputerHello;
import com.javaweb.Task9HideComputerRealisation.commands.TurnComputerOff;
import com.javaweb.Task9HideComputerRealisation.commands.TurnComputerOn;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        /* Creating computer using builder pattern */
        Computer computer = new Computer.Builder()
                .setCpu(new CPU(1400,"Intel",16,4,3))
                .setGpu(new GPU(500,"Nvidia",3))
                .setHdd(new HDD(1000))
                .setRam(new RAM(8))
                .setMonitor(new Monitor(24,1920,1080,"Dell"))
                .setManufacturer(ComputerManufacturer.LENOVO)
                .build();
        System.out.println("Computer has been created!");

        /* Encapsulation realisation and using computer (COMMAND) */
        TurnComputerOn turnOn = new TurnComputerOn(computer);
        TurnComputerOff turnOff = new TurnComputerOff(computer);
        SayComputerHello sayHello = new SayComputerHello(computer);

        System.out.println("-----------------------------");
        ComputerButton button = new ComputerButton(turnOn);
        button.press();

        System.out.println("-----------------------------");
        button.setCommand(sayHello);
        button.press();
        button.press();
        button.press();

        System.out.println("-----------------------------");
        button.setCommand(turnOff);
        button.press();
    }
}
