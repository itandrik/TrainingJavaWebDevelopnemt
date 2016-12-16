package com.javaweb.Task9HideComputerRealisation;

/**
 * @author Andrii Chernysh on 16-Dec-16. E-Mail : itcherry97@gmail.com
 */
public class Computer implements IComputer{
    private CPU cpu;
    private GPU gpu;
    private HDD hdd;
    private RAM ram;
    private Monitor monitor;
    private ComputerManufacturer manufacturer;

    public Computer() {
    }

    @Override
    public void on() {
        System.out.println("Computer is ON");
    }

    @Override
    public void off() {
        System.out.println("Computer is OFF");

    }

    @Override
    public void helloWorld() {
        System.out.println("Computer says HELLO WORLD!!!");

    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public ComputerManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ComputerManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public static class Builder {
        private Computer computer;

        public Builder setCpu(CPU cpu) {
            computer.setCpu(cpu);
            return this;
        }

        public Builder setManufacturer(ComputerManufacturer manufacturer) {
            computer.setManufacturer(manufacturer);
            return this;
        }

        public Builder setGpu(GPU gpu) {
            computer.setGpu(gpu);
            return this;
        }


        public Builder setHdd(HDD hdd) {
            computer.setHdd(hdd);
            return this;
        }


        public Builder setRam(RAM ram) {
            computer.setRam(ram);
            return this;
        }


        public Builder setMonitor(Monitor monitor) {
            computer.setMonitor(monitor);
            return this;
        }

        public Computer build(){
            return computer;
        }
    }
}
