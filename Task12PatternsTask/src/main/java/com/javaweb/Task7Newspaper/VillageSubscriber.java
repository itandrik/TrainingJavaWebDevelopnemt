package com.javaweb.Task7Newspaper;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class VillageSubscriber implements Subscriber {
    private String name;
    private String address;

    public VillageSubscriber(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void receiveNewspaper(Newspaper newspaper) {
        System.out.println("Subscriber " + name + " got newspaper " + newspaper.getName());
        System.out.println("\tAddress of subscriber : " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
