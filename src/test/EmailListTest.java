package test;

import Lesson_42_Homework_22_06.EmailList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmailListTest {
    private EmailList emailList;
    @Before
    public void setUp() {
        emailList = new EmailList();
    }
    @Test
    public void testAddValidEmail() {
        String validEmail = "hello@yandex.ru";
        emailList.add(validEmail);
        assertEquals(List.of(validEmail), emailList.getSortedEmails());
    }
    @Test
    public void testAddNotValidEmailWithoutAt() {
        String notValidEmail = "hello_yandex.ru";
        emailList.add(notValidEmail);
        assertEquals(List.of(), emailList.getSortedEmails());
    }
    @Test
    public void testAddNotValidEmailWithoutDomainDot() {
        String notValidEmail = "hello@yandexru";
        emailList.add(notValidEmail);
        assertEquals(List.of(), emailList.getSortedEmails());
    }
    @Test
    public void testAddDuplicateValidEmail() {
        String validEmail = "hello@yandex.ru";
        String validDuplicateEmail = "HELLO@yandex.ru";
        emailList.add(validEmail);
        emailList.add(validDuplicateEmail);
        assertEquals(List.of(validEmail), emailList.getSortedEmails());
    }
    @Test
    public void testSortedEmails() {
        String firstEmail = "hello@yandex.ru";
        String secondEmail = "asgard@yggdrasil.com";
        String thirdEmail = "hello@mail.ru";
        emailList.add(firstEmail);
        emailList.add(secondEmail);
        emailList.add(thirdEmail);
        assertEquals(List.of(secondEmail, thirdEmail, firstEmail), emailList.getSortedEmails());
    }
}
