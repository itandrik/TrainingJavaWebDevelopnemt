package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class HDD implements Memory {
    private int memoryCapacity;

    public HDD(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    @Override
    public int getMemoryCapacity() {
        return 0;
    }
}
