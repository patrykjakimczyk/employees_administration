package com.company.View;

import javax.swing.*;
import java.awt.*;

public final class SearchPanel extends JPanel {
    private static SearchPanel instance = null;
    public JTextField search;
    public JButton returnBtn;
    public JButton searchBtn;
    public JLabel status;

    public SearchPanel() {
        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel title = new JLabel("Searching for employee");
        title.setLocation(130, 20);
        title.setSize(600, 60);
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        this.add(title);

        JLabel lsearch = new JLabel("Enter pesel: ");
        lsearch.setSize(200, 60);
        lsearch.setLocation(170, 235);
        lsearch.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(lsearch);

        search = new JTextField();
        search.setSize(250, 60);
        search.setLocation(350, 235);
        search.setFont(new Font("Arial", Font.PLAIN, 25));
        this.add(search);

        searchBtn = new JButton("Search for employee");
        searchBtn.setSize(160, 40);
        searchBtn.setLocation(320, 330);
        this.add(searchBtn);

        returnBtn = new JButton("Return");
        returnBtn.setSize(160, 40);
        returnBtn.setLocation(320, 450);
        this.add(returnBtn);

        status = new JLabel();
        status.setSize(450, 30);
        status.setLocation(160, 150);
        status.setFont(new Font("Arial", Font.PLAIN, 20));
        status.setVisible(false);
        status.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(status);
    }
    
    public static SearchPanel getSearchPanel() {
        if (instance == null) {
            instance = new SearchPanel();
        }
        return instance;
    }
}
