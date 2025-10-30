package lab5.part5;

public class ComputerShopApp {
    public static void main(String[] args) {
        Shop shop = new Shop("TechStore");

        addDemoComputers(shop);

        ShopInterface shopInterface = new ShopInterface(shop);
        shopInterface.start();
    }

    private static void addDemoComputers(Shop shop) {
        Processor proc1 = new Processor(ProcessorBrand.INTEL, "Core i7-13700K", 3.4, 16);
        Memory mem1 = new Memory(MemoryBrand.CORSAIR, "DDR5", 32, 5600);
        Monitor mon1 = new Monitor(MonitorBrand.DELL, "UltraSharp", 27.0, "3840x2160");
        Computer comp1 = new Computer(ComputerBrand.DELL, "XPS 8950", proc1, mem1, mon1, 1499.99);

        Processor proc2 = new Processor(ProcessorBrand.AMD, "Ryzen 9 7900X", 4.7, 12);
        Memory mem2 = new Memory(MemoryBrand.GSKILL, "DDR5", 64, 6000);
        Monitor mon2 = new Monitor(MonitorBrand.ASUS, "ROG Swift", 32.0, "2560x1440");
        Computer comp2 = new Computer(ComputerBrand.ASUS, "ROG Strix", proc2, mem2, mon2, 2199.99);

        Processor proc3 = new Processor(ProcessorBrand.APPLE_SILICON, "M2 Pro", 3.5, 12);
        Memory mem3 = new Memory(MemoryBrand.SAMSUNG, "LPDDR5", 16, 6400);
        Monitor mon3 = new Monitor(MonitorBrand.LG, "Studio Display", 27.0, "5120x2880");
        Computer comp3 = new Computer(ComputerBrand.APPLE, "Mac Studio", proc3, mem3, mon3, 1999.99);

        shop.addComputer(comp1);
        shop.addComputer(comp2);
        shop.addComputer(comp3);
    }
}
