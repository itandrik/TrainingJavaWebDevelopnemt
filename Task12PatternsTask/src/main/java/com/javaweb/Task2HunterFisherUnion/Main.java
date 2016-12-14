package com.javaweb.Task2HunterFisherUnion;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
class Main {
    public static void main(String[] args) {
        State state1 = State.LOOK_ON_ANIMAL;
        State state2 = State.ON_THE_BANK_OF_THE_RIVER;

        //You are fisher
        Context context = new Context();
        context.setState(state2);
        context.sayMessage();

        //Now you become hunter&fisher
        System.out.println("------------------------------");
        System.out.println("Oh my god, there are a deer!!");
        Context context2 = new Context();
        context2.setState(state1);

        context.setNextState(context2);
        context.sayMessage();

    }
}
