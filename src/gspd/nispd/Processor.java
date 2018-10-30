package gspd.nispd;

public class Processor implements Comparable<Processor> {
    int numberOfCores;
    int powerPerCore;

    public Processor(int numberOfCores, int powerPerCore) {
        this.numberOfCores = numberOfCores;
        this.powerPerCore = powerPerCore;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public int getPowerPerCore() {
        return powerPerCore;
    }

    public int getPower() {
        return powerPerCore * numberOfCores;
    }

    @Override
    public int compareTo(Processor processor) {
        return getPower() - processor.getPower();
    }
}
