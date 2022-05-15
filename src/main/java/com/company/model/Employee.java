package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    public final static int MAX_NAME_LEN = 20, MAX_LNAME_LEN = 40, MAX_JOB_LEN = 50, MAX_PHONE_LEN = 11;
    protected String pesel;
    protected String name;
    protected String lastName;
    protected String job;
    protected int team;
    protected BigDecimal salary;
    protected String phoneNumber;

    public String toString() {
        return "'" + this.pesel + "', " + "'" + this.name +
                "', " + "'" + this.lastName + "', " + "'" + this.job + "', " +
                "'" + this.team + "', " +
                "'" + this.salary + "', " +
                "'" + this.phoneNumber + "'";
    }
}
