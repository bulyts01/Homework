package Lesson_42_Homework_22_06;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String ADD = "ADD";
    public static final String LIST = "LIST";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@yandex.ru == HeLLO@YANdex.RU
        - вывод на печать должен быть в нижнем регистре
           hello@yandex.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            System.out.println("\nInput command:" +
                    "\n[ADD + < > + <email>] - for adding new email" +
                    "\n[LIST] - for output email.list" +
                    "\n[0] - for exit");
            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                break;
            } else if (input.contains(ADD)){
                if (input.length() > 4) {
                    String email = input.toLowerCase().substring(4).trim();
                    emailList.add(email);
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            } else if (input.equals(LIST)) {
                emailList.getSortedEmails().forEach(System.out::println);
            }

            //TODO: write code here

        }
    }

}
