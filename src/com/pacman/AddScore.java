package com.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddScore extends javax.swing.JFrame {
    public static int score = 0;
    public AddScore() {
        initComponents();
    }

    private void initComponents() {

        JLabel img = new JLabel();
        JTextField nameField = new JTextField();
        JLabel yourNameIsLabel = new JLabel();
        JLabel yourScoreIs = new JLabel();
        JLabel scoreLabel = new JLabel();
        // Variables declaration - do not modify
        JButton btnAdd = new JButton();

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(540, 260));
        setResizable(false);
        getContentPane().setBackground(new Color(16,17,19));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - 250, dim.height / 2 - 200);

        img.setIcon(new ImageIcon("src/resources/images/congratulations.jpeg")); //Sets the image to be displayed as an icon
        img.setPreferredSize(new Dimension(500, 150));


//        nameField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//
//            }
//        });

        nameField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyCode() == KeyEvent.VK_Q) && ((ke.getModifiers() & KeyEvent.SHIFT_MASK) != 0)
                        && ((ke.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    System.exit(0);
                }
            }
        });

        yourNameIsLabel.setText("Your name is");
        yourNameIsLabel.setForeground(Color.WHITE);

        yourScoreIs.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        yourScoreIs.setText("Your score is");
        yourScoreIs.setForeground(Color.WHITE);

        scoreLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        scoreLabel.setText(String.valueOf(score));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setPreferredSize(new java.awt.Dimension(100, 18));
        scoreLabel.setSize(new java.awt.Dimension(100, 17));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (!nameField.getText().isEmpty()) {
                    try {
                        String s = nameField.getText() + " " + String.valueOf(score) + "\n";
                        Files.write(Paths.get("src/resources/images/allScores.txt"), s.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {

                    }

                    setVisible(false);
//                    EventQueue.invokeLater(() -> {
//                        var ex = new Pacman();
//                        ex.setVisible(true);
//                    });
                    new Pacman().setVisible(true);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(yourNameIsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 9, Short.MAX_VALUE)
                                                .addComponent(yourScoreIs, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(160, 160, 160)
                                                .addComponent(btnAdd)))
                                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(yourNameIsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameField))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(yourScoreIs, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))
        );

        pack();
    }
}
