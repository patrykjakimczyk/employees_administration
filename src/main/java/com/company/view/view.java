package com.company.view;

import com.company.Controller;

import java.util.Scanner;

public class view {

    static Scanner in = new Scanner(System.in);

    public static void menu() {
        int optionnumber;
        MainFrame mainFrame = new MainFrame();

        System.out.print("Choose option: \n1. List of employees\n2. Add a employee\n3. Delete employee\n4. Exit\n");
        optionnumber = in.nextInt();
        switch (optionnumber) {
            case 1:
                optionone();
                menu();
                break;
            case 2:
                optiontwo();
                menu();
                break;

            case 3:
                optionthree();
                menu();
                break;

            case 4:
                System.out.println("Good bye!");
                break;

            default:
                menu();
                break;
        }
    }

    private static void optionone() {
        Controller.listOfEmployees();
    }

    private static void optiontwo() {
        //Controller.addEmployee();
    }

    private static void optionthree() {
        Controller.deleteEmployee();
    }

}
