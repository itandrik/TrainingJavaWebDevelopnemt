package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Monitor {
    private int diagonal;
    private int resolutionWidth;
    private int resolutionHeight;
    private String manufacturer;

    public Monitor(int diagonal, int resolutionWidth, int resolutionHeight, String manufacturer) {
        this.diagonal = diagonal;
        this.resolutionWidth = resolutionWidth;
        this.resolutionHeight = resolutionHeight;
        this.manufacturer = manufacturer;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public int getResolutionWidth() {
        return resolutionWidth;
    }

    public void setResolutionWidth(int resolutionWidth) {
        this.resolutionWidth = resolutionWidth;
    }

    public int getResolutionHeight() {
        return resolutionHeight;
    }

    public void setResolutionHeight(int resolutionHeight) {
        this.resolutionHeight = resolutionHeight;
    }
}
