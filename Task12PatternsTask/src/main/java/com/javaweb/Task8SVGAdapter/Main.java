package com.javaweb.Task8SVGAdapter;

/**
 * @author Andrii Chernysh on 14-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        SVGA svga = new SVGA();
        System.out.println("WE have SVGA : ");
        svga.connectAnalog();

        System.out.println("Create adapter for DVI : ");
        DVI dvi = new DVI(svga);
        System.out.println("Connected with adapter : ");
        dvi.connectDigital();
    }
}
