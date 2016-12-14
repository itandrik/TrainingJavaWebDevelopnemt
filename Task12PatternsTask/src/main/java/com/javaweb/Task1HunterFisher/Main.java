package com.javaweb.Task1HunterFisher;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class Main {
    public static void main(String[] args) {
        State state = State.LOOK_ON_ANIMAL;
        Context context = new Context();
        context.setState(state);
        context.sayMessage();
    }
}
