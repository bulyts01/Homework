package Lesson_42_Homework_22_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    Set<String> emailSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public void add(String email) {
        if (addDuplicateValidEmail(email.toLowerCase())) {
            String emailPattern = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Aa-z]{2,4}\\b";
            Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email.toLowerCase(Locale.ROOT));

            if (!matcher.matches()) {
                System.out.println("Invalid input email");
            } else {
                emailSet.add(email.toLowerCase());
                System.out.println(email + " is added to List");
            }
        } else {
            System.out.println("This email is listed already");
        }
    }

    public List<String> getSortedEmails() {
        return emailSet.stream().toList();
    }

    public boolean addDuplicateValidEmail(String email) {
        if (!emailSet.contains(email)) {
            return true;
        } else {
            return false;
        }
    }
}
