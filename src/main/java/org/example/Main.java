package org.example;
public class Main {
    public static void main(String[] args) {
        // Register a user
        Login user = new Login(" "," "," "," "," ");

        System.out.println("===Registration===");
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);

        if (registrationMessage.contains(" Registration successful!")){
            boolean isSuccess = user.loginUser();
            System.out.println(user.returnLoginStatus(isSuccess));
        }else{
            System.out.println(" Cannot proceed to login due to registration failure");
        }
    }
}


