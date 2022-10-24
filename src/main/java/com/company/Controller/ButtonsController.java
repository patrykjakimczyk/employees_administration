package com.company.Controller;

import com.company.DB.DataBaseController;
import com.company.Model.EmployeesList;
import com.company.View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public final class ButtonsController {
    private static int index = 0;
    private static int size;

    public static void menuActionListeners(MainFrame frame, MenuPanel menuPanel) {
        MenuPanel finalMenuPanel = menuPanel;
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            ListController.updateListOfEmployees();

            if (source == finalMenuPanel.list) {
                ListPanel listPanel = ListPanel.getListPanel();
                listPanelActionListeners(frame, listPanel, finalMenuPanel);
                size = EmployeesList.getListOfEmployees().size();
                DisplayController.displayEmployee(EmployeesList.getListOfEmployees().get(index), listPanel, index);
                frame.changeView(listPanel);
            } else if (source == finalMenuPanel.addEmployee) {
                AddPanel addPanel = AddPanel.getAddPanel();
                frame.changeView(addPanel);
                addPanelActionListeners(frame, addPanel, finalMenuPanel);
            } else if (source == finalMenuPanel.searchEmployee) {
                SearchPanel searchPanel = SearchPanel.getSearchPanel();
                frame.changeView(searchPanel);
                searchActionListener(frame, searchPanel, finalMenuPanel);
            } else if (source == finalMenuPanel.exit) {
                System.exit(0);
            }
        };

        setListenersForPanel(menuPanel, actionListener);
    }

    public static void listPanelActionListeners(MainFrame frame, ListPanel listPanel, MenuPanel menuPanel) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            size = EmployeesList.getListOfEmployees().size();
            ListController.updateListOfEmployees();

            if (source == listPanel.returnBtn) {
                frame.changeView(menuPanel);
            } else if (source == listPanel.editBtn) {
                EditPanel editPanel = EditPanel.getEditPanel();
                frame.changeView(editPanel);
                DisplayController.editView(EmployeesList.getListOfEmployees().get(index), editPanel);
                listEditActionListener(frame, listPanel, editPanel, index);
            } else if (source == listPanel.nextBtn) {
                if (index  < size - 1) {
                    index++;
                    DisplayController.displayEmployee(EmployeesList.getListOfEmployees().get(index), listPanel, index);
                    frame.changeView(listPanel);
                }
            } else if (source == listPanel.prevBtn) {
                if (index > 0) {
                    index--;
                    DisplayController.displayEmployee(EmployeesList.getListOfEmployees().get(index), listPanel, index);
                    frame.changeView(listPanel);
                }
            }
        };

        setListenersForPanel(listPanel, actionListener);
    }

    public static void addPanelActionListeners(MainFrame frame, AddPanel addPanel, MenuPanel menuPanel) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source == addPanel.returnBtn) {
                frame.changeView(menuPanel);
            }
        };

        setListenersForPanel(addPanel, actionListener);
    }

    public static void choiceActionListener(AddPanel addPanel, JComboBox choice, JButton addBtn) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            Object chosen = choice.getSelectedItem();
            addPanel.status.setText("");

            if (source == choice) {
                if (chosen.equals("Manager")) {
                    addPanel.status.setText("");
                    addPanel.job.setText("Manager");
                    addPanel.job.setEnabled(false);
                    addPanel.lProvision.setVisible(false);
                    addPanel.provision.setVisible(false);
                    addPanel.lLimit.setVisible(false);
                    addPanel.limit.setVisible(false);
                    addPanel.bonus.setVisible(true);
                    addPanel.lBonus.setVisible(true);
                    addPanel.card.setVisible(true);
                    addPanel.lCard.setVisible(true);
                } else if (chosen.equals("Tradesman")) {
                    addPanel.status.setText("");
                    addPanel.job.setText("Tradesman");
                    addPanel.job.setEnabled(false);
                    addPanel.lProvision.setVisible(true);
                    addPanel.provision.setVisible(true);
                    addPanel.lLimit.setVisible(true);
                    addPanel.limit.setVisible(true);
                    addPanel.bonus.setVisible(false);
                    addPanel.lBonus.setVisible(false);
                    addPanel.card.setVisible(false);
                    addPanel.lCard.setVisible(false);
                } else {
                    addPanel.status.setText("");
                    addPanel.job.setText("");
                    addPanel.job.setEnabled(true);
                    addPanel.lProvision.setVisible(false);
                    addPanel.provision.setVisible(false);
                    addPanel.lLimit.setVisible(false);
                    addPanel.limit.setVisible(false);
                    addPanel.bonus.setVisible(false);
                    addPanel.lBonus.setVisible(false);
                    addPanel.card.setVisible(false);
                    addPanel.lCard.setVisible(false);
                }
            } else if (source == addPanel.addBtn) {
                String pesel = addPanel.pesel.getText();
                String name = addPanel.name.getText();
                String lname = addPanel.lastName.getText();
                String job = addPanel.job.getText();
                String team = addPanel.team.getText();
                String salary = addPanel.salary.getText();
                String phone = addPanel.phone.getText();
                String bonus = addPanel.bonus.getText();
                String card = addPanel.card.getText();
                String provision = addPanel.provision.getText();
                String limit = addPanel.limit.getText();

                chosen = choice.getSelectedItem();
                if (chosen.equals(AddPanel.choices[0])) {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, team,
                            salary, phone, bonus, card, false)) {
                        addPanel.status.setForeground(Color.green);
                        addPanel.status.setText("Employee has been successfully added");
                        addPanel.status.setVisible(true);
                        addPanel.pesel.setText("");
                        addPanel.name.setText("");
                        addPanel.lastName.setText("");
                        addPanel.team.setText("");
                        addPanel.salary.setText("");
                        addPanel.phone.setText("");
                        addPanel.bonus.setText("");
                        addPanel.card.setText("");
                    } else {
                        addPanel.status.setForeground(Color.red);
                        addPanel.status.setText("Employee hasn't been added(Entered data are incorrect)");
                        addPanel.status.setVisible(true);
                    }
                } else if (chosen.equals(AddPanel.choices[1])) {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, salary, team,
                            phone, provision, limit, false)) {
                        addPanel.status.setForeground(Color.green);
                        addPanel.status.setText("Employee has been successfully added");
                        addPanel.status.setVisible(true);
                        addPanel.pesel.setText("");
                        addPanel.name.setText("");
                        addPanel.lastName.setText("");
                        addPanel.team.setText("");
                        addPanel.salary.setText("");
                        addPanel.phone.setText("");
                        addPanel.provision.setText("");
                        addPanel.limit.setText("");
                    } else {
                        addPanel.status.setForeground(Color.red);
                        addPanel.status.setText("Employee hasn't been added(Entered data are incorrect)");
                        addPanel.status.setVisible(true);
                    }
                } else {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, team,
                            salary, phone, false)) {
                        addPanel.status.setForeground(Color.green);
                        addPanel.status.setText("Employee has been successfully added");
                        addPanel.status.setVisible(true);
                        addPanel.job.setText("");
                        addPanel.pesel.setText("");
                        addPanel.name.setText("");
                        addPanel.lastName.setText("");
                        addPanel.job.setText("");
                        addPanel.team.setText("");
                        addPanel.salary.setText("");
                        addPanel.phone.setText("");
                    } else {
                        addPanel.status.setForeground(Color.red);
                        addPanel.status.setText("Employee hasn't been added(Entered data are incorrect)");
                        addPanel.status.setVisible(true);

                    }
                }
            }
        };

        if (Arrays.stream(choice.getActionListeners()).toList().isEmpty()) {
            choice.addActionListener(actionListener);
        } else {
            List<ActionListener> listeners =  Arrays.asList(choice.getActionListeners());
            if (!listeners.isEmpty()) {
                listeners.forEach(listener -> choice.removeActionListener(listener));
                choice.addActionListener(actionListener);
            }
        }

        if (Arrays.stream(addBtn.getActionListeners()).toList().isEmpty()) {
            addBtn.addActionListener(actionListener);
        } else {
            List<ActionListener> listeners =  Arrays.asList(addBtn.getActionListeners());
            if (!listeners.isEmpty()) {
                listeners.forEach(listener -> addBtn.removeActionListener(listener));
                addBtn.addActionListener(actionListener);
            }
        }
    }

    public static void searchActionListener(MainFrame frame, SearchPanel searchPanel, MenuPanel menuPanel) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            searchPanel.status.setText("");

            if (source == searchPanel.searchBtn) {
                ListController.updateListOfEmployees();
                int index = ListController.isEmployeeExists(searchPanel.search.getText());
                if (index == -1) {
                    searchPanel.status.setForeground(Color.red);
                    searchPanel.status.setText("Entered pesel doesn't match any of employees");
                    searchPanel.status.setVisible(true);
                } else {
                    searchPanel.status.setText("");
                    EditPanel editPanel = EditPanel.getEditPanel();
                    frame.changeView(editPanel);
                    editActionListener(frame, searchPanel, editPanel, index);
                    DisplayController.editView(EmployeesList.getListOfEmployees().get(index), editPanel);
                }
            } else if (source == searchPanel.returnBtn) {
                frame.changeView(menuPanel);
            }
        };

        setListenersForPanel(searchPanel, actionListener);
    }

    public static void listEditActionListener(MainFrame frame, ListPanel listPanel, EditPanel editPanel, int index) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            editPanel.status.setText("");

            if (source == editPanel.returnBtn) {
                DisplayController.displayEmployee(EmployeesList.getListOfEmployees().get(index), listPanel, index);
                frame.changeView(listPanel);
            } else if (source == editPanel.deleteBtn) {
                boolean isDeleted = DataBaseController.deleteEmployeeFromDB(EmployeesList.getListOfEmployees().get(index).getPesel());
                if (isDeleted) {
                    editPanel.status.setForeground(Color.green);
                    editPanel.status.setText("Employee has been successfully deleted");
                    editPanel.status.setVisible(true);
                    editPanel.deleteBtn.setEnabled(false);
                    editPanel.updateBtn.setEnabled(false);
                } else {
                    editPanel.status.setForeground(Color.red);
                    editPanel.status.setText("Employee hasn't been deleted");
                    editPanel.status.setVisible(true);
                }
                ListController.updateListOfEmployees();
            } else if (source == editPanel.updateBtn) {
                UpdatePanel updatePanel = UpdatePanel.getUpdatePanel();
                frame.changeView(updatePanel);
                updateActionListener(frame, editPanel, updatePanel, index);
                DisplayController.updateView(EmployeesList.getListOfEmployees().get(index), updatePanel);
            }

        };

        setListenersForPanel(editPanel, actionListener);
    }

    public static void editActionListener(MainFrame frame, SearchPanel searchPanel, EditPanel editPanel, int index) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            editPanel.status.setText("");

            if (source == editPanel.deleteBtn) {
                ListController.updateListOfEmployees();
                boolean isDeleted = DataBaseController.deleteEmployeeFromDB(EmployeesList.getListOfEmployees().get(index).getPesel());
                if (isDeleted) {
                    editPanel.status.setForeground(Color.green);
                    editPanel.status.setText("Employee has been successfully deleted");
                    editPanel.status.setVisible(true);
                    editPanel.deleteBtn.setEnabled(false);
                    editPanel.updateBtn.setEnabled(false);
                    ButtonsController.index = 0;
                } else {
                    editPanel.status.setForeground(Color.red);
                    editPanel.status.setText("Employee hasn't been deleted");
                    editPanel.status.setVisible(true);
                }
            } else if (source == editPanel.updateBtn) {
                UpdatePanel updatePanel = UpdatePanel.getUpdatePanel();
                frame.changeView(updatePanel);
                updateActionListener(frame, editPanel, updatePanel, index);
                DisplayController.updateView(EmployeesList.getListOfEmployees().get(index), updatePanel);
                searchPanel.status.setVisible(false);
            } else if (source == editPanel.returnBtn) {
                frame.changeView(searchPanel);
                searchPanel.status.setVisible(false);
                searchPanel.search.setText("");
            }
        };

        setListenersForPanel(editPanel, actionListener);
    }

    public static void updateActionListener(MainFrame frame, EditPanel editPanel, UpdatePanel updatePanel, int index) {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            updatePanel.status.setText("");

            if (source == updatePanel.updateBtn) {
                String pesel = updatePanel.pesel.getText();
                String name = updatePanel.name.getText();
                String lname = updatePanel.lastName.getText();
                String job = updatePanel.job.getText();
                String team = updatePanel.team.getText();
                String salary = updatePanel.salary.getText();
                String phone = updatePanel.phone.getText();
                String bonus = updatePanel.bonus.getText();
                String card = updatePanel.card.getText();
                String provision = updatePanel.provision.getText();
                String limit = updatePanel.limit.getText();
                if (job.equals("Manager")) {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, team,
                            salary, phone, bonus, card, true)) {
                        updatePanel.status.setForeground(Color.green);
                        updatePanel.status.setText("Employee has been successfully updated");
                        updatePanel.status.setVisible(true);
                    } else {
                        updatePanel.status.setForeground(Color.red);
                        updatePanel.status.setText("Employee hasn't been updated(Entered data are incorrect)");
                        updatePanel.status.setVisible(true);
                    }
                } else if (job.equals("Tradesman")) {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, team,
                            salary, phone, provision, limit, true)) {
                        updatePanel.status.setForeground(Color.green);
                        updatePanel.status.setText("Employee has been successfully updated");
                        updatePanel.status.setVisible(true);
                    } else {
                        updatePanel.status.setForeground(Color.red);
                        updatePanel.status.setText("Employee hasn't been updated(Entered data are incorrect)");
                        updatePanel.status.setVisible(true);
                    }
                } else {
                    if (AddingAndValidationController.employeeValidation(pesel, name, lname, job, team,
                            salary, phone, true)) {
                        updatePanel.status.setForeground(Color.green);
                        updatePanel.status.setText("Employee has been successfully updated");
                        updatePanel.status.setVisible(true);
                    } else {
                        updatePanel.status.setForeground(Color.red);
                        updatePanel.status.setText("Employee hasn't been updated(Entered data are incorrect)");
                        updatePanel.status.setVisible(true);
                    }
                }
            } else if (source == updatePanel.returnBtn) {
                DisplayController.editView(EmployeesList.getListOfEmployees().get(index), editPanel);
                frame.changeView(editPanel);
                editPanel.status.setVisible(false);
            }
        };

        setListenersForPanel(updatePanel, actionListener);
    }

    private static void setListenersForPanel(JPanel panel, ActionListener actionListener) {
        List<JButton> buttons = Arrays.stream(panel.getComponents())
                .filter(comp -> comp instanceof JButton)
                .map(comp -> (JButton) comp)
                .toList();

        for (JButton button : buttons) {
            List<ActionListener> listeners = Arrays.asList(button.getActionListeners());
            if (!listeners.isEmpty()) {
                listeners.forEach(listener -> button.removeActionListener(listener));
                button.addActionListener(actionListener);
            } else {
                button.addActionListener(actionListener);
            }
        }
    }
}
