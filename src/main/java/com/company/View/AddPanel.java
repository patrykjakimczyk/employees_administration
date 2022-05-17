package com.company.View;

import com.company.Controller.ButtonsController;

import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
    public static String[] choices = {"Manager", "Tradesman", "Other job title"};
    public JComboBox choice;
    public JTextField pesel;
    public JTextField name;
    public JTextField lastName;
    public JTextField team;
    public JTextField salary;
    public JTextField phone;
    public JTextField job;
    public JLabel lBonus;
    public JTextField bonus;
    public JLabel lCard;
    public JTextField card;
    public JLabel lProvision;
    public JTextField provision;
    public JLabel lLimit;
    public JTextField limit;
    public JLabel status;
    public JButton returnBtn;
    public JButton addBtn;

    public AddPanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        choice = new JComboBox(choices);
        choice.setSize(200, 30);
        choice.setLocation(300, 35);
        choice.setSelectedItem(choices[2]);
        this.add(choice);

        JLabel lPesel = new JLabel("Pesel: ");
        lPesel.setSize(200, 30);
        lPesel.setLocation(120, 85);
        lPesel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lPesel);

        pesel = new JTextField();
        pesel.setSize(300, 30);
        pesel.setLocation(380, 85);
        pesel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(pesel);

        JLabel lName = new JLabel("Name: ");
        lName.setSize(200, 30);
        lName.setLocation(120, 130);
        lName.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lName);

        name = new JTextField();
        name.setSize(300, 30);
        name.setLocation(380, 130);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(name);

        JLabel lLastName = new JLabel("Last name: ");
        lLastName.setSize(200, 30);
        lLastName.setLocation(120, 175);
        lLastName.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lLastName);

        lastName = new JTextField();
        lastName.setSize(300, 30);
        lastName.setLocation(380, 175);
        lastName.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(lastName);

        JLabel lJob = new JLabel("Job title: ");
        lJob.setSize(200, 30);
        lJob.setLocation(120, 220);
        lJob.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lJob);

        job = new JTextField();
        job.setSize(300, 30);
        job.setLocation(380, 220);
        job.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(job);

        JLabel lTeam = new JLabel("Team: ");
        lTeam.setSize(200, 30);
        lTeam.setLocation(120, 265);
        lTeam.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lTeam);

        team = new JTextField();
        team.setSize(300, 30);
        team.setLocation(380, 265);
        team.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(team);

        JLabel lSalary = new JLabel("Salary: ");
        lSalary.setSize(200, 30);
        lSalary.setLocation(120, 310);
        lSalary.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lSalary);

        salary = new JTextField();
        salary.setSize(300, 30);
        salary.setLocation(380, 310);
        salary.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(salary);

        JLabel lPhone = new JLabel("Phone Nr:");
        lPhone.setSize(200, 30);
        lPhone.setLocation(120, 355);
        lPhone.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lPhone);

        phone = new JTextField();
        phone.setSize(300, 30);
        phone.setLocation(380, 355);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(phone);

        lBonus = new JLabel("Bonus salary:");
        lBonus.setSize(200, 30);
        lBonus.setLocation(120, 400);
        lBonus.setFont(new Font("Arial", Font.PLAIN, 30));
        lBonus.setVisible(false);
        this.add(lBonus);

        bonus = new JTextField();
        bonus.setSize(300, 30);
        bonus.setLocation(380, 400);
        bonus.setFont(new Font("Arial", Font.PLAIN, 25));
        bonus.setVisible(false);
        this.add(bonus);

        lCard = new JLabel("Card number:");
        lCard.setSize(200, 30);
        lCard.setLocation(120, 445);
        lCard.setFont(new Font("Arial", Font.PLAIN, 30));
        lCard.setVisible(false);
        this.add(lCard);

        card = new JTextField();
        card.setSize(300, 30);
        card.setLocation(380, 445);
        card.setFont(new Font("Arial", Font.PLAIN, 25));
        card.setVisible(false);
        this.add(card);

        lProvision = new JLabel("Provision:");
        lProvision.setSize(200, 30);
        lProvision.setLocation(120, 400);
        lProvision.setFont(new Font("Arial", Font.PLAIN, 30));
        lProvision.setVisible(false);
        this.add(lProvision);

        provision = new JTextField();
        provision.setSize(300, 30);
        provision.setLocation(380, 400);
        provision.setFont(new Font("Arial", Font.PLAIN, 25));
        provision.setVisible(false);
        this.add(provision);

        lLimit = new JLabel("Limit of provision:");
        lLimit.setSize(300, 30);
        lLimit.setLocation(120, 445);
        lLimit.setFont(new Font("Arial", Font.PLAIN, 30));
        lLimit.setVisible(false);
        this.add(lLimit);

        limit = new JTextField();
        limit.setSize(300, 30);
        limit.setLocation(380, 445);
        limit.setFont(new Font("Arial", Font.PLAIN, 25));
        limit.setVisible(false);
        this.add(limit);

        status = new JLabel();
        status.setSize(400, 30);
        status.setLocation(190, 470);
        status.setFont(new Font("Arial", Font.PLAIN, 15));
        status.setVisible(false);
        status.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(status);

        returnBtn = new JButton("Return");
        returnBtn.setSize(80, 40);
        returnBtn.setLocation(250, 500);
        this.add(returnBtn);

        addBtn = new JButton("Add");
        addBtn.setSize(80, 40);
        addBtn.setLocation(450, 500);
        this.add(addBtn);

        ButtonsController.choiceActionListener(this, choice, addBtn);
    }
}
