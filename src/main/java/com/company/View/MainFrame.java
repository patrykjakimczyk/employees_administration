package com.company.View;

import com.company.Controller.ButtonsController;

import javax.swing.*;
import java.awt.*;

public final class MainFrame extends JFrame {
    private static MainFrame instance = null;

    public MainFrame() {
        this.setSize(800, 600);
        this.setName("Company");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        MenuPanel menuPanel = MenuPanel.getMenuPanel();
        this.add(menuPanel);
        ButtonsController.menuActionListeners(this, menuPanel);
        this.setVisible(true);
    }

    public static MainFrame getMainFrame() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void changeView(JPanel nextView) {
        this.getContentPane().removeAll();
        this.getContentPane().add(nextView);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
