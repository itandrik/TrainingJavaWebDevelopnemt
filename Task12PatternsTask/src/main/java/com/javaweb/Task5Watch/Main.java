package com.javaweb.Task5Watch;

import java.util.Date;

/**
 * @author Andrii Chernysh on 14-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        //Variant 1
        /*Watch watch = new DigitalWatch();
        watch.showTime();

        watch = new RomeWatch();
        watch.showTime();*/


        //Variant 2
        /*WatchMaker maker = new RomeWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();

        maker = new DigitalWatchMaker();
        watch = maker.createWatch();
        watch.showTime();*/


        //Variant 3
        WatchMaker maker = getMakerByName("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        } else {
            throw new RuntimeException("No such maker : " + maker);
        }
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XX");
    }

}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}

