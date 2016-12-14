package com.javaweb.Task2HunterFisherUnion;

/**
 * @author Andrii Chernysh; E-MAIL : itcherry97@gmail.com;
 */
public class Context {
    protected Context nextContext;
    protected Human human;

    public void setState(State state) {
        switch (state) {
            case LOOK_ON_ANIMAL:
                human = new Hunter();
                break;
            case ON_THE_BANK_OF_THE_RIVER:
                human = new Fisher();
                break;
            case ON_THE_MUSHROOM_FIELD:
                human = new Mushroomer();
                break;
            default:
                throw new RuntimeException("No such state!!!");
        }
    }

    public void setNextState(Context state) {
        nextContext = state;
    }

    public void sayMessage() {
        human.sayMessage();
        if(nextContext != null) {
            nextContext.sayMessage();
        }
    }
}
