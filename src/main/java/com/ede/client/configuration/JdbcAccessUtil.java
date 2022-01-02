package com.ede.client.configuration;

import com.ede.client.configuration.prop.ConfigDb;

import java.sql.*;

/**
 * Class JdbcAccessUtil created for implementation interface AccessDb.
 * @author WalkCat
 * @version 0.1
 * */
public class JdbcAccessUtil implements AccessDb{



    /*
    * code for newDmoon to creat DAO classes
    * */
//    public static void main(String[] args) {
//
//
//        try (Connection connection = DriverManager.getConnection(configDb.getUrl())) {
//
//            Calendar calendar = Calendar.getInstance();
//
//            String sql = "INSERT INTO employee (fullName, age, salary,birth,phoneNumber) VALUES (?, ?, ?,?,?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "Jim Rohn");
//            preparedStatement.setInt(2, 25);
//            preparedStatement.setInt(3, 1000);
//            preparedStatement.setDate(4, new Date(calendar.getTimeInMillis()));
//            preparedStatement.setString(5, "3752936455");
//
//            int row = preparedStatement.executeUpdate();
//
//            if (row > 0) {
//                System.out.println("A row has been inserted successfully.");
//            }
//
//            sql = "SELECT * FROM employee";
//
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(sql);
//
//            while (result.next()) {
//                int id = result.getInt("ID");
//                String fullname = result.getString("fullName");
//                Integer email = result.getInt("age");
//
//                System.out.println(id + ", " + fullname + ", " + email);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


    /**
     * Override method which return current connection.
     * @return Connection
     * @throws SQLException
     * */
    @Override
    public Connection getCurrentConnection() throws SQLException {
        ConfigDb configDb = ConfigDb.getInstance();
        return DriverManager.getConnection(configDb.getUrl());
    }
}
