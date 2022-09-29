package com.company.Controller;

import com.company.Model.Employee;
import com.company.Model.EmployeesList;
import com.company.Model.Manager;
import com.company.Model.Tradesman;
import com.company.View.EditPanel;
import com.company.View.ListPanel;
import com.company.View.UpdatePanel;

public final class DisplayController {
    public static void displayEmployee(Employee e, ListPanel listPanel, int index) {
        ListController.updateListOfEmployees();
        int size = EmployeesList.getListOfEmployees().size();
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

    public static void editView(Employee e, EditPanel editPanel) {

        editPanel.pesel.setText(e.getPesel());
        editPanel.name.setText(e.getName());
        editPanel.lastName.setText(e.getLastName());
        editPanel.job.setText(e.getJob());
        editPanel.team.setText(String.valueOf(e.getTeam()));
        editPanel.salary.setText(String.valueOf(e.getSalary()));
        editPanel.phone.setText(String.valueOf(e.getPhoneNumber()));

        if (e instanceof Tradesman) {
            Tradesman tm = (Tradesman) e;

            editPanel.provision.setText(String.valueOf(tm.getProvision()));
            editPanel.limit.setText(String.valueOf(tm.getLimitOfProvision()));
            editPanel.lBonus.setVisible(false);
            editPanel.lCard.setVisible(false);
            editPanel.lLimit.setVisible(true);
            editPanel.lProvision.setVisible(true);
            editPanel.bonus.setVisible(false);
            editPanel.card.setVisible(false);
            editPanel.limit.setVisible(true);
            editPanel.provision.setVisible(true);
        } else if (e instanceof Manager) {
            Manager m = (Manager) e;
            editPanel.bonus.setText(String.valueOf(m.getBonusSalary()));
            editPanel.card.setText(m.getNrOfBussinessCard());
            editPanel.lBonus.setVisible(true);
            editPanel.lCard.setVisible(true);
            editPanel.lLimit.setVisible(false);
            editPanel.lProvision.setVisible(false);
            editPanel.bonus.setVisible(true);
            editPanel.card.setVisible(true);
            editPanel.limit.setVisible(false);
            editPanel.provision.setVisible(false);
        } else {
            editPanel.lBonus.setVisible(false);
            editPanel.lCard.setVisible(false);
            editPanel.lLimit.setVisible(false);
            editPanel.lProvision.setVisible(false);
            editPanel.bonus.setVisible(false);
            editPanel.card.setVisible(false);
            editPanel.limit.setVisible(false);
            editPanel.provision.setVisible(false);
        }
    }

    public static void updateView(Employee e, UpdatePanel updatePanel) {
        updatePanel.pesel.setText(e.getPesel());
        updatePanel.name.setText(e.getName());
        updatePanel.lastName.setText(e.getLastName());
        updatePanel.job.setText(e.getJob());
        updatePanel.team.setText(String.valueOf(e.getTeam()));
        updatePanel.salary.setText(String.valueOf(e.getSalary()));
        updatePanel.phone.setText(String.valueOf(e.getPhoneNumber()));

        if (e instanceof Tradesman) {
            Tradesman tm = (Tradesman) e;
            updatePanel.provision.setText(String.valueOf(tm.getProvision()));
            updatePanel.limit.setText(String.valueOf(tm.getLimitOfProvision()));
            updatePanel.job.setEnabled(false);
            updatePanel.lBonus.setVisible(false);
            updatePanel.lCard.setVisible(false);
            updatePanel.lLimit.setVisible(true);
            updatePanel.lProvision.setVisible(true);
            updatePanel.bonus.setVisible(false);
            updatePanel.card.setVisible(false);
            updatePanel.limit.setVisible(true);
            updatePanel.provision.setVisible(true);
        } else if (e instanceof Manager) {
            Manager m = (Manager) e;
            updatePanel.bonus.setText(String.valueOf(m.getBonusSalary()));
            updatePanel.card.setText(m.getNrOfBussinessCard());
            updatePanel.job.setEnabled(false);
            updatePanel.lBonus.setVisible(true);
            updatePanel.lCard.setVisible(true);
            updatePanel.lLimit.setVisible(false);
            updatePanel.lProvision.setVisible(false);
            updatePanel.bonus.setVisible(true);
            updatePanel.card.setVisible(true);
            updatePanel.limit.setVisible(false);
            updatePanel.provision.setVisible(false);
        } else {
            updatePanel.job.setEnabled(true);
            updatePanel.lBonus.setVisible(false);
            updatePanel.lCard.setVisible(false);
            updatePanel.lLimit.setVisible(false);
            updatePanel.lProvision.setVisible(false);
            updatePanel.bonus.setVisible(false);
            updatePanel.card.setVisible(false);
            updatePanel.limit.setVisible(false);
            updatePanel.provision.setVisible(false);
        }
    }
}
