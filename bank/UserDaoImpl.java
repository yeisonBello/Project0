package com.company;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {
    Connection connection;

    public UserDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Users users) throws SQLException {
        String sql = "insert into employees (name, email, password,FirstDeposit) values (?, ?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, users.getName());
        preparedStatement.setString(2, users.getEmail());
        preparedStatement.setString(3, users.getPassword());
        preparedStatement.setString(4, String.valueOf(users.getFirstDeposit()));

        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("customer saved");
        else
            System.out.println("Oops! something went wrong");
    }




    @Override

    public void login(Accounts accounts) throws SQLException {
        //revisar porque hay parentesis en preparedstatement

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from employees where name=? and password=? and FirstDeposit is NULL");
        preparedStatement.setString(1, accounts.getName());
        preparedStatement.setString(2, accounts.getPassword());


        ResultSet rs = preparedStatement.executeQuery();

        //no pude ejecutar el result set sin el .next  , why ?


        if(rs.next()) {
            System.out.println("     Welcome " + rs.getString("name"));
            accounts.setAccountNumber(Integer.parseInt(rs.getString("id")));
            accounts.setBalance(Double.parseDouble(rs.getString("balance")));
            accounts.setPendingToAccept(Double.parseDouble(rs.getString("TranferMoney")));
        }else{
            System.out.println("Username or password not found ");
            System.out.println("         Try again. ");
            System.out.println("**********************************");
            System.out.println("New user: Account pending approval");
        }


    }
    @Override
    public void login2(Accounts accounts) throws SQLException {

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from employees3 where id=? ");
        preparedStatement.setString(1, accounts.getName());


        ResultSet rs = preparedStatement.executeQuery();

        //no pude ejecutar el result set sin el .next  , why ?


        if(rs.next()) {
            System.out.println("     Welcome " + rs.getString("id"));
            accounts.setPassword2(rs.getString("password"));
        } else{
        System.out.println("Username or password not found ");


    }}
    //// los objetos que toma el metodo son los permitidos en el cuerpo
    @Override
    public void updateEmployee(Accounts accounts) throws SQLException {
        PreparedStatement preparedStatement =  connection.prepareStatement("update employees set balance =? where id =?;");
        preparedStatement.setString(1, String.valueOf(accounts.getBalance()));
        preparedStatement.setString(2, String.valueOf(accounts.getAccountNumber()));

        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("CHANGES SAVED IN THE DB");
        else
            System.out.println("Oops! something went wrong");
    }
    @Override
    public void updateTransfer(Accounts accounts) throws SQLException{
        PreparedStatement preparedStatement =  connection.prepareStatement("update employees set TranferMoney =? where id =?;");
        preparedStatement.setString(1, String.valueOf(accounts.getTransfer()));
        preparedStatement.setString(2, String.valueOf(accounts.getTransferId()));
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Transfers information saved ");
        else
            System.out.println("Oops! something went wrong");


        PreparedStatement preparedStatement2 =  connection.prepareStatement("insert into transaction (id, out_id , transaction) values ( ?,?,?)");
        preparedStatement2.setString(1, String.valueOf(accounts.getAccountNumber()));
        preparedStatement2.setString(2, String.valueOf(accounts.getTransferId()));
        preparedStatement2.setString(3, String.valueOf(accounts.getTransfer()));
        int count2 = preparedStatement2.executeUpdate();
        if(count2 > 0)
            System.out.println("Transfers information saved in employee DB ");
        else
            System.out.println("something went wrong saving info in the employee DB");

    }
    @Override//el query show fistdeposit
    public void ApproveUsers(Accounts accounts) throws SQLException{
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("*************************************");
            System.out.println("        EMPLOYEES MENU               ");
            System.out.println("*************************************");
            System.out.println("PRESS 1: ACCOUNT PENDING TO APPROVE ");//este se actualiza directo en la base de datos
            System.out.println("PRESS 2: VIEW CUSTOMER ACCOUNT INFO ");
            System.out.println("PRESS 3: VIEW CUSTOMER TRANSACTION  ");
            System.out.println("PRESS 4: LOGIN OUT");
            System.out.println("********************************");

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("***********************************************************");
                    System.out.println("             ACCOUNTS PENDING TO APPROVING      ");
                    System.out.println("***********************************************************");
                    boolean flag2 = true;
                    while (flag2) {
                        System.out.println("***********************************************************");
                        System.out.println("             PRESS 1:TO APPROVE AN ACCOUNT");
                        System.out.println("             PRESS 2: TO COME BACK ");
                        PreparedStatement preparedStatement3 = (PreparedStatement) connection.prepareStatement("select * from employees where FirstDeposit >0");
                        ResultSet rs3 = preparedStatement3.executeQuery();

                      //  if(int temp=scanner.nextInt()){return;};
                        while(rs3.next()) {

                            System.out.println( "Id :"+rs3.getString("id")+"|| Name: "+rs3.getString("name")+"|| Email: "+ rs3.getString("email")+"|| FirstDeposit: "+rs3.getString("FirstDeposit"));
                        }
                        System.out.println("***********************************************************");
                        int input2 = scanner.nextInt();
                        switch (input2) {
                            case 1: {
                                System.out.println("***********************************************************");
                                System.out.println( "ENTER ID OF THE ACCOUNT:");

                                String tempId = scanner.next();

                                PreparedStatement preparedStatement2 =   connection.prepareStatement(" update employees set balance = FirstDeposit, FirstDeposit = NULL where id =?;");
                                preparedStatement2.setString(1, tempId );
                                int count = preparedStatement2.executeUpdate();
                                if(count > 0)
                                    System.out.println("ACCOUNT APPROVED ");
                                else
                                    System.out.println("Oops! something went wrong");


                                break;
                            }case 2: {
                                flag2 = false;
                                break;



                            }}}}

                //case 2: {
                  //  System.out.println("***********************************************************");
                    //System.out.println("                CUSTOMER INFORMATION ");
                    //System.out.println("***********************************************************");

                    //Statement statement =  connection.createStatement();
                    //ResultSet resultSet =  statement.executeQuery("select * from employees ");
                    //while(resultSet.next()){
                     //   System.out.println( "Id :"+resultSet.getString("id")+"|| Name: "+resultSet.getString("name")+"|| Email: "+ resultSet.getString("email")+"|| FirstDeposit: "+resultSet.getString("FirstDeposit"));
                    //}
                    //System.out.println("      TYPE ANY KEY TO COME BACK ");
                    //scanner.next();
                    //break;}

                // case 7: {
                  //  System.out.println("***********************************************************");
                    //System.out.println("                VIEW REGISTER OF TRANSACTION ");
                    //System.out.println("***********************************************************");
                   // break;


                 case 4: {
                    return;
                }
                case 2: {
                    System.out.println("***********************************************************");
                    System.out.println("                CUSTOMER INFORMATION ");
                    System.out.println("***********************************************************");

                    Statement statement =  connection.createStatement();
                    ResultSet resultSet =  statement.executeQuery("select * from employees ");
                    while(resultSet.next()){
                        System.out.println( "Id :"+resultSet.getString("id")+"|| Name: "+resultSet.getString("name")+"|| Email: "+ resultSet.getString("email")+"|| FirstDeposit: "+resultSet.getString("FirstDeposit"));
                    }
                    System.out.println("      TYPE ANY KEY TO COME BACK ");
                    scanner.next();
                    break;}

                case 3:{
                    System.out.println("***********************************************************");
                    System.out.println("                CUSTOMER TRANSACTION INFORMATION ");
                    System.out.println("***********************************************************");
                    Statement statement =  connection.createStatement();
                    ResultSet resultSet =  statement.executeQuery("select * from transaction ");
                    while(resultSet.next()){
                        System.out.println( "FROM :"+resultSet.getString("id")+"|| TO: "+resultSet.getString("out_id")+"|| AMOUNT: "+ resultSet.getString("transaction")+"|| DATE: "+resultSet.getString("logindate"));
                    }
                    System.out.println("      TYPE ANY KEY TO COME BACK ");
                    scanner.next();
                    break;}

                }



            }}


    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public List<Users> getEmployees()  {
        return null;
    }

    @Override
    public Users getEmployeeById(int id) {
        return null;
    }
}

