package com.company;


import java.sql.SQLException;
import java.util.Scanner;

public class BankPrototype {

    public static void main(String[] args) throws SQLException {



       UserDao dao = UserDaoFactory.getEmployeeDao();
        Scanner scanner = new Scanner(System.in);


        boolean flag = true;
        while (flag) {
            System.out.println("********************************");
              System.out.println("           BANK               ");
            System.out.println("********************************");
                 System.out.println("PRESS 1: NEW CUSTOMER ");
                 System.out.println("PRESS 2: CUSTOMERS");
                 System.out.println("PRESS 3: EMPLOYEES");
                 System.out.println("PRESS 4: EXIT");
            System.out.println("********************************");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {

                    Users newUsers = new Users();
                    newUsers.UsersScreen();
                    int temp = (int) newUsers.getFirstDeposit();
                    if (temp == 0) {
                        break;
                    }
                    dao.addEmployee(newUsers);//
                    break;
                }
                case 2: {

                        System.out.println("**********************************");
                        System.out.println("            LOGIN               ");
                        System.out.println("**********************************");
                        System.out.print("Enter Name: ");
                        String  name = scanner.next();
                        System.out.println("Enter Password:");
                        String pass = scanner.next();
                        System.out.println("**********************************");

                        Accounts A = new Accounts();
                        A.setName(name);
                        A.setPassword(pass);

                        dao.login(A);
                        if(A.getAccountNumber() == 0){
                            break;}

                        A.AccountScreen();// WITHDRAWL WITHOUT DB UPDATE
                        dao.updateEmployee(A);// withdrawl db update

                        if(A.getTransferId() == null){
                            break;}

                        dao.updateTransfer(A);// TRANFER MONEY ADD TO DE DB PENDING TO APROVAL
                        break;
                }
                case 3: {
                    System.out.println("********************************");
                    System.out.println("        LOGIN EMPLOYEES         ");
                    System.out.println("********************************");
                    System.out.print("Enter Employee Id: ");
                    String  name = scanner.next();
                    System.out.println("Enter Password");
                    String pass = scanner.next();
                    Accounts A = new Accounts();
                    A.setName(name);
                    A.setPassword(pass);
                    dao.login2(A);
                    System.out.println(A.getPassword2());
                    if(A.getPassword2() == null){
                        break;}
                    dao.ApproveUsers(A);// info not in the db yet

                    break;
                }

                case 4: {
                    // exit
                    System.out.println("Thank you");
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("Choose between 1-6");

            }
        }
    }
}