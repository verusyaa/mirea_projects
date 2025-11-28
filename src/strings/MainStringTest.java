package strings;

public class MainStringTest {
    public static void main(String[] args) {
        ProcessStrings ps = new ProcessStrings();

        String s = "Arshanova Vera";

        System.out.println("Длина: " + ps.countChars(s));
        System.out.println("Нечётные позиции: " + ps.oddPositionChars(s));
        System.out.println("Инвертированная: " + ps.invert(s));
    }
}

