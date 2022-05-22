package com.company.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public final class Tradesman extends Employee implements Statements {
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
    public String insertStatement() {
        String statement = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr, provision, limit_of_provision) VALUES " +
                        "('%s', '%s','%s','%s','%s','%s','%s', '%s', '%s');", this.pesel, this.name, this.lastName,
                this.job, this.team, this.salary, this.phoneNumber, this.provision, this.limitOfProvision);
        return statement;
    }

    @Override
    public String updateStatement() {
        String statement = String.format("UPDATE employees " +
                        "SET pesel='%s', first_name='%s', last_name='%s', job='%s'," +
                        "team='%s', salary='%s', phone_nr='%s', provision='%s', limit_of_provision='%s'",
                this.pesel, this.name, this.lastName,
                this.job, this.team, this.salary, this.phoneNumber, this.provision, this.limitOfProvision, this.pesel);
        return statement;
    }

    public void updateEmployee(String pesel, String name, String lName, String job, int team,
                               BigDecimal salary, String phone, BigDecimal provision,
                               BigDecimal limit) {
        super.updateEmployee(pesel, name, lName, job, team, salary, phone);
        this.provision = provision;
        this.limitOfProvision = limit;
    }
}
