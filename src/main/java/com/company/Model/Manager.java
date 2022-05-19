package com.company.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public final class Manager extends Employee implements Inserting {
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

    @Override
    public String InsertStatement() {
        String statement = String.format("INSERT INTO employees " +
                "(pesel, first_name, last_name, job, team, salary, phone_nr, bonus_salary, nr_of_card) VALUES " +
                "(%s);", this);
        return statement;
    }

    @Override
    public String toString() {
        return "'" + this.pesel + "', '" + this.name +
                "', '" + this.lastName + "', '" + this.job +
                "', '" + this.team + "', '" + this.salary + "', '" +
                this.phoneNumber + "', '" + this.bonusSalary + "', '" +
                this.nrOfBussinessCard + "'";
    }

}
