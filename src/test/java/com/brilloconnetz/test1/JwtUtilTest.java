package com.brilloconnetz.test1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    private static String validJwt;
    private static String invalidJwt;

    @BeforeAll
    public static void setup() {

        validJwt = JwtUtil.generateJwtToken("maxi", "max@gmail.com", "Maxexample@84");
        invalidJwt = "invalidToken.forTesting.myApplication";

    }

    @Test
    public void testValidJwtVerification() {
        String verificationResult = JwtUtil.verifyJwtToken(validJwt, "maxi", "max@gmail.com", "Maxexample@84");
        assertEquals("Verification pass", verificationResult);
    }

    @Test
    public void testInvalidJwtVerification() {
        String verificationResult = JwtUtil.verifyJwtToken(invalidJwt, "maxi", "max@gmail.com", "Maxexample@84");
        assertEquals("Verification fails", verificationResult);
    }

}