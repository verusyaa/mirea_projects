package lab5.part5;

public class Computer {
    private ComputerBrand brand;
    private String model;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    private double price;

    public Computer(ComputerBrand brand, String model, Processor processor,
                    Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }


    public ComputerBrand getBrand() { return brand; }
    public String getModel() { return model; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format(
                "=== %s %s ===\n" +
                        "Цена: $%.2f\n" +
                        "Процессор: %s\n" +
                        "Память: %s\n" +
                        "Монитор: %s\n",
                brand, model, price, processor, memory, monitor
        );
    }


    public String toShortString() {
        return String.format("%s %s - $%.2f", brand, model, price);
    }
}
