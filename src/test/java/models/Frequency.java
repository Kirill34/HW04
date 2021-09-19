package models;

public class Frequency {
    private int frequency;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Frequency(int frequency)
    {
        this.frequency=frequency;
    }

    @Override
    public String toString() {
        return String.valueOf(this.frequency)+" Гц";
    }
}
