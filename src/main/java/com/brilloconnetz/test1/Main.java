package com.brilloconnetz.test1;

import java.util.Scanner;

import static com.brilloconnetz.test1.JwtUtil.generateJwtToken;
import static com.brilloconnetz.test1.JwtUtil.verifyJwtToken;
import static com.brilloconnetz.test1.UserInputValidator.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("Welcome to my User Input Validation Application");
        System.out.println("***********************************************");

        System.out.print("Enter username : ");
        String username = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("\n");

        StringBuilder validationErrors = new StringBuilder();

        validateUsername(username, validationErrors);
        validateEmail(email, validationErrors);
        validatePassword(password, validationErrors);
        validateDateOfBirth(dateOfBirth, validationErrors);

        if (validationErrors.isEmpty()) {
            System.out.println("True");
            String jwt = generateJwtToken(username, email, password);
            System.out.println("All inputs are valid.");
            System.out.println("Generated JWT: " + jwt);

            String verificationResult = verifyJwtToken(jwt, username,email, password);
            System.out.println("Verification Result: " + verificationResult);
        } else {
            System.out.println("Invalid Detail(s) Entered");
            System.out.println("-------------------------");
            System.out.println(validationErrors);

        }
        scanner.close();

    }
}