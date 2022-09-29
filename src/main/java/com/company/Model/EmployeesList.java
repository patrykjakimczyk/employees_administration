package com.company.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public final class EmployeesList {
    @Getter
    private static final ArrayList<Employee> listOfEmployees = new ArrayList<>();
    @Setter
    @Getter
    private static Employee currentEmployee;

}
