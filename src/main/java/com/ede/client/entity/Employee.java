package com.ede.client.entity;

import java.util.Date;

public class Employee {
    long id; // счетчик
    Date birthDate; // дата
    String phoneNumber; // короткий текст
    String fio; // короткий текст
    String advantages; // длинный текст
    boolean isExperienced; // логический
    int salary; // числовой
    Department department; // связь в бд, только айди

    public Employee(Date birthDate, String phoneNumber, String fio, String advantages, boolean isExperienced, int salary, Department department) {
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.fio = fio;
        this.advantages = advantages;
        this.isExperienced = isExperienced;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fio='" + fio + '\'' +
                ", advantages='" + advantages + '\'' +
                ", isExperienced=" + isExperienced +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public void setExperienced(boolean experienced) {
        isExperienced = experienced;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFio() {
        return fio;
    }

    public String getAdvantages() {
        return advantages;
    }

    public boolean isExperienced() {
        return isExperienced;
    }

    public int getSalary() {
        return salary;
    }


}
