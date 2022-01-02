package com.ede.client.entity;

import java.util.ArrayList;

public class Department {
    long id; // cчетчик
    String information; // длинный текст
    int countOfEmployees; // числовой
    ArrayList<Employee> employees; // связь в бд, айди и фио

    public Department(String information, int countOfEmployees, ArrayList<Employee> employees) {
        this.information = information;
        this.countOfEmployees = countOfEmployees;
        this.employees = employees;
    }

    public Department(long id, String information, int countOfEmployees) {
        this.id = id;
        this.information = information;
        this.countOfEmployees = countOfEmployees;
    }

    @Override
    public String toString() {
        return information;
    }

    public Department(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Department(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getCountOfEmployees() {
        return countOfEmployees;
    }

    public void setCountOfEmployees(int countOfEmployees) {
        this.countOfEmployees = countOfEmployees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
