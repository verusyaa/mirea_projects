package practice_7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        System.out.println("Введите дату (dd.MM.yyyy HH:mm):");
        String input = sc.nextLine();

        Date userDate = sdf.parse(input);
        Date now = new Date();

        System.out.println("Текущая дата/время: " + sdf.format(now));
        System.out.println("Введённая дата:      " + sdf.format(userDate));

        if (userDate.after(now)) {
            System.out.println("Введённая дата позже текущей.");
        } else if (userDate.before(now)) {
            System.out.println("Введённая дата раньше текущей.");
        } else {
            System.out.println("Даты совпадают.");
        }
    }
}
