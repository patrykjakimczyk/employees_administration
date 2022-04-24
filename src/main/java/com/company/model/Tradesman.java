package com.company.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
final public class Tradesman extends Employee {
    private BigDecimal provision;
    private BigDecimal limitOfProvision;

    public Tradesman() {
        super();
        this.provision = new BigDecimal("0");
        this.limitOfProvision = new BigDecimal("0");
    }

    public Tradesman(String pesel, String name, String lastName, String job, int team, BigDecimal salary, String phoneNumber, BigDecimal provision, BigDecimal limitOfProvision) {
        super(pesel, name, lastName, job, team, salary, phoneNumber);
        this.provision = provision;
        this.limitOfProvision = limitOfProvision;
    }

    @Override
    public void removingView() {
        super.removingView();
        System.out.println("Prowizja: " + this.provision);
        System.out.println("Limit prowizji: " + this.limitOfProvision);
    }

    @Override
    public void listView() {
        super.listView();
        System.out.println("Prowizja: " + this.provision);
        System.out.println("Limit prowizji: " + this.limitOfProvision);
    }
}
