package com.danny.controller;

import java.sql.*;

/**
 * Created by Danny on 12/11/2016.
 */
public class BaseController {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public BaseController() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_calificacion", "root", "");
        statement = connection.createStatement();
    }
}
