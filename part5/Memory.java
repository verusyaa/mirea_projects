package lab5.part5;

public class Memory {
    private MemoryBrand brand;
    private String type; // DDR3, DDR4, DDR5
    private int size; // в GB
    private int frequency; // в MHz

    public Memory(MemoryBrand brand, String type, int size, int frequency) {
        this.brand = brand;
        this.type = type;
        this.size = size;
        this.frequency = frequency;
    }

    // Геттеры
    public MemoryBrand getBrand() { return brand; }
    public String getType() { return type; }
    public int getSize() { return size; }
    public int getFrequency() { return frequency; }

    @Override
    public String toString() {
        return size + "GB " + type + " " + brand + " " + frequency + "MHz";
    }
}
