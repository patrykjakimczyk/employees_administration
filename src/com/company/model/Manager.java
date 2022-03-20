package com.company.model;

import java.math.BigDecimal;

final public class Manager extends Employee {

    private BigDecimal bonusSalary;
    private String nrOfBussinessCard;
    private BigDecimal costLimit;

    public Manager() {
        super();
        this.bonusSalary = new BigDecimal("0");
        this.nrOfBussinessCard = null;
        this.costLimit = new BigDecimal("0");
    }

    public Manager(String pesel, String name, String lastName, String job, BigDecimal salary, String phoneNumber, BigDecimal d, String nr, BigDecimal l) {
        super(pesel, name, lastName, job, salary, phoneNumber);
        this.bonusSalary = d;
        this.nrOfBussinessCard = nr;
        this.costLimit = l;
    }

    public BigDecimal getBonusSalary() {
        return this.bonusSalary;
    }

    public void setBonusSalary(BigDecimal bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public String getNrOfBussinessCard() {
        return this.nrOfBussinessCard;
    }

    public void setNrOfBussinessCard(String nrOfBussinessCard) {
        this.nrOfBussinessCard = nrOfBussinessCard;
    }

    public BigDecimal getCostLimit() {
        return this.costLimit;
    }

    public void setCostLimit(BigDecimal costLimit) {
        this.costLimit = costLimit;
    }

    @Override
    public void removingView() {
        super.removingView();
        System.out.println("Dodatek sluzbowy: " + this.bonusSalary);
        System.out.println("Limit kosztów: " + this.costLimit);
    }

    @Override
    public void listView() {
        super.listView();
        System.out.println("Dodatek sluzbowy: " + this.bonusSalary);
        System.out.println("Numer Karty sluzbowej: " + this.bonusSalary);
        System.out.println("Limit kosztow: " + this.costLimit);
    }
}
