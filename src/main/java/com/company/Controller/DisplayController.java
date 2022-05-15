package com.company.Controller;

import com.company.model.Employee;
import com.company.model.List;
import com.company.model.Manager;
import com.company.model.Tradesman;
import com.company.view.DeletePanel;
import com.company.view.ListPanel;

public class DisplayController {
    public static void displayEmployee(Employee e, ListPanel listPanel, int index) {
        int size = List.getListOfEmployees().size();
        index++;
        listPanel.position.setText("Employee: " + index + "/" + size);

        listPanel.pesel.setText(e.getPesel());
        listPanel.name.setText(e.getName());
        listPanel.lastName.setText(e.getLastName());
        listPanel.job.setText(e.getJob());
        listPanel.team.setText(String.valueOf(e.getTeam()));
        listPanel.salary.setText(String.valueOf(e.getSalary()));
        listPanel.phone.setText(String.valueOf(e.getPhoneNumber()));

        if (e instanceof Tradesman) {
            Tradesman tm = (Tradesman) e;
            listPanel.provision.setText(String.valueOf(tm.getProvision()));
            listPanel.limit.setText(String.valueOf(tm.getLimitOfProvision()));
            listPanel.lBonus.setVisible(false);
            listPanel.lCard.setVisible(false);
            listPanel.lLimit.setVisible(true);
            listPanel.lProvision.setVisible(true);
            listPanel.bonus.setVisible(false);
            listPanel.card.setVisible(false);
            listPanel.limit.setVisible(true);
            listPanel.provision.setVisible(true);
        } else if (e instanceof Manager) {
            Manager m = (Manager) e;
            listPanel.bonus.setText(String.valueOf(m.getBonusSalary()));
            listPanel.card.setText(m.getNrOfBussinessCard());
            listPanel.lBonus.setVisible(true);
            listPanel.lCard.setVisible(true);
            listPanel.lLimit.setVisible(false);
            listPanel.lProvision.setVisible(false);
            listPanel.bonus.setVisible(true);
            listPanel.card.setVisible(true);
            listPanel.limit.setVisible(false);
            listPanel.provision.setVisible(false);
        } else {
            listPanel.lBonus.setVisible(false);
            listPanel.lCard.setVisible(false);
            listPanel.lLimit.setVisible(false);
            listPanel.lProvision.setVisible(false);
            listPanel.bonus.setVisible(false);
            listPanel.card.setVisible(false);
            listPanel.limit.setVisible(false);
            listPanel.provision.setVisible(false);
        }
    }

    public static void deleteView(Employee e, DeletePanel deletePanel) {

        deletePanel.pesel.setText(e.getPesel());
        deletePanel.name.setText(e.getName());
        deletePanel.lastName.setText(e.getLastName());
        deletePanel.job.setText(e.getJob());
        deletePanel.team.setText(String.valueOf(e.getTeam()));
        deletePanel.salary.setText(String.valueOf(e.getSalary()));
        deletePanel.phone.setText(String.valueOf(e.getPhoneNumber()));

        if (e instanceof Tradesman) {
            Tradesman tm = (Tradesman) e;
            deletePanel.provision.setText(String.valueOf(tm.getProvision()));
            deletePanel.limit.setText(String.valueOf(tm.getLimitOfProvision()));
            deletePanel.lBonus.setVisible(false);
            deletePanel.lCard.setVisible(false);
            deletePanel.lLimit.setVisible(true);
            deletePanel.lProvision.setVisible(true);
            deletePanel.bonus.setVisible(false);
            deletePanel.card.setVisible(false);
            deletePanel.limit.setVisible(true);
            deletePanel.provision.setVisible(true);
        } else if (e instanceof Manager) {
            Manager m = (Manager) e;
            deletePanel.bonus.setText(String.valueOf(m.getBonusSalary()));
            deletePanel.card.setText(m.getNrOfBussinessCard());
            deletePanel.lBonus.setVisible(true);
            deletePanel.lCard.setVisible(true);
            deletePanel.lLimit.setVisible(false);
            deletePanel.lProvision.setVisible(false);
            deletePanel.bonus.setVisible(true);
            deletePanel.card.setVisible(true);
            deletePanel.limit.setVisible(false);
            deletePanel.provision.setVisible(false);
        } else {
            deletePanel.lBonus.setVisible(false);
            deletePanel.lCard.setVisible(false);
            deletePanel.lLimit.setVisible(false);
            deletePanel.lProvision.setVisible(false);
            deletePanel.bonus.setVisible(false);
            deletePanel.card.setVisible(false);
            deletePanel.limit.setVisible(false);
            deletePanel.provision.setVisible(false);
        }
    }
}
