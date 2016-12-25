package com.javaweb.Task7Newspaper;

/**
 * @author Andrii Chernysh on 25-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class Newspaper {
    private String name;
    private String publisher;
    private int countOfPages;
    private String text;

    public Newspaper() {
    }

    public Newspaper(String name, String publisher, int countOfPages, String text) {
        this.name = name;
        this.publisher = publisher;
        this.countOfPages = countOfPages;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public String getText() {
        return text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class Builder{
        private Newspaper newspaper = new Newspaper();

        public Builder setName(String name) {
            newspaper.setName(name);
            return this;
        }

        public Builder setCountOfPages(int countOfPages) {
            newspaper.setCountOfPages(countOfPages);
            return this;
        }

        public Builder setPublisher(String publisher) {
            newspaper.setPublisher(publisher);
            return this;
        }

        public Builder setText(String text) {
            newspaper.setText(text);
            return this;
        }

        public Newspaper printNewspaper(){
            return newspaper;
        }

    }
}
