package com.javaweb;

/**
 * Main.java
 * <p>
 * Start point of the game.
 * Here we will start controller {@link Controller}
 *
 * @author Andrii Chernysh {itcherry97@gmail.com}
 * @version 1.0 29 Oct 2016
 */
public class Main {
    public static void main(String[] args) {
        //Initialization
        Controller controller = new Controller();
        //Run
        controller.run();
    }
}
