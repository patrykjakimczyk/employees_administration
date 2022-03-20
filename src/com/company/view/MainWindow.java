package com.company.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        this.setSize(600, 600);
        this.setName("Company");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(Box.createVerticalGlue());

        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(250, 250));
        menu.setMaximumSize(new Dimension(250, 250));
        menu.setLayout(new GridLayout(4, 1, 0, 10));
        menu.setBackground(Color.white);
        box.add(menu);
        box.add(Box.createVerticalGlue());
        this.add(box, BorderLayout.CENTER);

        JButton list = new JButton();
        list.setText("1. List of employees");
        list.setFocusable(false);
        //list.setBorderPainted(false);
        list.setBackground(Color.white);
        menu.add(list);

        JButton addEmployee = new JButton();
        addEmployee.setText("2. Add a employee");
        addEmployee.setFocusable(false);
        addEmployee.setBackground(Color.white);
        addEmployee.addActionListener(e -> newWindow(box, menu));
        //addEmployee.setBorderPainted(false);
        menu.add(addEmployee);

        JButton deleteEmployee = new JButton();
        deleteEmployee.setBackground(Color.white);
        deleteEmployee.setText("3. Delete employee");
        deleteEmployee.setFocusable(false);
        //deleteEmployee.setBorderPainted(false);
        menu.add(deleteEmployee);

        JButton exit = new JButton();
        exit.setBackground(Color.white);
        exit.setText("4. Exit");
        exit.setFocusable(false);
        //exit.setBorderPainted(false);
        exit.addActionListener(e -> this.dispose());
        menu.add(exit);

        this.setVisible(true);
    }

    public void newWindow(Box box, JPanel panel) {
        JPanel add = new AddWindow();
        box.removeAll();
        box.add(Box.createVerticalGlue());
        box.add(Box.createHorizontalGlue());
        box.add(add, BorderLayout.CENTER);
        box.add(Box.createVerticalGlue());
        box.add(Box.createHorizontalGlue());
        this.revalidate();
        this.repaint();
    }
}
