package My_Package;

public class Main {
    public static void main(String[] args) {
        System.out.println("Первое задание: ");
        FirstTask firstTask = new FirstTask();
        firstTask.firstRuenner();

        System.out.println("Второе задание: ");
        SecondTask secondTask = new SecondTask();
        secondTask.secondRunner();

        System.out.println("Третье задание: ");
        ThirdTask thirdTask = new ThirdTask();
        thirdTask.thirdRunner(args);

        System.out.println("Четвертое задание: ");
        FourthTask fourthTask = new FourthTask();
        fourthTask.fourthRunner();

        System.out.println("Пятое задание: ");
        FifthTask fifthTask = new FifthTask();
        fifthTask.fifthRunner();
    }
}