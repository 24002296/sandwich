/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jsandwichi;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JSandWichi extends JFrame {
    

    private final String[] fillings = {"Chicken", "Beef", "Veggie"};
    private final double[] fillingPrices = {5.50, 6.50, 4.50};
    
    private final String[] breads = {"Rye", "Whole Wheat", "Ciabatta"};
    private final double[] breadPrices = {2.00, 2.50, 3.00};
    
    
    private JList<String> fillingList;
    private JList<String> breadList;
    private JLabel priceLabel;
    
    public JSandWichi() {
        setTitle("Sublime Sandwich Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(400, 300);
    
        JLabel title = new JLabel("Build Your Sandwich", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        

        JPanel fillingPanel = new JPanel(new BorderLayout());
        fillingPanel.add(new JLabel("Choose Filling:"), BorderLayout.NORTH);
        fillingList = new JList<>(fillings);
        fillingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fillingList.setSelectedIndex(0);
        fillingList.setBorder(BorderFactory.createEtchedBorder());
        fillingPanel.add(new JScrollPane(fillingList), BorderLayout.CENTER);
        centerPanel.add(fillingPanel);
        
     
        JPanel breadPanel = new JPanel(new BorderLayout());
        breadPanel.add(new JLabel("Choose Bread:"), BorderLayout.NORTH);
        breadList = new JList<>(breads);
        breadList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        breadList.setSelectedIndex(0); 
        breadList.setBorder(BorderFactory.createEtchedBorder());
        breadPanel.add(new JScrollPane(breadList), BorderLayout.CENTER);
        centerPanel.add(breadPanel);
        
        add(centerPanel, BorderLayout.CENTER);
        
    
        JPanel bottomPanel = new JPanel();
        priceLabel = new JLabel("Total Price: $7.50");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(priceLabel);
        add(bottomPanel, BorderLayout.SOUTH);
   
        ListSelectionListener listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updatePrice();
            }
        };
        fillingList.addListSelectionListener(listener);
        breadList.addListSelectionListener(listener);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void updatePrice() {
        int fillingIndex = fillingList.getSelectedIndex();
        int breadIndex = breadList.getSelectedIndex();
        
     
        if (fillingIndex == -1 || breadIndex == -1) return;
        
        double total = fillingPrices[fillingIndex] + breadPrices[breadIndex];
        priceLabel.setText(String.format("Total Price: $%.2f", total));
    }
    
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> new JSandWichi());
    }
}
