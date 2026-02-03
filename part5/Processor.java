package lab5.part5;

public class Processor {
    private ProcessorBrand brand;
    private String model;
    private double frequency; // в GHz
    private int cores;

    public Processor(ProcessorBrand brand, String model, double frequency, int cores) {
        this.brand = brand;
        this.model = model;
        this.frequency = frequency;
        this.cores = cores;
    }

    // Геттеры
    public ProcessorBrand getBrand() { return brand; }
    public String getModel() { return model; }
    public double getFrequency() { return frequency; }
    public int getCores() { return cores; }

    @Override
    public String toString() {
        return brand + " " + model + " " + frequency + "GHz (" + cores + " cores)";
    }
}
