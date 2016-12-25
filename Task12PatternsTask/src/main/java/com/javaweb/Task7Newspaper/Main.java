package com.javaweb.Task7Newspaper;

/**
 * @author Andrii Chernysh on 25-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        VillageTypography publisher = new VillageTypography("O'Reily");
        Subscriber vasya = new VillageSubscriber(
                "Vasya", "5 Matvii st., Kikova, Ukraine");
        Subscriber dima = new VillageSubscriber(
                "Dima", "6 Matvii st., Kikova, Ukraine");
        Subscriber petya = new VillageSubscriber(
                "Petya", "7 Matvii st., Kikova, Ukraine");
        Subscriber kiril = new VillageSubscriber(
                "Kiril", "8 Matvii st., Kikova, Ukraine");
        Subscriber artem = new VillageSubscriber(
                "Artem", "9 Matvii st., Kikova, Ukraine");
        Subscriber valeria = new VillageSubscriber(
                "Valeria", "10 Matvii st., Kikova, Ukraine");
        publisher.addSubscriber(vasya);
        publisher.addSubscriber(dima);
        publisher.addSubscriber(petya);
        publisher.addSubscriber(kiril);
        publisher.addSubscriber(artem);
        publisher.addSubscriber(valeria);

        publisher.printNewspaper(new Newspaper.Builder()
                .setName("Pravda")
                .setCountOfPages(10)
                .setPublisher(publisher.getName())
                .setText("Lorem ipsum...")
                .printNewspaper());
    }
}
