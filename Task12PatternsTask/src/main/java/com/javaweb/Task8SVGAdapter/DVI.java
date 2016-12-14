package com.javaweb.Task8SVGAdapter;

/**
 * @author Andrii Chernysh on 14-Dec-16.
 *         E-Mail : itcherry97@gmail.com
 */
public class DVI implements Adapter{
    private SVGA svga;

    public DVI(SVGA svga) {
        this.svga = svga;
    }

    public void connectDigital() {
        svga.connectAnalog();
        System.out.println("Connect to DVI(digital)");
    }
}
