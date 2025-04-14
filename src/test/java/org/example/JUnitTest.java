package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitTest {

    private void simulateInput(String input) {
        InputStream testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);
    }
    // Username Validation
    @Test
    public void testValidUsernameFormat() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        assertTrue(user.checkUserName());
    }
    @Test
    public void testUsernameMissingUnderscore() {
        Login user = new Login("Morais", "Adao", "Adao", "Pass123@", "+27822373960");
        assertFalse(user.checkUserName());
    }
    @Test
    public void testUsernameExceedsCharacterLimit() {
        Login user = new Login("Morais", "Adao", "Ad_ao12", "Pass123@", "+27822373960");
        assertFalse(user.checkUserName());
    }
    // Password Validation
    @Test
    public void testStrongPassword() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testWeakPasswordFailsValidation() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "password", "+27822373960");
        assertFalse(user.checkPasswordComplexity());
    }
    // cellNumber Format
    @Test
    public void testValidSouthAfricanNumber() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        assertTrue(user.checkCellNumber());
    }

    @Test
    public void testInvalidPhoneNumberFailsCheck() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "082123");
        assertFalse(user.checkCellNumber());
    }

    // Registration
    @Test
    public void testUserCanRegisterSuccessfully() {
        String inputSequence = String.join("\n",
                "Morais",            // First name
                "Adao",              // Last name
                "+27822373960",      // Cell number
                "Ad_ao",             // Username
                "Pass123@"           // Password
        ) + "\n";

        simulateInput(inputSequence);

        Login user = new Login("", "", "", "", "");
        String response = user.registerUser();
        assertEquals(" Registration successful!", response);
    }

    // Login Functionality
    @Test
    public void testLoginWithCorrectDetails() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        simulateInput("Ad_ao\nPass123@\n");
        assertTrue(user.loginUser());
    }

    @Test
    public void testLoginFailsWithIncorrectCredentials() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        simulateInput("wrong\nwrongpass\n");
        assertFalse(user.loginUser());
    }

    // Login Status Feedback
    @Test
    public void testLoginSuccessMessage() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        String message = user.returnLoginStatus(true);
        assertEquals(" Login successful. Welcome, Morais Adao!", message);
    }

    @Test
    public void testLoginFailureMessage() {
        Login user = new Login("Morais", "Adao", "Ad_ao", "Pass123@", "+27822373960");
        String message = user.returnLoginStatus(false);
        assertEquals(" Login failed. Please check your username and password.", message);
    }
}

