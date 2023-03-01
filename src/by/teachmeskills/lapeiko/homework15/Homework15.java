package by.teachmeskills.lapeiko.homework15;

import by.teachmeskills.lapeiko.homework15.task1.BlrPassport;
import by.teachmeskills.lapeiko.homework15.task1.Gender;
import by.teachmeskills.lapeiko.homework15.task2.TextBlackListFilter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Homework15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                """
                        Choose task:
                        1. Belarusian passport
                        2. Black words filter
                        0. Exit"""
        );
        while (true) {
            System.out.print("Task number: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());
            switch (taskNumber) {
                case 1 -> {
                    System.out.print("Write your first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Write your last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Write your gender (MALE of FEMALE): ");
                    Gender gender = Gender.valueOf(scanner.nextLine());
                    System.out.print("Write your date of birth (dd.MM.yyyy): ");
                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    System.out.print("Write your passport number: ");
                    String passportNumber = scanner.nextLine();
                    System.out.print("Write your ID number of passport: ");
                    String idNumber = scanner.nextLine();
                    System.out.print("Write your date of issue of passport (dd.MM.yyyy): ");
                    LocalDate dateOfIssue = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    System.out.print("Write your validity of passport (dd.MM.yyyy): ");
                    LocalDate validityOfPassport = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    BlrPassport blrPassport = new BlrPassport(firstName, lastName, gender, dateOfBirth, passportNumber,
                            idNumber, dateOfIssue, validityOfPassport);
                    System.out.println(blrPassport);
                    System.out.println("Is your passport expired: " + blrPassport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk"))));
                }
                case 2 -> {
                    System.out.print("Write bad words or phrase: ");
                    String[] arrayOfBadWords = scanner.nextLine().trim().split("\\s*,\\s*");
                    TextBlackListFilter listFilter = new TextBlackListFilter(arrayOfBadWords);
                    System.out.println("Write your text which you want to work:");
                    String line = scanner.nextLine();
                    System.out.println("Is your words or phrase contain bad words? " +
                            listFilter.isContainBadWords(line));
                    System.out.println("How many bad words in your line? " +
                            listFilter.counterForBadWords(line));
                    System.out.println("Your modificated line: " +
                            listFilter.modificatedBadWords(line));
                }
                case 0 -> {
                    return;
                }
                default -> System.err.println("Task doesn't exist");
            }
            System.out.println();
        }
    }
}
