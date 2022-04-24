package com.company.view;

import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {
    JLabel pesel;
    JLabel name;
    JLabel lastName;
    JLabel job;
    JLabel salary;
    JLabel phone;
    JLabel bonus;
    JLabel card;
    JLabel provision;
    JLabel limit;
    JLabel position;
    JButton returnBtn;
    JButton prevBtn;
    JButton nextBtn;

    ListPanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel lpesel = new JLabel("Pesel: ");
        lpesel.setSize(200, 30);
        lpesel.setLocation(150, 70);
        lpesel.setFont(new Font("Arial", Font.PLAIN, 30));
        //lpesel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lpesel);

        pesel = new JLabel();
        pesel.setSize(300, 30);
        pesel.setLocation(350, 70);
        pesel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(pesel);

        JLabel lname = new JLabel("Imie: ");
        lname.setSize(200, 30);
        lname.setLocation(150, 115);
        lname.setFont(new Font("Arial", Font.PLAIN, 30));
        //lname.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lname);

        name = new JLabel();
        name.setSize(300, 30);
        name.setLocation(350, 115);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(name);

        JLabel lLastName = new JLabel("Nazwisko: ");
        lLastName.setSize(200, 30);
        lLastName.setLocation(150, 160);
        lLastName.setFont(new Font("Arial", Font.PLAIN, 30));
        //lLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lLastName);

        lastName = new JLabel();
        lastName.setSize(300, 30);
        lastName.setLocation(350, 160);
        lastName.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(lastName);

        JLabel ljob = new JLabel("Stanowisko: ");
        ljob.setSize(200, 30);
        ljob.setLocation(150, 205);
        ljob.setFont(new Font("Arial", Font.PLAIN, 30));
        //ljob.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(ljob);

        job = new JLabel();
        job.setSize(300, 30);
        job.setLocation(350, 205);
        job.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(job);

        JLabel lsalary = new JLabel("Pensja: ");
        lsalary.setSize(200, 30);
        lsalary.setLocation(150, 250);
        lsalary.setFont(new Font("Arial", Font.PLAIN, 30));
        //lsalary.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lsalary);

        salary = new JLabel();
        salary.setSize(300, 30);
        salary.setLocation(350, 250);
        salary.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(salary);

        JLabel lphone = new JLabel("Nr telefonu:");
        lphone.setSize(200, 30);
        lphone.setLocation(150, 295);
        lphone.setFont(new Font("Arial", Font.PLAIN, 30));
        //lphone.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lphone);

        phone = new JLabel();
        phone.setSize(300, 30);
        phone.setLocation(350, 295);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(phone);

        JLabel lBonus = new JLabel("Bonus:");
        lBonus.setSize(200, 30);
        lBonus.setLocation(150, 340);
        lBonus.setFont(new Font("Arial", Font.PLAIN, 30));
        //lBonus.setHorizontalAlignment(SwingConstants.RIGHT);
        lBonus.setVisible(false);
        this.add(lBonus);

        bonus = new JLabel();
        bonus.setSize(300, 30);
        bonus.setLocation(350, 340);
        bonus.setFont(new Font("Arial", Font.PLAIN, 25));
        bonus.setVisible(false);
        this.add(bonus);

        JLabel lCard = new JLabel("Nr karty biznesowej:");
        lCard.setSize(200, 30);
        lCard.setLocation(150, 385);
        lCard.setFont(new Font("Arial", Font.PLAIN, 30));
        //lCard.setHorizontalAlignment(SwingConstants.RIGHT);
        lCard.setVisible(false);
        this.add(lCard);

        card = new JLabel();
        card.setSize(300, 30);
        card.setLocation(350, 385);
        card.setFont(new Font("Arial", Font.PLAIN, 25));
        card.setVisible(false);
        this.add(card);

        JLabel lProvision = new JLabel("Prowizja:");
        lProvision.setSize(200, 30);
        lProvision.setLocation(150, 340);
        lProvision.setFont(new Font("Arial", Font.PLAIN, 30));
        //lProvision.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lProvision);

        provision = new JLabel();
        provision.setSize(300, 30);
        provision.setLocation(350, 340);
        provision.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(provision);

        JLabel lLimit = new JLabel("Limit prowizji:");
        lLimit.setSize(200, 30);
        lLimit.setLocation(150, 385);
        lLimit.setFont(new Font("Arial", Font.PLAIN, 30));
        //lLimit.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(lLimit);

        limit = new JLabel();
        limit.setSize(300, 30);
        limit.setLocation(350, 385);
        limit.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(limit);

        position = new JLabel("Pracownik: ");
        position.setSize(150, 30);
        position.setLocation(330, 450);
        position.setFont(new Font("Arial", Font.PLAIN, 15));
        //position.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(position);

        returnBtn = new JButton("Powrót");
        //returnBtn.addActionListener(this::actionPerformed);
        returnBtn.setSize(80, 40);
        returnBtn.setLocation(150, 500);
        this.add(returnBtn);

        prevBtn = new JButton("Poprzedni");
        prevBtn.setSize(100, 40);
        prevBtn.setLocation(420, 500);
        this.add(prevBtn);

        nextBtn = new JButton("Następny");
        nextBtn.setSize(100, 40);
        nextBtn.setLocation(550, 500);
        this.add(nextBtn);
    }
}
