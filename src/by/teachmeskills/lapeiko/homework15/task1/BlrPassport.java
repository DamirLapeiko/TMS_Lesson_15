package by.teachmeskills.lapeiko.homework15.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BlrPassport {
    private static final int PASSPORT_NUMBER = 9;
    private static final int ID_NUMBER_OF_PASSPORT = 14;
    private final String lastName;
    private final String firstName;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final String passportNumber;
    private final String idNumberOfPassport;
    private final LocalDate dateOfIssue;
    private final LocalDate validityOfPassport;

    public BlrPassport(String lastName, String firstName, Gender gender,
                       LocalDate dateOfBirth, String passportNumber, String idNumberOfPassport,
                       LocalDate dateOfIssue, LocalDate validityOfPassport) {
        if (isValidPassport(firstName, lastName, passportNumber, idNumberOfPassport,
                dateOfIssue, validityOfPassport)) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.passportNumber = passportNumber;
            this.idNumberOfPassport = idNumberOfPassport;
            this.dateOfIssue = dateOfIssue;
            this.validityOfPassport = validityOfPassport;
        } else {
            throw new IllegalArgumentException("Incorrect data");
        }
    }

    public boolean isValidNumberOfPassport(String passportNumber) {
        if (passportNumber.length() != PASSPORT_NUMBER) {
            throw new IllegalArgumentException("Inadmissible size of number passport. Should be 9 signs.");
        }
        return passportNumber.matches("(AB|BM|HB|KH|MP|MC|KB|PP|SP|DP)\\d{7}");
    }

    public boolean isValidIDNumberOfPassport(String idNumberOfPassport) {
        if (idNumberOfPassport.length() != ID_NUMBER_OF_PASSPORT) {
            throw new IllegalArgumentException("Inadmissible size of ID number of passport. Should be 14 signs.");
        }
        return idNumberOfPassport.matches("\\d{7}[ABCKEMH](\\d{3})(PB|BA|BI)\\d");
    }

    public boolean isBeforeDateOfIssue(LocalDate dateOfIssue, LocalDate validityOfPassport) {
        return dateOfIssue.isBefore(validityOfPassport);
    }

    public boolean isExpired(LocalDate now) {
        return validityOfPassport.isAfter(now);
    }

    public boolean isCorrectFirstNameAndLastName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Verify your name.");
        }
        return firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+");
    }

    public boolean isValidPassport(String firstName, String lastName, String passportNumber,
                                   String idNumberOfPassport, LocalDate dateOfIssue, LocalDate validityOfPassport) {
        return isCorrectFirstNameAndLastName(firstName, lastName) &&
                isValidNumberOfPassport(passportNumber) &&
                isValidIDNumberOfPassport(idNumberOfPassport) &&
                isBeforeDateOfIssue(dateOfIssue, validityOfPassport);
    }

    @Override
    public String toString() {
        return "Belarusian passport:\n" +
                "First name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Gender: " + gender + "\n" +
                "Date of birth: " + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n" +
                "Passport number: " + passportNumber + "\n" +
                "ID number of passport: " + idNumberOfPassport + "\n" +
                "Validity of passport: from " + dateOfIssue.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                " to " + validityOfPassport.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}


