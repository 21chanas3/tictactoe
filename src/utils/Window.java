package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window {

    GameState state = GameState.BLOCKING;
    int blockedCells = 0;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JButton[][] boardButtons = new JButton[3][9];

    public Window() {
        JFrame frame = new JFrame("3D Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,9));
        generateButtons(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void generateButtons(JFrame frame) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                JButton newButton = new JButton();
                newButton.setText("-");
                newButton.setBackground(Color.WHITE);
                newButton.addActionListener(new ButtonListener(this));
                frame.add(newButton);
                boardButtons[i][j] = newButton;
            }
        }
    }

    public void setState(GameState state) {
        this.state = state;
    }
    public GameState getState() {
        return state;
    }

    public void addCellBlocked() {
        this.blockedCells++;
    }

    public int cellsBlocked(){
        return blockedCells;
    }

}
