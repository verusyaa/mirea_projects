package practice_7;

import java.util.Date;

public class Task1 {

    public static void main(String[] args) {

        String developer = "Аршанова";
        String received = "Дата получения задания: 01.12.2025 17:00";

        Date submit = new Date();

        System.out.println("Разработчик: " + developer);
        System.out.println(received);
        System.out.println("Дата сдачи задания: " + submit);
    }
}

