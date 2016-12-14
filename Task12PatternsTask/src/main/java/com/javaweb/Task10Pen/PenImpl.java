package com.javaweb.Task10Pen;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class PenImpl implements Pen {
    public void write(Paper paper, Text text) {
        if(paper.hasFreeSpaceForText(text.getText())){
            paper.addText(text.getText());
        } else{
            System.out.println("No space on the paper");
        }
    }
}
