package My_Package;

public class FirstTask {
    int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int sum;


    public void firstRuenner() {
        for (int num: numbers) {
            sum += num;
        }

        System.out.println("Сумма: " + sum + " и среднее арифметическое: " + sum / numbers.length);
    }
}
