package org.example;
import java.util.Scanner;
public class Login {
 // Attributes
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellNumber;
// Constructor
public Login(String firstName, String lastName, String username, String password, String cellNumber){
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.cellNumber = cellNumber;
}
// Getter and Setter
public String getUsername(){
    return username;
    }
public String getPassword(){
    return password;
    }
public String getCellNumber(){
    return cellNumber;
    }
public String getFirstName(){
    return firstName;
    }
public String getLastName(){
    return lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //checkUserName
    public boolean checkUserName(){
       return username.contains("_")&& username.length() <= 5;

    }
    // checkPasswordComplexity
    public boolean checkPasswordComplexity(){
       return password.length() >= 8 &&
            password.matches(".*[A-Z].*")&&
            password.matches(".*[a-z].*")&&
            password.matches(".*[0-9].*")&&
            password.matches(".*[!@#$%^&*()].*");

    }
    //checkCellNumber
    public boolean checkCellNumber(){
       return cellNumber.matches("\\+27\\d{9}");
    }

    // registerUser
    public String registerUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        setFirstName(scanner.nextLine());

        System.out.print("Enter last name: ");
        setLastName(scanner.nextLine());

        System.out.print("Enter cell number (e.g., +27XXXXXXXXX): ");
        setCellNumber(scanner.nextLine());

        System.out.print("Enter username:");
        setUsername(scanner.nextLine());

        System.out.print("Enter password:");
        setPassword(scanner.nextLine());

        if (!checkUserName()) {
            return " Invalid username. Must contain an underscore(_) and be no more that 5 characters";
        }else if (!checkPasswordComplexity()){
            return "Weak password. Must include uppercase, lowercase, number, and special character";
        }else if (!checkCellNumber()) {
            return " Invalid South African cell number. ";
        } else{
            return " Registration successful!";
        }
    }
    // loginUser
    public boolean loginUser(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print(" Enter password: ");
        String inputPassword = scanner.nextLine();

        return inputUsername.equals(username)&&inputPassword.equals(password);
    }
    // returnLoginStatus
    public String returnLoginStatus(boolean loginSuccess){
        if (loginSuccess){
            return " Login successful. Welcome, " + firstName + " " + lastName + "!";
        }else{
            return " Login failed. Please check your username and password.";
        }
    }
}