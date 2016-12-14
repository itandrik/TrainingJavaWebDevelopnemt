package com.javaweb.Task1HunterFisher;

/**
 * @author Andrii Chernysh on 14-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
class Context {
    private Human human;

    public void setState(State state){
        switch(state){
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

    public void sayMessage(){
        human.sayMessage();
    }
}
