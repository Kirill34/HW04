package models;

public class TV {
    private Producer producer;
    private Frequency frequency;
    private LightType lightType;
    private DiagonalInterval diagonalInterval;

    public TV(Producer producer, Frequency frequency, LightType lightType, DiagonalInterval diagonalInterval)
    {
        this.producer=producer;
        this.frequency=frequency;
        this.lightType=lightType;
        this.diagonalInterval=diagonalInterval;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public LightType getLightType() {
        return lightType;
    }

    public Producer getProducer() {
        return producer;
    }

    public DiagonalInterval getDiagonalInterval() {
        return diagonalInterval;
    }
}
