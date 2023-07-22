package Lesson_40_Homework_15_06;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Document document;
    public static void main(String[] args) {
        System.out.println("Введите URL сайта, например https://online.top-academy.ru/");
        String url = new Scanner(System.in).nextLine().trim();
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nTITLE: " + document.title());

        while (true) {
            System.out.println("\nВыберите дальнейшее действие: " +
                    "\n[1] - Извелечение содержимого по тегу" +
                    "\n[2] - Получение элементов по атрибуту" +
                    "\n[3] - Получение элементов с использованием CSS-селекторов" +
                    "\n[4] - Изменение содержимого элементов" +
                    "\n[0] - Выход");

            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1 -> getByTags();
                case 2 -> getByAttr();
                case 3 -> getBySelect();
                case 4 -> changeElement();
                case 0 -> {
                    System.out.println("Программа завершена");
                    return;
                }
                default -> System.out.println("Неверный ввод");
            }
        }
    }
    public static void getByTags() {
        System.out.println("Извлечение содержимого определенных тегов." +
                "\nВведите тег, например, <h1>, <p>, <a>, и т.д.");
        String inputTag = new Scanner(System.in).nextLine();
        Elements tags = document.getElementsByTag(inputTag);
        PrintWriter writerTags = null;
        try {
            writerTags = new PrintWriter("data/file_tags");

            PrintWriter finalWriterTags = writerTags;
            tags.forEach(tag -> finalWriterTags.append(tag.text() + "\n"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writerTags.flush();
            writerTags.close();
        }
        System.out.println("Данные сохранены в файле data/file_tags");
    }

    public static void getByAttr() {
        System.out.println("Получение элементов по атрибуту." +
                "\nВведите атрибут, например, href, crs, class, и т.д.");
        String inputAttr = new Scanner(System.in).nextLine();
        Elements attributes = document.getElementsByAttribute(inputAttr);
        try {
            PrintWriter writerAttributes = new PrintWriter("data/file_attributes");
            attributes.forEach(tag -> writerAttributes.append(attributes.text() + "\n"));
            writerAttributes.flush();
            writerAttributes.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println("Данные сохранены в файле data/file_attributes");
    }

    public static void getBySelect() {
        System.out.println("Получение элементов с использованием CSS-селекторов." +
                "\nВведите селектор, например, <span.town-name>");
        String inputCSS = new Scanner(System.in).nextLine();
        Elements elementes = document.getElementsByAttribute(inputCSS);
        try {
            PrintWriter writerElementes = new PrintWriter("data/file_CSS_select");
            elementes.forEach(tag -> writerElementes.append(elementes.text() + "\n"));
            writerElementes.flush();
            writerElementes.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println("Данные сохранены в файле data/file_CSS_select");
    }

    public static void changeElement() {
        System.out.println("Изменение содержимых по тегу." +
                "\nВведите тег элемента, который хотите изменить, например, <title>, <p>, <h2>, и т.д.");
        String inputOld = new Scanner(System.in).nextLine();
        System.out.println("Введите новый элемент для данного тега:");
        String inputNew = new Scanner(System.in).nextLine();
        try {
            // сохраняем изначальный код
            PrintWriter writer = new PrintWriter("data/code_from_url");
            writer.write(document.toString());
            writer.flush();
            writer.close();

            //парсим html код и заменяем содержимое элементов
            String htmlFileForChange = parseFile("data/code_from_url");
            Document documentForChange = Jsoup.parse(htmlFileForChange);
            Elements elementsForChange = documentForChange.select(inputOld);
            elementsForChange.forEach(element -> element.attr(inputNew));

            // сохраняем измененный вид
            PrintWriter writeNewHtml = new PrintWriter("data/change_code");
            writeNewHtml.write(documentForChange.toString());
            writeNewHtml.flush();
            writeNewHtml.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println("Данные сохранены в файле data/change_code");
    }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> stringList = Files.readAllLines(Paths.get(path));
            stringList.forEach(l -> builder.append(l + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

}
