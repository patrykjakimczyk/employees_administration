package com.company;

import com.company.db.DataBaseController;
import com.company.model.Employee;
import com.company.model.Manager;
import com.company.model.Tradesman;
import com.company.view.AddPanel;

import java.math.BigDecimal;
import java.util.Scanner;

public class Controller {
    static Scanner in = new Scanner(System.in);

    private static boolean peselCheck(char[] p) {

        if (p.length == 11) {
            if ((p[0] + 3 * p[1] + 7 * p[2] + 9 * p[3] + p[4] + 3 * p[5] + 7 * p[6] + 9 * p[7] + p[8] + 3 * p[9] + p[10]) % 10 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isValueValid(String val) {

        if (!val.equals("")) {
            try {
                BigDecimal newVal = new BigDecimal(val);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean isValueValid(String val, int len) {

        if (!val.matches("^[0-9]*$") || val.length() == 0 || val.length() > len) {
            return false;
        }
        return true;
    }

    private static boolean isValueValid(String val, boolean onlyLetters, int len) {

        if (onlyLetters) {
            if (!val.matches("[a-zA-Z]+") || val.length() == 0 || val.length() > len) {
                return false;
            }
        } else {
            if (val.length() == 0 || val.length() > len) {
                return false;
            }
        }
        return true;
    }

    public static boolean addEmployeeWithValidation(String pesel, String name, String lName, String job, String team, String salary, String phone) {
        char[] p = pesel.toCharArray();

        if (team.equals("")) {
            return false;
        }
        int t = Integer.parseInt(team);

        if (!peselCheck(p)) {
            System.out.println("Bledny pesel: ");
            return false;
        }
        if (!isValueValid(name, true, Employee.MAX_NAME_LEN)) {
            return false;
        }
        if (!isValueValid(lName, true, Employee.MAX_LNAME_LEN)) {
            return false;
        }
        if (!isValueValid(job, true, Employee.MAX_JOB_LEN)) {
            return false;
        }
        if (t <= 0) {
            return false;
        }
        if (!isValueValid(salary)) {
            return false;
        }
        if (!isValueValid(phone, false, Employee.MAX_PHONE_LEN)) {
            return false;
        }

        Employee e = new Employee(pesel, name, lName, job, Integer.parseInt(team), new BigDecimal(salary), phone);
        //Data.getListOfEmployees().add(e);
        if (DataBaseController.addToDB(e)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addEmployeeWithValidation(String pesel, String name, String lName, String job,
                                                    String team, String salary, String phone, String bonusOrProv,
                                                    String cardOrlimit) {
        char[] p = pesel.toCharArray();
        if (team.equals("")) {
            return false;
        }
        int t = Integer.parseInt(team);

        if (!peselCheck(p)) {
            System.out.println("Bledny pesel: ");
            return false;
        }
        if (!isValueValid(name, true, Employee.MAX_NAME_LEN)) {
            return false;
        }
        if (!isValueValid(lName, true, Employee.MAX_LNAME_LEN)) {
            return false;
        }
        if (!isValueValid(job, true, Employee.MAX_JOB_LEN)) {
            return false;
        }
        if (t <= 0) {
            return false;
        }
        if (!isValueValid(salary)) {
            return false;
        }
        if (!isValueValid(phone, false, Employee.MAX_PHONE_LEN)) {
            return false;
        }
        BigDecimal s = new BigDecimal(salary);

        if (job.equals(AddPanel.choices[0])) {
            if (!isValueValid(bonusOrProv)) {
                return false;
            }
            if (!isValueValid(cardOrlimit, Manager.MAX_CARD_LEN)) {
                return false;
            }

            Manager m = new Manager(pesel, name, lName, job, t, s, phone, new BigDecimal(bonusOrProv), cardOrlimit);

            if (DataBaseController.addToDB(m)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (!isValueValid(bonusOrProv)) {
                return false;
            }
            if (!isValueValid(cardOrlimit)) {
                return false;
            }

            Tradesman tm = new Tradesman(pesel, name, lName, job, t, s, phone, new BigDecimal(bonusOrProv), new BigDecimal(cardOrlimit));

            if (DataBaseController.addToDB(tm)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
