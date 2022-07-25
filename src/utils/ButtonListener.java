package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    Window window;

    public ButtonListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        switch (window.getState()) {
            case BLOCKING -> {
                buttonClicked.setBackground(Color.DARK_GRAY);
                window.addCellBlocked();
                if(window.cellsBlocked() == 2) {
                    window.setState(GameState.O_PLAYING);
                }
            }
            case O_PLAYING -> {
                buttonClicked.setText("O");
                buttonClicked.setBackground(new Color(110,190,255));
                window.setState(GameState.X_PLAYING);
            }
            case X_PLAYING -> {
                buttonClicked.setText("X");
                buttonClicked.setBackground(new Color(255,110,110));
                window.setState(GameState.O_PLAYING);
            }
        }
        buttonClicked.removeActionListener(this);
    }
}
