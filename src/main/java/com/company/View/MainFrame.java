package com.company.View;

import com.company.Controller.ButtonsController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setSize(800, 600);
        this.setName("Company");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        MenuPanel menuPanel = new MenuPanel();
        this.add(menuPanel);
        ButtonsController.menuActionListeners(this, menuPanel);
        this.setVisible(true);
    }

    public void changeView(JPanel nextView) {
        this.getContentPane().removeAll();
        this.getContentPane().add(nextView);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
