package com.company;

public class UserDaoFactory {
    public static UserDao dao;

    private UserDaoFactory() {
    }

    public static UserDao getEmployeeDao() {
        if (dao == null)
            dao = new UserDaoImpl();
        return dao;
    }
}