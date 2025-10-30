package lab5.part5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private String name;
    private List<Computer> computers;

    public Shop(String name) {
        this.name = name;
        this.computers = new ArrayList<>();
    }

    public boolean addComputer(Computer computer) {
        return computers.add(computer);
    }

    public boolean removeComputer(int index) {
        if (index >= 0 && index < computers.size()) {
            computers.remove(index);
            return true;
        }
        return false;
    }

    public boolean removeComputer(Computer computer) {
        return computers.remove(computer);
    }

    public List<Computer> findComputersByBrand(ComputerBrand brand) {
        return computers.stream()
                .filter(comp -> comp.getBrand() == brand)
                .collect(Collectors.toList());
    }

    public List<Computer> findComputersByPrice(double minPrice, double maxPrice) {
        return computers.stream()
                .filter(comp -> comp.getPrice() >= minPrice && comp.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Computer> findComputersByProcessor(ProcessorBrand processorBrand) {
        return computers.stream()
                .filter(comp -> comp.getProcessor().getBrand() == processorBrand)
                .collect(Collectors.toList());
    }

    public List<Computer> findComputersByMemorySize(int minMemory) {
        return computers.stream()
                .filter(comp -> comp.getMemory().getSize() >= minMemory)
                .collect(Collectors.toList());
    }

    public List<Computer> searchComputers(ComputerBrand brand, Double minPrice, Double maxPrice,
                                          ProcessorBrand processorBrand, Integer minMemory) {
        return computers.stream()
                .filter(comp -> brand == null || comp.getBrand() == brand)
                .filter(comp -> minPrice == null || comp.getPrice() >= minPrice)
                .filter(comp -> maxPrice == null || comp.getPrice() <= maxPrice)
                .filter(comp -> processorBrand == null || comp.getProcessor().getBrand() == processorBrand)
                .filter(comp -> minMemory == null || comp.getMemory().getSize() >= minMemory)
                .collect(Collectors.toList());
    }

    public List<Computer> getAllComputers() {
        return new ArrayList<>(computers);
    }

    public int getComputerCount() {
        return computers.size();
    }

    public void clearShop() {
        computers.clear();
    }

    @Override
    public String toString() {
        if (computers.isEmpty()) {
            return "Магазин '" + name + "' пуст";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Магазин '").append(name).append("' ===\n");
        sb.append("Количество компьютеров: ").append(computers.size()).append("\n\n");

        for (int i = 0; i < computers.size(); i++) {
            sb.append(i + 1).append(". ").append(computers.get(i).toShortString()).append("\n");
        }

        return sb.toString();
    }
}
