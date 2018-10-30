package gspd.nispd.memory;

import gspd.nispd.Sizable;

public class Memory implements Sizable, Comparable<Memory> {

    int size;
    int usedSpace;

    public Memory(int total) {
        this.size = total;
        this.usedSpace = 0;
    }


    public boolean fit(Sizable s) {
        return s.getSize() < getFreeSpace();
    }

    public int getUsedSpace() {
        return usedSpace;
    }

    public int getFreeSpace() {
        return size - usedSpace;
    }

    public void add(Sizable s) {
        if (fit(s)) {
            this.usedSpace += s.getSize();
        } else {
            // TODO: throw some exception
        }
    }

    private void remove(Sizable s) {
        if (s.getSize() < getUsedSpace()) {
            this.usedSpace -= s.getSize();
        } else {
            this.usedSpace = 0;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
        // TODO: Manage exception when it is not possible resize it
    }

    @Override
    public int compareTo(Memory memory) {
        return (size << 16 | usedSpace) - (memory.size << 16 | memory.usedSpace);
    }

}
