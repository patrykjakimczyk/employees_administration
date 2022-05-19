package com.company.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public final class Tradesman extends Employee implements Inserting {
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
    public String InsertStatement() {
        String statement = String.format("INSERT INTO employees " +
                "(pesel, first_name, last_name, job, team, salary, phone_nr, provision, limit_of_provision) VALUES " +
                "(%s);", this);
        return statement;
    }

    public String toString() {
        return "'" + this.pesel + "', '" + this.name +
                "', '" + this.lastName + "', '" + this.job +
                "', '" + this.team + "', '" + this.salary + "', '" +
                this.phoneNumber + "', '" + this.provision + "', '" +
                this.limitOfProvision + "'";
    }
}
