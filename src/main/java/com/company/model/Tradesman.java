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

    public String toString() {
        return "'" + this.pesel + "', '" + this.name +
                "', '" + this.lastName + "', '" + this.job +
                "', '" + this.team + "', '" + this.salary + "', '" +
                this.phoneNumber + "', '" + this.provision + "', '" +
                this.limitOfProvision + "'";
    }
}
