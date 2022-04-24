package com.company;

import com.company.model.Data;
import com.company.model.Employee;
import com.company.model.Manager;
import com.company.model.Tradesman;
import com.company.view.AddPanel;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    static Scanner in = new Scanner(System.in);

    public static void listOfEmployees() {
        int i = 1;
        for (Map.Entry<String, Employee> entry : Data.getListOfEmployees().entrySet()) {
            Scanner in = new Scanner(System.in);

            entry.getValue().listView();
            System.out.println("Pozycja: [" + i + "/" + Data.getListOfEmployees().size() + "]");

            System.out.println("Wybór: [Enter] = nastepny\n [Q] = powrot ");
            String choice = in.nextLine();

            if (choice.equals("Q")) {
                return;
            }
            i++;
        }
    }

    private static boolean peselCheck(char[] p) {

        if (p.length == 11 && !Data.getListOfEmployees().containsKey(String.valueOf(p))) {
            if ((p[0] + 3 * p[1] + 7 * p[2] + 9 * p[3] + p[4] + 3 * p[5] + 7 * p[6] + 9 * p[7] + p[8] + 3 * p[9] + p[10]) % 10 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static Boolean isValueValid(String val) {

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

    private static Boolean isValueValid(String val, int len) {

        if (!val.matches("^[0-9]*$") || val.length() == 0 || val.length() > len) {
            return false;
        }
        return true;
    }

    private static Boolean isValueValid(String val, boolean onlyLetters, int len) {

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

    public static Boolean addEmployeeWithValidation(String pesel, String name, String lName, String job, String team, String salary, String phone) {
        char[] p = pesel.toCharArray();
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
        Data.getListOfEmployees().put(pesel, e);
        return true;
    }

    public static Boolean addEmployeeWithValidation(String pesel, String name, String lName, String job, String team, String salary, String phone, String bonusOrProv, String cardOrlimit) {
        char[] p = pesel.toCharArray();
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
            Data.getListOfEmployees().put(pesel, m);
            return true;
        } else {
            if (!isValueValid(bonusOrProv)) {
                return false;
            }
            if (!isValueValid(cardOrlimit)) {
                return false;
            }

            Tradesman tm = new Tradesman(pesel, name, lName, job, t, s, phone, new BigDecimal(bonusOrProv), new BigDecimal(cardOrlimit));
            Data.getListOfEmployees().put(pesel, tm);
            return true;
        }
    }

//    private static Employee addEmployeeDefault(String job) {
//        System.out.println("Identyfikator Pesel: ");
//        String pesel = in.nextLine();
//        char[] p = pesel.toCharArray();
//
//        if (!peselCheck(p)) {
//            System.out.println("Bledny pesel: ");
//            return null;
//        } else {
//            System.out.println("Imię: ");
//            String name = isValueValid(true, 20);
//
//            System.out.println("Nazwisko: ");
//            String lastName = isValueValid(true, 30);
//
//            System.out.println("Wynagrodzenie(zł): ");
//            BigDecimal salary = isValueValid();
//
//            System.out.println("Telefon służbowy: ");
//            in.nextLine();
//            String phoneNumber = isValueValid(false, 11);
//
//            Employee e = new Employee(pesel, name, lastName, job, salary, phoneNumber);
//            return e;
//        }
//    }

//    public static void addEmployee() {
//        String nrOfCard = "";
//        BigDecimal bonusS = new BigDecimal("0");
//        BigDecimal provison = new BigDecimal("0");
//        BigDecimal limitOfProv = new BigDecimal("0");
//        BigDecimal salary = new BigDecimal("0");
//        Employee e;
//
//        System.out.println("[D]yrektor/[H]andlowiec/[Z]wykły pracownik ");
//        String rola = in.nextLine();
//        System.out.println(rola);
//        if (rola.equals("D")) {
//
//            e = addEmployeeDefault(rola);
//
//            System.out.println("Dodatek służbowy(zł): ");
//            bonusS = isValueValid();
//
//            System.out.println("Karta służbowa numer: ");
//            nrOfCard = isValueValid(false, 20);
//
//        } else if (rola.equals("H")) {
//
//            e = addEmployeeDefault(rola);
//
//            System.out.println("Prowizja: ");
//            provison = isValueValid();
//
//            System.out.println("Limit prowizji/miesiąc(zł): ");
//            limitOfProv = isValueValid();
//
//        } else if (rola.equals("Z")) {
//
//            e = addEmployeeDefault(rola);
//            System.out.println("rola: ");
//            rola = isValueValid(true, 50);
//
//        } else {
//            System.out.println("Błędne stanowisko pracownika: ");
//            return;
//        }
//
//        System.out.println("Wybór: [Enter] = zapisz\n [Q] = porzuć ");
//        in.nextLine();
//        String wybor = in.nextLine();
//
//        if (!wybor.equals("Q")) {
//            if (rola.equals("D")) {
//
//                e.setJob("Dyrektor");
//                Manager dyrektor = new Manager(
//                        e.getPesel(), e.getName(), e.getLastName(), e.getJob(), e.getSalary(), e.getPhoneNumber(), bonusS, nrOfCard
//                );
//                Data.getListOfEmployees().put(e.getPesel(), dyrektor);
//
//            } else if (rola.equals("H")) {
//
//                e.setJob("Handlowiec");
//                Tradesman handlowiec = new Tradesman(
//                        e.getPesel(), e.getName(), e.getLastName(), e.getJob(), e.getSalary(), e.getPhoneNumber(), provison, limitOfProv
//                );
//                Data.getListOfEmployees().put(e.getPesel(), handlowiec);
//
//            } else {
//
//                Data.getListOfEmployees().put(e.getPesel(), e);
//
//            }
//        }
//    }

    public static void deleteEmployee() {
        String p;

        System.out.println("Podaj pesel: ");
        p = in.nextLine();

        Employee employee = Data.getListOfEmployees().get(p);

        if (employee != null) {
            employee.removingView();

            System.out.println("Wybór: [Enter] = usuń\n [Q] = porzuć ");
            in.nextLine();
            String wybor = in.nextLine();


            if (!wybor.equals("Q")) {
                Data.getListOfEmployees().remove(p);
            } else {
                System.out.println("Porzucono");
            }

        } else {
            System.out.println("Nie ma takiego pracownika");
        }
    }
}
