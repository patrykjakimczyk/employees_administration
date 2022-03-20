package com.company;

import com.company.model.Data;
import com.company.model.Employee;
import com.company.model.Manager;
import com.company.model.Tradesman;

import java.math.BigDecimal;
import java.util.InputMismatchException;
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

    private static String isValueValid(boolean choice, int len) {
        String val = in.nextLine();

        if (choice) {
            while (!val.matches("[a-zA-Z]+") || val.length() > len) {
                System.out.println("Podano złą wartość lub przekroczono długość! (Tylko litery, długość: )" + len);
                val = in.nextLine();
            }
            return val;
        } else {
            while (val.length() > len) {
                System.out.printf("Podano za długi napis! (długość: %d\n)", len);
                val = in.nextLine();
            }
            return val;
        }
    }

    private static BigDecimal isValueValid() {
        BigDecimal val = null;

        while (val == null) {
            try {
                val = in.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.println("Podano niewłaściwą wartość! (Tylko cyfry)");
                in.next();
                //continue;
            }
        }
        return val;
    }

    private static Employee addEmployeeDefault(String job) {
        System.out.println("Identyfikator Pesel: ");
        String pesel = in.nextLine();
        char[] p = pesel.toCharArray();

        if (!peselCheck(p)) {
            System.out.println("Bledny pesel: ");
            return null;
        } else {
            System.out.println("Imię: ");
            String name = isValueValid(true, 20);

            System.out.println("Nazwisko: ");
            String lastName = isValueValid(true, 30);

            System.out.println("Wynagrodzenie(zł): ");
            BigDecimal salary = isValueValid();

            System.out.println("Telefon służbowy: ");
            in.nextLine();
            String phoneNumber = isValueValid(false, 11);

            Employee e = new Employee(pesel, name, lastName, job, salary, phoneNumber);
            return e;
        }
    }

    public static void addEmployee() {
        String nrOfCard = "";
        BigDecimal bonusS = new BigDecimal("0");
        BigDecimal limit = new BigDecimal("0");
        BigDecimal provison = new BigDecimal("0");
        BigDecimal limitOfProv = new BigDecimal("0");
        BigDecimal salary = new BigDecimal("0");
        Employee e;

        System.out.println("[D]yrektor/[H]andlowiec/[Z]wykły pracownik ");
        String rola = in.nextLine();
        System.out.println(rola);
        if (rola.equals("D")) {

            e = addEmployeeDefault(rola);

            System.out.println("Dodatek służbowy(zł): ");
            bonusS = isValueValid();

            System.out.println("Karta służbowa numer: ");
            nrOfCard = isValueValid(false, 20);

            System.out.println("Limit kosztów/miesiąc(zł): ");
            limit = isValueValid();

        } else if (rola.equals("H")) {

            e = addEmployeeDefault(rola);

            System.out.println("Prowizja: ");
            provison = isValueValid();

            System.out.println("Limit prowizji/miesiąc(zł): ");
            limitOfProv = isValueValid();

        } else if (rola.equals("Z")) {

            e = addEmployeeDefault(rola);
            System.out.println("rola: ");
            rola = isValueValid(true, 50);

        } else {
            System.out.println("Błędne stanowisko pracownika: ");
            return;
        }

        System.out.println("Wybór: [Enter] = zapisz\n [Q] = porzuć ");
        in.nextLine();
        String wybor = in.nextLine();

        if (!wybor.equals("Q")) {
            if (rola.equals("D")) {

                e.setJob("Dyrektor");
                Manager dyrektor = new Manager(
                        e.getPesel(), e.getName(), e.getLastName(), e.getJob(), e.getSalary(), e.getPhoneNumber(), bonusS, nrOfCard, limit
                );
                Data.getListOfEmployees().put(e.getPesel(), dyrektor);

            } else if (rola.equals("H")) {

                e.setJob("Handlowiec");
                Tradesman handlowiec = new Tradesman(
                        e.getPesel(), e.getName(), e.getLastName(), e.getJob(), e.getSalary(), e.getPhoneNumber(), provison, limitOfProv
                );
                Data.getListOfEmployees().put(e.getPesel(), handlowiec);

            } else {

                Data.getListOfEmployees().put(e.getPesel(), e);

            }
        }
    }

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
