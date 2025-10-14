package lab4;

public enum Seasons {
    WINTER(-5.0, "Зима"), //3-е задание (температура)
    SPRING(10.0, "Весна"),
    SUMMER(25.0, "Лето"),
    AUTUMN(8.0, "Осень");

    private final double averageTemperature;
    private final String russianName;

    Seasons(double averageTemperature, String russianName) {
        this.averageTemperature = averageTemperature;
        this.russianName = russianName;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public String getRussianName() {
        return russianName;
    }

    public String getDescription() {
        if (this == SUMMER) {
            return "Теплое время года";
        } else {
            return "Не теплое время гола";
        }
    }

    public static void printSeasonPreference(Seasons season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму!");
                break;
            case SPRING:
                System.out.println("Я люблю весну!");
                break;
            case SUMMER:
                System.out.println("Я люблю лето!");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень!");
                break;
            default:
                System.out.println("Неизвестное время года :(");
        }
    }
}
