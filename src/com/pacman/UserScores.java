package com.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserScores extends JFrame {

    JFrame jFrame;
    public UserScores( JFrame jFrame) {
        this.jFrame = jFrame;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(210, 270));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - 250, dim.height / 2 - 200);

        addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.println("pressed");
                if ((ke.getKeyCode() == KeyEvent.VK_Q) && ((ke.getModifiers() & KeyEvent.SHIFT_MASK) != 0) && ((ke.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }


        });


        JTable jTable2 = new JTable();
        JButton jButton1 = new JButton();
        JScrollPane jScrollPane2 = new JScrollPane(jTable2);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        File file = new File("src/resources/images/allScores.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int column = 0;
        while (sc.hasNextLine()) {
            column++;
            sc.nextLine();
        }
        int i = 0, j = 0;
        Object[][] arr = new Object[column][2];
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split(" ");

                arr[i][0] = splitLine[0];
                arr[i][1] = splitLine[1];
                ++i;
            }
        }



        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                arr,
                new String [] {
                        "Name", "Score"
                }
        ));
//        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Back");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                jFrame.setVisible(true);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }

}