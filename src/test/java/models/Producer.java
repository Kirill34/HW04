package models;

public class Producer {
    private String producer;

    public final String SAMSUNG = "Samsung";
    public final String LG = "LG";

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Producer(String producer)
    {
        this.producer=producer;
    }
}
