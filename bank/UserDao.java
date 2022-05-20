package com.company;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addEmployee(Users users) throws SQLException;

    void updateEmployee(Accounts accounts) throws SQLException;
    void updateTransfer(Accounts accounts) throws SQLException;
     void ApproveUsers(Accounts accounts) throws SQLException;
    public void login2(Accounts accounts) throws SQLException ;

    void deleteEmployee(int id);
    List<Users> getEmployees() throws SQLException;
    Users getEmployeeById(int id);
    void login(Accounts accounts)throws SQLException;
}
