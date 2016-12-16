package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class RAM implements Memory {
    private int memoryCapacity;

    public RAM(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    @Override
    public int getMemoryCapacity() {
        return this.memoryCapacity;
    }
}
