public class DivisionDemo {

    public void demo1() {
        System.out.println("Попытка деления 2 на 0:");
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void demo2() {
        System.out.println("\nПопытка деления 2.0 на 0.0:");
        System.out.println(2.0 / 0.0);
    }

    public static void main(String[] args) {
        DivisionDemo demo = new DivisionDemo();
        demo.demo1();
        demo.demo2();
    }
}