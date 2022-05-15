package com.company.view;

import javax.swing.*;
import java.awt.*;

public final class MenuPanel extends JPanel {
    public final JButton list;
    public final JButton addEmployee;
    public final JButton searchEmployee;
    public final JButton exit;

    MenuPanel() {
        this.setPreferredSize(new Dimension(250, 250));
        this.setMaximumSize(new Dimension(250, 250));
        this.setLayout(new GridLayout(4, 1, 0, 10));
        this.setBackground(Color.white);

        list = new JButton();
        list.setText("1. List of employees");
        list.setFocusable(false);
        //list.setBorderPainted(false);
        list.setBackground(Color.white);
        this.add(list);

        addEmployee = new JButton();
        addEmployee.setText("2. Add a employee");
        addEmployee.setFocusable(false);
        addEmployee.setBackground(Color.white);
        //addEmployee.addActionListener(e -> newWindow());
        //addEmployee.setBorderPainted(false);
        this.add(addEmployee);

        searchEmployee = new JButton();
        searchEmployee.setBackground(Color.white);
        searchEmployee.setText("3. Delete employee");
        searchEmployee.setFocusable(false);
        //deleteEmployee.setBorderPainted(false);
        this.add(searchEmployee);

        exit = new JButton();
        exit.setBackground(Color.white);
        exit.setText("4. Exit");
        exit.setFocusable(false);
        //exit.setBorderPainted(false);
        //exit.addActionListener(e -> this.dispose());
        this.add(exit);
    }
}
