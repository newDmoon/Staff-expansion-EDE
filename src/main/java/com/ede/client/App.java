package com.ede.client;

import com.ede.client.configuration.JdbcAccessUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Main class of program
 * main method starting with connection to database
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try(Connection connection = accessUtil.getCurrentConnection()){
            System.out.println("connection successfully");
            Main.main(args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
