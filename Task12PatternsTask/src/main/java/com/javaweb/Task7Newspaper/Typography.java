package com.javaweb.Task7Newspaper;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public interface Typography {
    void printNewspaper(Newspaper newspaper);
    void addSubscriber(Subscriber s);
    void removeSubscriber(Subscriber s);
    void sendNewspaper();
}
