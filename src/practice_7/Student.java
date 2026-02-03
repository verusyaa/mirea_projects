package practice_7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String name;
    private Date birthDate;

    public Student(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(birthDate);
    }

    @Override
    public String toString() {
        return name + ", дата рождения: " + getFormattedBirthDate("dd.MM.yyyy");
    }
}
