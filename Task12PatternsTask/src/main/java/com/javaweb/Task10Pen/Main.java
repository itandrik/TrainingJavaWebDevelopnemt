package com.javaweb.Task10Pen;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Homo Sapiens",
                "00.00.00",
                "No mobile phone",
                Human.Gender.MALE);
        Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit,\n" +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad\n" +
                " minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea\n" +
                " commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                " cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                " proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Pen pen = new PenImpl();
        Writer writer = new Writer(human);
        writer.writeText(pen,text);
        writer.writeText(pen,text);
        writer.writeText(pen,text);
        writer.showText();
    }
}
