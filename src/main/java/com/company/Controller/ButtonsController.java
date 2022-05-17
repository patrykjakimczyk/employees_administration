package com.company.Controller;

import com.company.DB.DataBaseController;
import com.company.Model.List;
import com.company.View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsController {
    private static int index = 0;
    private static int size;

    public static void menuActionListeners(MainFrame frame, MenuPanel menuPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == menuPanel.list) {
                    ListPanel listPanel = new ListPanel();
                    listPanelActionListeners(frame, listPanel, menuPanel);
                    ListController.updateListOfEmployees();
                    size = List.getListOfEmployees().size();
                    DisplayController.displayEmployee(List.getListOfEmployees().get(0), listPanel, index);
                    frame.changeView(listPanel);
                } else if (source == menuPanel.addEmployee) {
                    AddPanel addPanel = new AddPanel();
                    frame.changeView(addPanel);
                    addPanelActionListeners(frame, addPanel, menuPanel);
                } else if (source == menuPanel.searchEmployee) {
                    SearchPanel searchPanel = new SearchPanel();
                    frame.changeView(searchPanel);
                    searchActionListener(frame, searchPanel, menuPanel);
                } else if (source == menuPanel.exit) {
                    System.exit(0);
                }
            }
        };
        menuPanel.list.addActionListener(actionListener);
        menuPanel.addEmployee.addActionListener(actionListener);
        menuPanel.searchEmployee.addActionListener(actionListener);
        menuPanel.exit.addActionListener(actionListener);
    }

    public static void listPanelActionListeners(MainFrame frame, ListPanel listPanel, MenuPanel menuPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == listPanel.returnBtn) {
                    frame.changeView(menuPanel);
                } else if (source == listPanel.nextBtn) {
                    ListController.updateListOfEmployees();
                    if (index + 1 < size) {
                        index++;
                        DisplayController.displayEmployee(List.getListOfEmployees().get(index), listPanel, index);
                        frame.changeView(listPanel);
                    }
                } else if (source == listPanel.prevBtn) {
                    if (index - 1 >= 0) {
                        index--;
                        DisplayController.displayEmployee(List.getListOfEmployees().get(index), listPanel, index);
                        frame.changeView(listPanel);
                    }
                }

            }
        };
        listPanel.returnBtn.addActionListener(actionListener);
        listPanel.nextBtn.addActionListener(actionListener);
        listPanel.prevBtn.addActionListener(actionListener);
    }

    public static void addPanelActionListeners(MainFrame frame, AddPanel addPanel, MenuPanel menuPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == addPanel.returnBtn) {
                    frame.changeView(menuPanel);
                }
            }
        };
        addPanel.returnBtn.addActionListener(actionListener);
    }

    public static void choiceActionListener(AddPanel addPanel, JComboBox choice, JButton addBtn) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                Object chosen = choice.getSelectedItem();
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

                        if (AddingAndValidationController.addEmployeeWithValidation(pesel, name, lname, job, team, salary, phone, bonus, card)) {
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
                        if (AddingAndValidationController.addEmployeeWithValidation(pesel, name, lname, job, salary, team, phone, provision, limit)) {
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
                        if (AddingAndValidationController.addEmployeeWithValidation(pesel, name, lname, job, team, salary, phone)) {
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
            }
        };
        choice.addActionListener(actionListener);
        addBtn.addActionListener(actionListener);
    }

    public static void searchActionListener(MainFrame frame, SearchPanel searchPanel, MenuPanel menuPanel) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == searchPanel.searchBtn) {
                    ListController.updateListOfEmployees();
                    int index = ListController.isEmployeeExists(searchPanel.search.getText());
                    if (index == -1) {
                        searchPanel.status.setForeground(Color.red);
                        searchPanel.status.setText("Entered pesel doesn't match any of employees");
                        searchPanel.status.setVisible(true);
                    } else {
                        searchPanel.status.setText("");
                        DeletePanel deletePanel = new DeletePanel();
                        frame.changeView(deletePanel);
                        deleteActionListener(frame, searchPanel, deletePanel, index);
                        System.out.println(ListController.isEmployeeExists(searchPanel.search.getText()));
                        DisplayController.deleteView(List.getListOfEmployees().get(index), deletePanel);
                    }

                } else if (source == searchPanel.returnBtn) {
                    frame.changeView(menuPanel);
                }
            }
        };
        searchPanel.searchBtn.addActionListener(actionListener);
        searchPanel.returnBtn.addActionListener(actionListener);
    }

    public static void deleteActionListener(MainFrame frame, SearchPanel searchPanel, DeletePanel deletePanel, int index) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == deletePanel.deleteBtn) {
                    ListController.updateListOfEmployees();
                    boolean isDeleted = DataBaseController.deleteEmployeeFromDB(List.getListOfEmployees().get(index).getPesel());
                    if (isDeleted == true) {
                        deletePanel.status.setForeground(Color.green);
                        deletePanel.status.setText("Employee has been successfully deleted");
                        deletePanel.status.setVisible(true);
                    } else {
                        deletePanel.status.setForeground(Color.red);
                        deletePanel.status.setText("Employee hasn't been deleted");
                        deletePanel.status.setVisible(true);
                    }
                    deletePanel.deleteBtn.setEnabled(false);
                } else if (source == deletePanel.returnBtn) {
                    frame.changeView(searchPanel);
                    searchPanel.status.setVisible(false);
                }
            }
        };
        deletePanel.returnBtn.addActionListener(actionListener);
        deletePanel.deleteBtn.addActionListener(actionListener);
    }
}
