package models;

public class TV {
    private Producer producer;
    private Frequency frequency;
    private LightType lightType;

    public TV(Producer producer, Frequency frequency, LightType lightType)
    {
        this.producer=producer;
        this.frequency=frequency;
        this.lightType=lightType;
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
}
