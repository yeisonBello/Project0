package com.company;
import java.util.Scanner;
public class Accounts {



    private int AccountNumber=0;
    private Users users;
    private double Balance = 0.0;

    private String name;
    private String password;
    private double Transfer;
    private String TransferId;
    private double PendingToAccept;
    private String password2;


    public Accounts() {
    }

    public String getTransferId() {
        return TransferId;
    }

    public void setTransferId(String transferId) {
        TransferId = transferId;
    }
    public double getTransfer() {
        return Transfer;
    }

    public void setTransfer(double transfer) {
        Transfer = transfer;
    }




    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public Users getEmployee() {
        return users;
    }

    public void setEmployee(Users users) {
        this.users = users;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String toString() {

        return "\nAccount Number: " + this.getAccountNumber() +
                "\nCustormer : " + this.users.getName() +
                "\nEmail: " + this.users.getEmail();

    }

    public void Deposite(double valor) {
        if (valor > 0) {
            setBalance(getBalance() + valor);

            System.out.println("YOUR DEPOSIT WAS SUCCESSFULLY MADE");
        } else {
            System.out.println("THE DEPOSIT COULD NOT BE MADE!");
        }
    }

    public void WithDrawl(double valor) {
        if (valor > 0 && this.getBalance() >= valor) {
            setBalance(getBalance() - valor);
            System.out.println("successful withdrawal");
        } else {
            System.out.println("insufficient balance");
        }
    }

    public void transfer( double valor,String X1) {
        if (valor > 0 && this.getBalance() >= valor) {
            setBalance(getBalance() - valor);
            setTransfer(valor);
            setTransferId(X1);






            System.out.println("the transfer will be complete once the recipient accepts the transfer");
        } else {
            System.out.println("INSUFFICIENT FUNDS");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void AccountScreen() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("********************************");
            System.out.println("        CUSTOMER MENU           ");
            System.out.println("********************************");
            System.out.println("PRESS 1: BALANCE");
            System.out.println("PRESS 2: WITHDRAWALS");
            System.out.println("PRESS 3: DEPOSIT");
            System.out.println("PRESS 4: TRANSFER");
            System.out.println("PRESS 5: ACCEPT TRANSFERS");
            System.out.println("PRESS 6: LOGIN OUT      ");
            System.out.println("********************************");
            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    // add
                    System.out.println("*****************************************");
                    System.out.println("               BALANCE                   ");
                    System.out.println("*****************************************");
                    System.out.println("YOUR BALANCE IS :" + Balance);
                    System.out.println("YOUR ACCOUNT NUMBER IS :" + AccountNumber);
                    System.out.println("*****************************************");
                    System.out.println("PRESS 1: TO RETURN TO CUSTOMER MENU");
                    String back= scanner.next();

                     // recuerda el flujo ITS IMPORTAN !!
                    break;
        }
                case 2: {

                    System.out.println("*****************************************");
                    System.out.println("               WITHDRAWL                  ");
                    System.out.println("*****************************************");
                    System.out.println("YOUR BALANCE IS :" + Balance);
                    System.out.println("TYPE HOW MUCH WOULD YOU LIKE TO TAKE?");
                    System.out.println("*****************************************");
                    Double x= scanner.nextDouble();
                    WithDrawl(x);
                    System.out.println("YOUR BALANCE IS :" + Balance);
                    System.out.println("*****************************************");
                    System.out.println("PRESS 1: TO RETURN TO CUSTOMER MENU");
                    String back= scanner.next();

                    // recuerda el flujo ITS IMPORTAN !!
                    break;

                }case 3: {
                    System.out.println("*****************************************");
                    System.out.println("               DEPOSIT                   ");
                    System.out.println("*****************************************");
                    System.out.println("TYPE HOW MUCH WOULD YOU LIKE TO DEPOSIT?");
                    Double x= scanner.nextDouble();
                    Deposite(x);
                    System.out.println("YOUR BALANCE IS :" + Balance);
                    System.out.println("*****************************************");
                    System.out.println("PRESS 1: TO RETURN TO CUSTOMER MENU");
                    int back= scanner.nextInt();
                    if(back<0){flag=false;}
                    // recuerda el flujo ITS IMPORTAN !!
                    break;



                }
                case 4: {
                    System.out.println("*****************************************");
                    System.out.println("               TRANSFER                  ");
                    System.out.println("*****************************************");
                    System.out.println("TYPE HOW MUCH WOULD YOU LIKE TO TRANSFER?");
                    System.out.println("*****************************************");
                    Double x= scanner.nextDouble();
                    System.out.println("RECIPIENT ACCOUNT NUMBER");
                    System.out.println("*****************************************");
                    String y= scanner.next();
                    transfer( x,y);
                    System.out.println("PRESS 1: TO RETURN TO CUSTOMER MENU");
                    int back= scanner.nextInt();
                    if(back<0){flag=false;}
                    // recuerda el flujo ITS IMPORTAN !!
                    break;

                } case 5: {
                    System.out.println("*****************************************");
                    System.out.println("            ACCEPT TRANSACTIONS          ");
                    System.out.println("*****************************************");
                    if(PendingToAccept>0){
                        System.out.println("SOMEONE HAS TRANSFERRED MONEY TO YOUR ACCOUNT");
                    }else{
                        System.out.println("    YOU HAVE NOT RECEIVED MONEY!");
                        System.out.println("PRESS ANY KEY TO COME BACK ");
                        System.out.println("*****************************************");
                        String x= scanner.next();



                    break;}
                    System.out.println("PRESS 1: TO ACCEPT");
                    System.out.println("PRESS 2: TO DECLINE");
                    System.out.println("*****************************************");
                    int x= scanner.nextInt();
                    if (x == 1){
                        double temp =getPendingToAccept();
                        Balance = Balance +getPendingToAccept();
                        PendingToAccept=0;
                        setTransferId(String.valueOf(AccountNumber));
                        setTransfer(0);
                        System.out.println( "YOU RECEIVED $"+ temp);



                    }else{
                        break;
                    }
                }
                case 6: {
                    return;
                }
    }}}

    public double getPendingToAccept() {
        return PendingToAccept;
    }

    public void setPendingToAccept(double pendingToAccept) {
        PendingToAccept = pendingToAccept;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}

