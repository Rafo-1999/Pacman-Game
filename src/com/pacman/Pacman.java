package com.pacman;

import javax.swing.*;

public class Pacman extends JFrame {

    public Pacman() {
        initUI();
    }

    private void initUI() {
        add(new MainMenu(this));
    }

    public static void main(String[] args) {

//        EventQueue.invokeLater(() -> {
//            var ex = new Pacman();
//            ex.setVisible(true);
//        });
//
        new Pacman().setVisible(true);

    }

}
