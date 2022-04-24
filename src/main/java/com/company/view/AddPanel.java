package com.company.view;

import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
    public static String[] choices = {"Dyrektor", "Handlowiec", "Zwykły pracownik"};
    JTextField pesel;
    JComboBox choice;
    JLabel lPesel;
    JLabel lName;
    JTextField name;
    JLabel lLastName;
    JTextField lastName;
    JLabel lJob;
    JTextField job;
    JLabel lTeam;
    JTextField team;
    JLabel lSalary;
    JTextField salary;
    JLabel lPhone;
    JTextField phone;
    JLabel lBonus;
    JTextField bonus;
    JLabel lCard;
    JTextField card;
    JLabel lProvision;
    JTextField provision;
    JLabel lLimit;
    JTextField limit;
    JLabel status;
    JButton returnBtn;
    JButton addBtn;

    AddPanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        JComboBox choice = new JComboBox(choices);
        choice.setSize(200, 30);
        choice.setLocation(300, 50);
        choice.setSelectedItem(choices[2]);
        this.add(choice);

        lPesel = new JLabel("Pesel: ");
        lPesel.setSize(200, 30);
        lPesel.setLocation(150, 100);
        lPesel.setFont(new Font("Arial", Font.PLAIN, 30));
        //lPesel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lPesel);

        pesel = new JTextField();
        pesel.setSize(300, 30);
        pesel.setLocation(350, 100);
        pesel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(pesel);

        lName = new JLabel("Imie: ");
        lName.setSize(200, 30);
        lName.setLocation(150, 145);
        lName.setFont(new Font("Arial", Font.PLAIN, 30));
        //lName.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lName);

        name = new JTextField();
        name.setSize(300, 30);
        name.setLocation(350, 145);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(name);

        lLastName = new JLabel("Nazwisko: ");
        lLastName.setSize(200, 30);
        lLastName.setLocation(150, 190);
        lLastName.setFont(new Font("Arial", Font.PLAIN, 30));
        //lLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lLastName);

        lastName = new JTextField();
        lastName.setSize(300, 30);
        lastName.setLocation(350, 190);
        lastName.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(lastName);

        lJob = new JLabel("Stanowisko: ");
        lJob.setSize(200, 30);
        lJob.setLocation(150, 235);
        lJob.setFont(new Font("Arial", Font.PLAIN, 30));
        //lJob.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lJob);

        job = new JTextField();
        job.setSize(300, 30);
        job.setLocation(350, 235);
        job.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(job);

        lTeam = new JLabel("Zespół: ");
        lTeam.setSize(200, 30);
        lTeam.setLocation(150, 280);
        lTeam.setFont(new Font("Arial", Font.PLAIN, 30));
        //lTeam.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lTeam);

        team = new JTextField();
        team.setSize(300, 30);
        team.setLocation(350, 280);
        team.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(team);

        lSalary = new JLabel("Pensja: ");
        lSalary.setSize(200, 30);
        lSalary.setLocation(150, 325);
        lSalary.setFont(new Font("Arial", Font.PLAIN, 30));
        //lSalary.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lSalary);

        salary = new JTextField();
        salary.setSize(300, 30);
        salary.setLocation(350, 325);
        salary.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(salary);

        lPhone = new JLabel("Nr telefonu:");
        lPhone.setSize(200, 30);
        lPhone.setLocation(150, 370);
        lPhone.setFont(new Font("Arial", Font.PLAIN, 30));
        //lPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lPhone);

        phone = new JTextField();
        phone.setSize(300, 30);
        phone.setLocation(350, 370);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(phone);

        lBonus = new JLabel("Bonus:");
        lBonus.setSize(200, 30);
        lBonus.setLocation(150, 415);
        lBonus.setFont(new Font("Arial", Font.PLAIN, 30));
        lBonus.setVisible(false);
        this.add(lBonus);

        bonus = new JTextField();
        bonus.setSize(300, 30);
        bonus.setLocation(350, 460);
        bonus.setFont(new Font("Arial", Font.PLAIN, 25));
        bonus.setVisible(false);
        this.add(bonus);

        lCard = new JLabel("Nr karty:");
        lCard.setSize(200, 30);
        lCard.setLocation(150, 460);
        lCard.setFont(new Font("Arial", Font.PLAIN, 30));
        lCard.setVisible(false);
        this.add(lCard);

        card = new JTextField();
        card.setSize(300, 30);
        card.setLocation(350, 415);
        card.setFont(new Font("Arial", Font.PLAIN, 25));
        card.setVisible(false);
        this.add(card);

        lProvision = new JLabel("Prowizja:");
        lProvision.setSize(200, 30);
        lProvision.setLocation(150, 415);
        lProvision.setFont(new Font("Arial", Font.PLAIN, 30));
        lProvision.setVisible(false);
        this.add(lProvision);

        provision = new JTextField();
        provision.setSize(300, 30);
        provision.setLocation(350, 415);
        provision.setFont(new Font("Arial", Font.PLAIN, 25));
        provision.setVisible(false);
        this.add(provision);

        lLimit = new JLabel("Limit prowizji:");
        lLimit.setSize(200, 30);
        lLimit.setLocation(150, 460);
        lLimit.setFont(new Font("Arial", Font.PLAIN, 30));
        lLimit.setVisible(false);
        //lLimit.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lLimit);

        limit = new JTextField();
        limit.setSize(300, 30);
        limit.setLocation(350, 460);
        limit.setFont(new Font("Arial", Font.PLAIN, 25));
        limit.setVisible(false);
        this.add(limit);

        status = new JLabel();
        status.setSize(400, 30);
        status.setLocation(190, 480);
        status.setFont(new Font("Arial", Font.PLAIN, 15));
        status.setVisible(false);
        status.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(status);

        returnBtn = new JButton("Powrót");
        returnBtn.setSize(80, 40);
        returnBtn.setLocation(250, 520);
        this.add(returnBtn);

        addBtn = new JButton("Dodaj");
        addBtn.setSize(80, 40);
        addBtn.setLocation(450, 520);
        this.add(addBtn);

        actionListeners.choiceActionListener(this, choice, addBtn);
    }
}
