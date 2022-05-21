package com.company.View;

import javax.swing.*;
import java.awt.*;

public final class UpdatePanel extends JPanel {
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
    public JButton updateBtn;

    public UpdatePanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel lPesel = new JLabel("Pesel: ");
        lPesel.setSize(200, 30);
        lPesel.setLocation(120, 55);
        lPesel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lPesel);

        pesel = new JTextField();
        pesel.setSize(300, 30);
        pesel.setLocation(380, 55);
        pesel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(pesel);

        JLabel lName = new JLabel("Name: ");
        lName.setSize(200, 30);
        lName.setLocation(120, 100);
        lName.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lName);

        name = new JTextField();
        name.setSize(300, 30);
        name.setLocation(380, 100);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(name);

        JLabel lLastName = new JLabel("Last name: ");
        lLastName.setSize(200, 30);
        lLastName.setLocation(120, 145);
        lLastName.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lLastName);

        lastName = new JTextField();
        lastName.setSize(300, 30);
        lastName.setLocation(380, 145);
        lastName.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(lastName);

        JLabel lJob = new JLabel("Job title: ");
        lJob.setSize(200, 30);
        lJob.setLocation(120, 190);
        lJob.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lJob);

        job = new JTextField();
        job.setSize(300, 30);
        job.setLocation(380, 190);
        job.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(job);

        JLabel lTeam = new JLabel("Team: ");
        lTeam.setSize(200, 30);
        lTeam.setLocation(120, 235);
        lTeam.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lTeam);

        team = new JTextField();
        team.setSize(300, 30);
        team.setLocation(380, 235);
        team.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(team);

        JLabel lSalary = new JLabel("Salary: ");
        lSalary.setSize(200, 30);
        lSalary.setLocation(120, 280);
        lSalary.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lSalary);

        salary = new JTextField();
        salary.setSize(300, 30);
        salary.setLocation(380, 280);
        salary.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(salary);

        JLabel lPhone = new JLabel("Phone Nr:");
        lPhone.setSize(200, 30);
        lPhone.setLocation(120, 325);
        lPhone.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lPhone);

        phone = new JTextField();
        phone.setSize(300, 30);
        phone.setLocation(380, 325);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(phone);

        lBonus = new JLabel("Bonus salary:");
        lBonus.setSize(200, 30);
        lBonus.setLocation(120, 370);
        lBonus.setFont(new Font("Arial", Font.PLAIN, 30));
        lBonus.setVisible(false);
        this.add(lBonus);

        bonus = new JTextField();
        bonus.setSize(300, 30);
        bonus.setLocation(380, 370);
        bonus.setFont(new Font("Arial", Font.PLAIN, 25));
        bonus.setVisible(false);
        this.add(bonus);

        lCard = new JLabel("Card number:");
        lCard.setSize(200, 30);
        lCard.setLocation(120, 415);
        lCard.setFont(new Font("Arial", Font.PLAIN, 30));
        lCard.setVisible(false);
        this.add(lCard);

        card = new JTextField();
        card.setSize(300, 30);
        card.setLocation(380, 415);
        card.setFont(new Font("Arial", Font.PLAIN, 25));
        card.setVisible(false);
        this.add(card);

        lProvision = new JLabel("Provision:");
        lProvision.setSize(200, 30);
        lProvision.setLocation(120, 370);
        lProvision.setFont(new Font("Arial", Font.PLAIN, 30));
        lProvision.setVisible(false);
        this.add(lProvision);

        provision = new JTextField();
        provision.setSize(300, 30);
        provision.setLocation(380, 370);
        provision.setFont(new Font("Arial", Font.PLAIN, 25));
        provision.setVisible(false);
        this.add(provision);

        lLimit = new JLabel("Limit of provision:");
        lLimit.setSize(300, 30);
        lLimit.setLocation(120, 415);
        lLimit.setFont(new Font("Arial", Font.PLAIN, 30));
        lLimit.setVisible(false);
        this.add(lLimit);

        limit = new JTextField();
        limit.setSize(300, 30);
        limit.setLocation(380, 415);
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

        updateBtn = new JButton("Update");
        updateBtn.setSize(80, 40);
        updateBtn.setLocation(450, 500);
        this.add(updateBtn);
    }
}
