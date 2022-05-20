package com.company;

import java.util.Scanner;

public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private double FirstDeposit;

    public Users() {
    }

    public Users(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getFirstDeposit() {
        return FirstDeposit;
    }

    public void setFirstDeposit(double firstDeposit) {
        FirstDeposit = firstDeposit;
    }


    public String toString() {
        return "Name: " + name + "\n" + "Email: " + email + "\n" + "ID: " + id + "\n" + "Passcode: " + password;
    }
    public void UsersAdminScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("*************************************");
            System.out.println("        EMPLOYEES MENU               ");
            System.out.println("*************************************");
            System.out.println("PRESS 1: ACCOUNT PENDING TO APPROVE ");//este se actualiza directo en la base de datos
            System.out.println("PRESS 2: VIEW CUSTOMER ACCOUNT INFO ");
            System.out.println("PRESS 3: VIEW REGISTER OF TRANSACTION");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("***********************************************************");
                    System.out.println("             ACCOUNTS PENDING TO APPROVING      ");
                    System.out.println("***********************************************************");

                    flag = false;
                   break;
                }
                case 2:{
                    System.out.println("***********************************************************");
                    System.out.println("             CUSTOMER ACCOUNTS INFORMATION      ");
                    System.out.println("***********************************************************");

                }







    }}}

    public void UsersScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("********************************");
            System.out.println("        NEW CUSTOMER MENU       ");
            System.out.println("********************************");
            System.out.println("PRESS 1: OPEN A NEW ACCOUNT ");
            System.out.println("PRESS 2: MAIN MENU ");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("***************************************************");
                    System.out.println("              OPENING ACCOUNT                     ");
                    System.out.println("**************************************************");
                    System.out.print("Enter Name: ");
                    Users.this.name = scanner.next();
                    System.out.print("Enter Email: ");
                    Users.this.email = scanner.next();
                    System.out.print("Enter New password: ");
                    Users.this.password = scanner.next();
                    System.out.println("MAKE A FIRST DEPOSIT TO OPEN YOUR ACCOUNT");
                    Users.this.FirstDeposit = Double.parseDouble(scanner.next());
                    System.out.println("GO TO CUSTOMERS MENU IF YOUR ACCOUNT WAS APPROVED");
                    System.out.println("       YOU WILL BE ABLE TO LOGGIN IN  ");
                    System.out.println("*************************************************");
                    System.out.println("PRESS 1: TO RETURN TO MAIN MENU");
                    int back = scanner.nextInt();
                    if (back > 0) {
                        flag = false;
                    }

                    break;
                }
                case 2: {
                    flag = false;
                }


            }
        }
    }

}