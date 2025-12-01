package practice_7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task3 {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date d = sdf.parse("29.04.2005");

        Student st = new Student("Аршанова Вера", d);

        System.out.println(st);
        System.out.println("Короткий формат: " + st.getFormattedBirthDate("dd.MM.yy"));
        System.out.println("Средний формат:  " + st.getFormattedBirthDate("dd MMM yyyy"));
        System.out.println("Полный формат:   " + st.getFormattedBirthDate("dd MMMM yyyy"));
    }
}
