package com.brilloconnetz.test1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class UserInputValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*\\d).{8,}$");


    public static void validateUsername(String username, StringBuilder errors) {
        if (username == null || username.isEmpty()) {
            errors.append("Username: must not be empty\n");
        } else if (username.length() < 4) {
            errors.append("Username: minimum of 4 characters required\n");
        }
    }

    public static void validateEmail(String email, StringBuilder errors) {
        if (email == null || email.isEmpty()) {
            errors.append("Email: must not be empty\n");
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            errors.append("Email: valid email address required\n");
        }
    }

    public static void validatePassword(String password, StringBuilder errors) {
        if (password == null || password.isEmpty()) {
            errors.append("Password: must not be empty\n");
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            errors.append("Password: strong password with at least 1 upper case, 1 special character (!@#$%^&*)," +
                    " 1 number, and must be minimum of 8 characters\n");
        }
    }

    public static void validateDateOfBirth(String dateOfBirth, StringBuilder errors) {
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            errors.append("Date of Birth: must not be empty\n");
        } else {
            try {
                LocalDate checkedDateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
                if (Period.between(checkedDateOfBirth, LocalDate.now()).getYears() < 16) {
                    errors.append("Date of Birth: should be 16 years or greater\n");
                }
            } catch (DateTimeParseException e) {
                errors.append("Date of Birth: invalid date format (yyyy-MM-dd)\n");
            }
        }

    }

}
