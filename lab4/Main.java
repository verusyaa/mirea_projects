package lab4;

public class Main {
    public static void main(String[] args) {
        Seasons favoriteSeason = Seasons.SUMMER;
        System.out.println("Мое любимое время года:");
        System.out.println("Название: " + favoriteSeason);
        System.out.println("Русское название: " + favoriteSeason.getRussianName());
        System.out.println("Средняя температура: " + favoriteSeason.getAverageTemperature());
        System.out.println("Описание: " + favoriteSeason.getDescription());
        System.out.println(); //Оставляем пустую строку для разделения заданий

        Seasons.printSeasonPreference(Seasons.SPRING);
        Seasons.printSeasonPreference(Seasons.WINTER);
        Seasons.printSeasonPreference(Seasons.AUTUMN);
        Seasons.printSeasonPreference(favoriteSeason); //Лето
        System.out.println();

        System.out.println("Все времена года: ");
        for (Seasons season : Seasons.values()) {
            System.out.println(season.getRussianName() + " средняя температура: " +  season.getAverageTemperature() + "Описание: " +  season.getDescription());
        }
    }
}
