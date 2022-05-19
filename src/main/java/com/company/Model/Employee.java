package com.company.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Statements {
    public final static int MAX_NAME_LEN = 20, MAX_LNAME_LEN = 40, MAX_JOB_LEN = 50, MAX_PHONE_LEN = 11;
    protected String pesel;
    protected String name;
    protected String lastName;
    protected String job;
    protected int team;
    protected BigDecimal salary;
    protected String phoneNumber;

    @Override
    public String InsertStatement() {
        String statement = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr) VALUES" +
                        "('%s', '%s','%s','%s','%s','%s','%s');", this.pesel, this.name, this.lastName,
                this.job, this.team, this.salary, this.phoneNumber);
        return statement;
    }

    @Override
    public String UpdateStatement() {
        String statement = String.format("UPDATE employees" +
                        "SET pesel='%s', first_name='%s', last_name='%s', job='%s'," +
                        "team='%s', salary='%s', phone_nr='%s'" +
                        "WHERE pesel='%s';",
                this.pesel, this.name, this.lastName,
                this.job, this.team, this.salary, this.phoneNumber, this.pesel);
        return statement;
    }
}
