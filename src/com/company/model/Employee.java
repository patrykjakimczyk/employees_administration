package com.company.model;

import java.math.BigDecimal;

public class Employee {
    protected String pesel;
    protected String name;
    protected String lastName;
    protected String job;
    protected BigDecimal salary;
    protected String phoneNumber;

    public Employee() {
        this.pesel = "00000000000";
        this.name = "";
        this.lastName = "";
        this.job = "";
        this.salary = new BigDecimal("0");
        this.phoneNumber = "";
    }

    public Employee(String pesel, String name, String lastName, String job, BigDecimal salary, String phoneNumber) {
        this.pesel = pesel;
        this.name = name;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public String getPesel() {
        return this.pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void removingView() {
        System.out.println("Imię: " + this.name);
        System.out.println("Nazwisko: " + this.lastName);
        System.out.println("Stanowisko: " + this.job);
        System.out.println("Wynagrodzenie: " + this.salary);
        System.out.println("Telefon służbowy: " + this.phoneNumber);
    }

    public void listView() {
        System.out.println("Identyfikator pesel: " + this.pesel);
        System.out.println("Imię: " + this.name);
        System.out.println("Nazwisko: " + this.lastName);
        System.out.println("Stanowisko: " + this.job);
        System.out.println("Wynagrodzenie: " + this.salary);
        System.out.println("Telefon służbowy: " + this.phoneNumber);
    }
}
