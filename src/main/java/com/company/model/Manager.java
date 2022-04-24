package com.company.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
final public class Manager extends Employee {
    public final static int MAX_CARD_LEN = 16;
    private BigDecimal bonusSalary;
    private String nrOfBussinessCard;

    public Manager() {
        super();
        this.bonusSalary = new BigDecimal("0");
        this.nrOfBussinessCard = null;
    }

    public Manager(String pesel, String name, String lastName, String job, int team, BigDecimal salary, String phoneNumber, BigDecimal d, String nr) {
        super(pesel, name, lastName, job, team, salary, phoneNumber);
        this.bonusSalary = d;
        this.nrOfBussinessCard = nr;
    }
//
//    public BigDecimal getBonusSalary() {
//        return this.bonusSalary;
//    }
//
//    public void setBonusSalary(BigDecimal bonusSalary) {
//        this.bonusSalary = bonusSalary;
//    }
//
//    public String getNrOfBussinessCard() {
//        return this.nrOfBussinessCard;
//    }
//
//    public void setNrOfBussinessCard(String nrOfBussinessCard) {
//        this.nrOfBussinessCard = nrOfBussinessCard;
//    }


    @Override
    public void removingView() {
        super.removingView();
        System.out.println("Dodatek sluzbowy: " + this.bonusSalary);
        System.out.println("Numer karty służbowej: " + this.nrOfBussinessCard);
    }

    @Override
    public void listView() {
        super.listView();
        System.out.println("Dodatek sluzbowy: " + this.bonusSalary);
        System.out.println("Numer karty służbowej: " + this.nrOfBussinessCard);
    }
}
