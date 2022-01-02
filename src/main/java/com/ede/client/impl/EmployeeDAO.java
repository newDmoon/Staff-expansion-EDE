package com.ede.client.impl;

import com.ede.client.configuration.JdbcAccessUtil;
import com.ede.client.dao.DAO;
import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements DAO<Employee> {

    @Override
    public void save(Employee obj) {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try {
            PreparedStatement preparedStatement = accessUtil.getCurrentConnection()
                    .prepareStatement("INSERT INTO employee (birthDate, phoneNumber, fio, advantages, isExperienced,salary,department) " +
                            "VALUES (?, ?, ?,?,?,?,?)");
            preparedStatement.setDate(1, obj.getBirthDate());
            preparedStatement.setString(2,obj.getPhoneNumber());
            preparedStatement.setString(3,obj.getFio());
            preparedStatement.setString(4,obj.getAdvantages());
            preparedStatement.setBoolean(5,obj.isExperienced());
            preparedStatement.setInt(6,obj.getSalary());
            preparedStatement.setLong(7,obj.getDepartment().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
            try {
                Statement statement = accessUtil.getCurrentConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
                List<Employee> employees = new ArrayList<>();
                while (resultSet.next()){
//                    System.out.println(resultSet.getObject("department"));
                    employees.add(new Employee(resultSet.getLong("ID")
                            ,resultSet.getDate("birthDate")
                            ,resultSet.getString("phoneNumber")
                            ,resultSet.getString("fio")
                            ,resultSet.getString("advantages")
                            ,resultSet.getBoolean("isExperienced")
                            ,resultSet.getInt("salary")
                            ,resultSet.getLong("department")));
                }
                statement.close();
                return employees;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return null;
    }

    @Override
    public void update(Employee obj) {

    }

    @Override
    public void delete(Employee obj) {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try{
            Statement statement = accessUtil.getCurrentConnection().createStatement();
            statement.executeUpdate("DELETE FROM employee WHERE ID = "+obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
