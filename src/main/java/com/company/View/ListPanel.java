package com.company.View;

import javax.swing.*;
import java.awt.*;

public final class ListPanel extends JPanel {
    private static ListPanel instance = null;
    public JLabel pesel;
    public JLabel name;
    public JLabel lastName;
    public JLabel job;
    public JLabel team;
    public JLabel salary;
    public JLabel phone;
    public JLabel bonus;
    public JLabel lBonus;
    public JLabel card;
    public JLabel lCard;
    public JLabel provision;
    public JLabel lProvision;
    public JLabel limit;
    public JLabel lLimit;
    public JLabel position;
    public JButton returnBtn;
    public JButton editBtn;
    public JButton prevBtn;
    public JButton nextBtn;

    public ListPanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel lpesel = new JLabel("Pesel: ");
        lpesel.setSize(300, 30);
        lpesel.setLocation(150, 55);
        lpesel.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lpesel);

        pesel = new JLabel();
        pesel.setSize(300, 30);
        pesel.setLocation(460, 55);
        pesel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(pesel);

        JLabel lname = new JLabel("Name: ");
        lname.setSize(300, 30);
        lname.setLocation(150, 100);
        lname.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lname);

        name = new JLabel();
        name.setSize(300, 30);
        name.setLocation(460, 100);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(name);

        JLabel lLastName = new JLabel("Last name: ");
        lLastName.setSize(300, 30);
        lLastName.setLocation(150, 145);
        lLastName.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lLastName);

        lastName = new JLabel();
        lastName.setSize(300, 30);
        lastName.setLocation(460, 145);
        lastName.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(lastName);

        JLabel ljob = new JLabel("Job title: ");
        ljob.setSize(300, 30);
        ljob.setLocation(150, 190);
        ljob.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(ljob);

        job = new JLabel();
        job.setSize(300, 30);
        job.setLocation(460, 190);
        job.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(job);

        JLabel lteam = new JLabel("team: ");
        lteam.setSize(300, 30);
        lteam.setLocation(150, 235);
        lteam.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lteam);

        team = new JLabel();
        team.setSize(300, 30);
        team.setLocation(460, 235);
        team.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(team);

        JLabel lsalary = new JLabel("Salary: ");
        lsalary.setSize(300, 30);
        lsalary.setLocation(150, 280);
        lsalary.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lsalary);

        salary = new JLabel();
        salary.setSize(300, 30);
        salary.setLocation(460, 280);
        salary.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(salary);

        JLabel lphone = new JLabel("Phone nr:");
        lphone.setSize(300, 30);
        lphone.setLocation(150, 325);
        lphone.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lphone);

        phone = new JLabel();
        phone.setSize(300, 30);
        phone.setLocation(460, 325);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(phone);

        lBonus = new JLabel("Bonus salary:");
        lBonus.setSize(300, 30);
        lBonus.setLocation(150, 370);
        lBonus.setFont(new Font("Arial", Font.PLAIN, 30));
        lBonus.setVisible(false);
        this.add(lBonus);

        bonus = new JLabel();
        bonus.setSize(300, 30);
        bonus.setLocation(460, 370);
        bonus.setFont(new Font("Arial", Font.PLAIN, 25));
        bonus.setVisible(false);
        this.add(bonus);

        lCard = new JLabel("Card nr:");
        lCard.setSize(300, 30);
        lCard.setLocation(150, 415);
        lCard.setFont(new Font("Arial", Font.PLAIN, 30));
        lCard.setVisible(false);
        this.add(lCard);

        card = new JLabel();
        card.setSize(300, 30);
        card.setLocation(460, 415);
        card.setFont(new Font("Arial", Font.PLAIN, 25));
        card.setVisible(false);
        this.add(card);

        lProvision = new JLabel("Provision:");
        lProvision.setSize(300, 30);
        lProvision.setLocation(150, 370);
        lProvision.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lProvision);

        provision = new JLabel();
        provision.setSize(300, 30);
        provision.setLocation(460, 370);
        provision.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(provision);

        lLimit = new JLabel("Limit of provision:");
        lLimit.setSize(300, 30);
        lLimit.setLocation(150, 415);
        lLimit.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lLimit);

        limit = new JLabel();
        limit.setSize(300, 30);
        limit.setLocation(460, 415);
        limit.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(limit);

        position = new JLabel("Employee: ");
        position.setSize(150, 30);
        position.setLocation(330, 460);
        position.setFont(new Font("Arial", Font.PLAIN, 15));
        this.add(position);

        returnBtn = new JButton("Return");
        returnBtn.setSize(80, 40);
        returnBtn.setLocation(150, 500);
        this.add(returnBtn);

        editBtn = new JButton("Edit");
        editBtn.setSize(80, 40);
        editBtn.setLocation(250, 500);
        this.add(editBtn);

        prevBtn = new JButton("Previous");
        prevBtn.setSize(100, 40);
        prevBtn.setLocation(420, 500);
        this.add(prevBtn);

        nextBtn = new JButton("Next");
        nextBtn.setSize(100, 40);
        nextBtn.setLocation(550, 500);
        this.add(nextBtn);
    }

    public static ListPanel getListPanel() {
        if (instance == null) {
            instance = new ListPanel();
        }
        return instance;
    }
}
