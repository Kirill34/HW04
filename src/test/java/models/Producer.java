package models;

public class Producer {
    private String producer;

    public static String SAMSUNG = "Samsung";
    public static String LG = "LG";

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
