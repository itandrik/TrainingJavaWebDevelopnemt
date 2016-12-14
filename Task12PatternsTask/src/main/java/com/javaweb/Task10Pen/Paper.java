package com.javaweb.Task10Pen;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Paper {
    private static final int DEFAULT_FREE_SPACE = 1000;
    private int freeSpace;
    private List<String> paper = new LinkedList<String>();

    public Paper(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Paper() {
        freeSpace = DEFAULT_FREE_SPACE;
    }

    public boolean hasFreeSpaceForText(String text){
        return freeSpace > text.length();
    }

    public void addText(String text){
        paper.add(text);
        freeSpace -= text.length();
    }

    public void showPaper(){
        StringBuilder sb = new StringBuilder();
        paper.forEach(sb::append);
        System.out.printf("Paper + [%s];\n Text : %s;" +
                        "\n Free space on paper : %d symbols",
                this.getClass().getCanonicalName(),sb.toString(),
                freeSpace);

    }


}
