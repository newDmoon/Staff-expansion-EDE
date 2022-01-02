package com.ede.client.impl;

import com.ede.client.configuration.JdbcAccessUtil;
import com.ede.client.dao.DAO;
import com.ede.client.entity.Department;
import com.ede.client.entity.Employee;
import com.sun.prism.impl.paint.PaintUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements DAO<Department> {
    @Override
    public void save(Department obj) {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try {
            PreparedStatement preparedStatement = accessUtil.getCurrentConnection()
                    .prepareStatement("INSERT INTO department (information) " +
                            "VALUES (?)");
            preparedStatement.setString(1,obj.getInformation());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Department> findAll() {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try {
            Statement statement = accessUtil.getCurrentConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCTROW department.ID, department.information, Count(*) AS [Count - employee] " +
                    "FROM department INNER JOIN employee ON department.[ID] = employee.[department]" +
                    " GROUP BY department.ID, department.information");
            List<Department> departmentList = new ArrayList<>();
            while (resultSet.next()){
                departmentList.add(new Department(resultSet.getLong("ID")
                        ,resultSet.getString("information")
                        ,resultSet.getInt("Count - employee")));
            }
            return departmentList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(Department obj) {

    }

    @Override
    public void delete(Department obj) {
        JdbcAccessUtil accessUtil = new JdbcAccessUtil();
        try{
            Statement statement = accessUtil.getCurrentConnection().createStatement();
            statement.executeUpdate("DELETE FROM department WHERE ID = "+obj.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
