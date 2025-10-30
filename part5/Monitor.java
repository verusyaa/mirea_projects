package lab5.part5;

public class Monitor {
    private MonitorBrand brand;
    private String model;
    private double size; // в дюймах
    private String resolution; // 1920x1080, 3840x2160 и т.д.

    public Monitor(MonitorBrand brand, String model, double size, String resolution) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.resolution = resolution;
    }

    // Геттеры
    public MonitorBrand getBrand() { return brand; }
    public String getModel() { return model; }
    public double getSize() { return size; }
    public String getResolution() { return resolution; }

    @Override
    public String toString() {
        return brand + " " + model + " " + size + "\" " + resolution;
    }
}
