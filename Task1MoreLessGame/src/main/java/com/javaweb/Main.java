package com.javaweb;

/**
 * Main.java
 *
 * Start point of the game.
 * Here we will start controller {@link Controller}
 *
 * @version 1.0 29 Oct 2016
 * @author Andrii Chernysh {itcherry97@gmail.com}
 */
public class Main {
    public static void main(String []args){
        //Initialization
        Controller controller = new Controller();
        //Run
        controller.run();
    }
}
