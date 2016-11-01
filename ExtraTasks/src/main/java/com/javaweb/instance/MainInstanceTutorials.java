package com.javaweb.instance;

/**
 * Created by Dron on 01-Nov-16.
 */
public class MainInstanceTutorials {
    private static MainInstanceTutorials instance = null;

    public synchronized static MainInstanceTutorials getInstance() {
        if (instance == null)
            instance = new MainInstanceTutorials();
        return instance;
    }

    public void checkInstance(){
        Parent p = new Child(5);
        Parent p1 = new ChildOfChild(6);
        Parent p2 = new Child2();
        Parent par = new Parent();

        Child ch = new Child(4);
        ChildOfChild childOfChild = new ChildOfChild(3);
        //Child2 ch2 = new Child2();

        System.out.println("null instanceof Parent : " + (null instanceof Parent));
        System.out.println("null instanceof Child2 : " + (null instanceof Child2));
        System.out.println("null instanceof Child : " + (null instanceof Child));
        System.out.println("null instanceof ChildOfChild : " + (null instanceof ChildOfChild));
        System.out.println("null instanceof Child2 : " + (null instanceof Child2));

        //System.out.println(ch instanceof null); - invalid
        System.out.println("par instanceof Child : " + (par instanceof Child));
        System.out.println("par instanceof ChildOfChild : " + (par instanceof ChildOfChild));
        System.out.println("p instanceof ChildOfChild : " + (p instanceof ChildOfChild));
        System.out.println("p instanceof Child : " + (p instanceof Child));
        System.out.println("ch instanceof ChildOfChild : " + (ch instanceof ChildOfChild));

        System.out.println("ch instanceof Parent : " + (ch instanceof Parent));
        System.out.println("childOfChild instanceof Parent : " + (childOfChild instanceof Parent));
        System.out.println("p1 instanceof Child : " + (p1 instanceof Child));
        System.out.println("p1 instanceof Parent : " + (p1 instanceof Parent));

        // System.out.println(ch instanceof Child2); invalid
    }
}
