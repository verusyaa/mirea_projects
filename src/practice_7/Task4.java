package practice_7;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Год: ");
        int year = sc.nextInt();

        System.out.print("Месяц (1-12): ");
        int month = sc.nextInt() - 1;

        System.out.print("Число: ");
        int day = sc.nextInt();

        System.out.print("Часы: ");
        int hour = sc.nextInt();

        System.out.print("Минуты: ");
        int minute = sc.nextInt();

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute);

        Date date = cal.getTime();

        System.out.println("Объект Date: " + date);
        System.out.println("Объект Calendar: " + cal.getTime());
    }
}
