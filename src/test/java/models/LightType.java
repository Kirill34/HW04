package models;

public class LightType {
    private String lightType;

    public static String DIRECT_LED="Direct LED";

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    public String getLightType() {
        return lightType;
    }

    public LightType(String lightType)
    {
        this.lightType=lightType;
    }
}
