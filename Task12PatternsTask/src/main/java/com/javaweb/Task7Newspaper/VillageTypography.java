package com.javaweb.Task7Newspaper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class VillageTypography implements Typography {
    private String name;
    private List<Subscriber> subscribers;
    private Newspaper newspaper;

    public VillageTypography(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    @Override
    public void printNewspaper(Newspaper newspaper) {
        System.out.println("Typography : " + this.getClass().getName() +
                " published 1 printing of newspaper : " + newspaper.getName());
        this.newspaper = newspaper;
        sendNewspaper();
    }

    @Override
    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void sendNewspaper() {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveNewspaper(newspaper);
        }
    }

    public String getName() {
        return name;
    }
}
