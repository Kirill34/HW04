package models;

public class DiagonalInterval {
    int min;
    int max;

    public DiagonalInterval(int min, int max)
    {
        this.min=min;
        this.max=max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
