package com.pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class MainMenu extends JFrame {

    public MainMenu(JFrame jFrame) {
        setVisible(false);
        new MainMenuUI(jFrame).setVisible(true);
    }
}

class MainMenuUI extends JFrame {

    public MainMenuUI(JFrame jFrame) {
        initComponents(jFrame);
    }

    private void initComponents(JFrame jFrame) {

        JLabel img = new JLabel();
        JTextField matrixSize = new JTextField();
        JLabel matrixLabel = new JLabel();
        JButton btnStart = new JButton();
        JButton btnExit = new JButton();
        JLabel highScore = new JLabel();
        JLabel highScoreCount = new JLabel();
        JButton scoreCount = new JButton();

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - 250, dim.height / 2 - 200);

        img.setIcon(new ImageIcon(
                "src/resources/images/pacman_logo.png")); //Sets the image to be displayed as an icon
        img.setPreferredSize(new Dimension(600, 150));

        matrixSize.setText("15");
        matrixSize.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyCode() == KeyEvent.VK_Q) && ((ke.getModifiers() & KeyEvent.SHIFT_MASK) != 0)
                        && ((ke.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    System.exit(0);
                }
                matrixSize.setEditable(((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
                        || ke.getKeyChar() <= KeyEvent.VK_BACK_SPACE)
                        && ((matrixSize.getText().length() < 2) || ke.getKeyChar() <= KeyEvent.VK_BACK_SPACE));
            }
        });

        matrixLabel.setText("Column's size");
        matrixLabel.setForeground(Color.WHITE);

        btnStart.setText("New Game");
        btnStart.addActionListener(evt -> {
            if (Integer.parseInt(matrixSize.getText()) >= 15
                    && Integer.parseInt(matrixSize.getText()) <= 35) {
                setVisible(false);
                Board.N_BLOCKS = Integer.parseInt(matrixSize.getText());
                int blocks = Integer.parseInt(matrixSize.getText());;
                if (blocks == 20 || blocks == 21)
                    Board.N_GHOSTS  = 7;
                else if(blocks == 22 || blocks == 23)
                    Board.N_GHOSTS  = 8;
                else if(blocks == 24 || blocks == 25)
                    Board.N_GHOSTS  = 9;
                else if(blocks == 26 || blocks == 27)
                    Board.N_GHOSTS  = 12;
                else if(blocks == 28 || blocks == 29)
                    Board.N_GHOSTS  = 14;
                else if(blocks == 30 || blocks == 31)
                    Board.N_GHOSTS  = 16;
                else if(blocks == 32 || blocks == 33)
                    Board.N_GHOSTS  = 18;
                else if(blocks == 34 || blocks == 35)
                    Board.N_GHOSTS  = 20;
                else
                    Board.N_GHOSTS = 6;


                Board.levelData = getLevelData(Integer.parseInt(matrixSize.getText()));
                jFrame.add(new Board(jFrame, Integer.parseInt(matrixSize.getText()),
                        getLevelData(Integer.parseInt(matrixSize.getText()))));
                jFrame.setVisible(true);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(evt -> System.exit(0));

        highScore.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        highScore.setText("HighScore:");
        highScore.setForeground(Color.WHITE);

        highScoreCount.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        File file = new File("src/resources/images/liveScore.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNextLine()) {
                String score = sc.nextLine();
                highScoreCount.setText(score);
                highScoreCount.setForeground(Color.WHITE);
            }
        }

        scoreCount.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        scoreCount.setText("Scores");
        scoreCount.setForeground(Color.BLACK);
        scoreCount.addActionListener(evt -> {
            setVisible(false);
            new UserScores(this).setVisible(true);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(matrixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(matrixSize))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scoreCount, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(matrixSize, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(matrixLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scoreCount, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();

        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(matrixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(matrixSize))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(124, 124, 124)
                                                                        .addComponent(highScore, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(55, 55, 55)))
                                                .addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(57, 57, 57))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(highScoreCount)
                                                                        .addGap(60, 60, Short.MAX_VALUE)))))
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(matrixSize, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(matrixLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 29,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(highScoreCount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(highScore, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );

        pack();
    }

    public short[] getLevelData(int n) {
        Matrix matrix = new Matrix();
        BigMatrix bigMatrix = new BigMatrix();
        switch (n) {
            case 15 -> {
                return matrix.levelData15;
            }
            case 16 -> {
                return matrix.levelData16;
            }
            case 17 -> {
                return matrix.levelData17;
            }
            case 18 -> {
                return matrix.levelData18;
            }
            case 19 -> {
                return matrix.levelData19;
            }
            case 20 -> {
                return matrix.levelData20;
            }
            case 21 -> {
                return matrix.levelData21;
            }
            case 22 -> {
                return matrix.levelData22;
            }
            case 23 -> {
                return matrix.levelData23;
            }
            case 24 -> {
                return matrix.levelData24;
            }
            case 25 -> {
                return matrix.levelData25;
            }
            case 26 -> {
                return matrix.levelData26;
            }
            case 27 -> {
                return matrix.levelData27;
            }
            case 28 -> {
                return matrix.levelData28;
            }
            case 29 -> {
                return matrix.levelData29;
            }
            case 30 -> {
                return matrix.levelData30;
            }
            case 31 -> {
                return bigMatrix.levelData31;
            }
            case 32 -> {
                return bigMatrix.levelData32;
            }
            case 33 -> {
                return bigMatrix.levelData33;
            }
            case 34 -> {
                return bigMatrix.levelData34;
            }
            case 35 -> {
                return bigMatrix.levelData35;
            }
        }
        return new short[10];
    }
}