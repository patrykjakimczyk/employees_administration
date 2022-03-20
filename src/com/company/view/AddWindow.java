package com.company.view;

import javax.swing.*;
import java.awt.*;

public class AddWindow extends JPanel {
    AddWindow() {
        this.setPreferredSize(new Dimension(300, 300));
        this.setMaximumSize(new Dimension(300, 300));
        this.setLayout(new GridLayout(5, 1, 0, 10));
        this.setBackground(Color.gray);

        JTextField pesel = new JTextField();
        this.add(pesel);
        JTextField name = new JTextField();
        this.add(name);
        JTextField lastname = new JTextField();
        this.add(lastname);
        JTextField job = new JTextField();
        this.add(job);
        JTextField salary = new JTextField();
        this.add(salary);
    }
}
