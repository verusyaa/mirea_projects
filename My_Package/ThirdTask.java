package My_Package;

public class ThirdTask {
    public void thirdRunner(String[] arguments) {
        System.out.println("Аргументы командной строки: ");

        if (arguments.length == 0) {
            System.out.println("Арнументов нет");
            return;
        }

        for (int i = 0; i < arguments.length; i++) {
            System.out.println("Аргумент " + i + ": " + arguments[i]);
        }
    }
}
