package com.javaweb.Task10Pen;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Writer {
    private Human human;
    private Pen pen;
    private Text text;
    private Paper paper;

    public Writer(Human human) {
        this.human = human;
        paper = new Paper();
    }

    public void writeText(Pen pen, Text text){
        pen.write(paper,text);
    }

    public void showText(){
        paper.showPaper();
    }
}
