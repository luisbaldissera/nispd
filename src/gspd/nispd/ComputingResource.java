package gspd.nispd;

import gspd.nispd.memory.Memory;

public class ComputingResource implements Comparable<ComputingResource> {

    private Memory mainMemory;
    private Memory secondMemory;
    private Processor processor;

    public ComputingResource(Memory mainMemory, Memory secondMemory, Processor processor) {
        this.mainMemory = mainMemory;
        this.secondMemory = secondMemory;
        this.processor = processor;
    }

    @Override
    public int compareTo(ComputingResource cr) {
        if (mainMemory.compareTo(cr.mainMemory) != 0) {
            if (secondMemory.compareTo(cr.secondMemory) != 0) {
                return processor.compareTo(cr.processor);
            }
            return secondMemory.compareTo(cr.secondMemory);
        }
        return mainMemory.compareTo(cr.mainMemory);
    }

    void foo() {

    }
}
