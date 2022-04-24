package com.company.view;

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
        actionListeners.menuActionListeners(this, menuPanel);
        this.setVisible(true);
    }
//    public void newWindow() {
//        this.getContentPane().removeAll();
////        box.remove(panel);
//        AddWindow addWindow = new AddWindow();
//        this.getContentPane().add(addWindow);
//        addWindow.returnBtn.addActionListener(e -> this.dispose());
//
////        JButton btn = new JButton("eee");
////        box.add(add);
//////        Box box2 = new Box(BoxLayout.Y_AXIS);
//////        box2.add(Box.createVerticalGlue());
//////        box2.add(add);
////        //box.add(Box.createVerticalGlue());
//////        box.removeAll();
//////        box.add(add);
////        //box.add(Box.createVerticalGlue());
//////        box.add(Box.createVerticalGlue());
//////        box.add(Box.createHorizontalGlue());
//////        box.add(Box.createHorizontalGlue());
////        //this.setContentPane(box2);
//        this.getContentPane().revalidate();
//        this.getContentPane().repaint();
//        System.out.println("dziala");
//    }
}
