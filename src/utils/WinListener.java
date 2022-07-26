package utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinListener implements ActionListener {

    Window window;

    public WinListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        char player = buttonClicked.getText().charAt(8);
        JButton[][][] grid = window.getBoardButtons();
        int check = 0;
        for (int i = 0; i < 3; i++) {
            check += check3x3(grid[i], player); // horizontal slicing

            JButton[][] verticalSlice = {{grid[0][i][0], grid[0][i][1], grid[0][i][2]},
                                         {grid[1][i][0], grid[1][i][1], grid[1][i][2]},
                                         {grid[2][i][0], grid[2][i][1], grid[2][i][2]}};
            check += check3x3(verticalSlice, player); // vertical slicing

            JButton[][] faceSlice = {{grid[0][0][i], grid[0][1][i], grid[0][2][i]},
                                     {grid[1][0][i], grid[1][1][i], grid[1][2][i]},
                                     {grid[2][0][i], grid[2][1][i], grid[2][2][i]}};
            check += check3x3(faceSlice, player); // face slicing
        }

        if (grid[0][0][0].getText().charAt(0) == player && grid[1][1][1].getText().charAt(0) == player && grid[2][2][2].getText().charAt(0) == player) {check++;}
        if (grid[0][0][2].getText().charAt(0) == player && grid[1][1][1].getText().charAt(0) == player && grid[2][2][0].getText().charAt(0) == player) {check++;}

        if (check > 0) {
            window.getText().setText(player + " Wins");
        } else {
            if (player == 'X') {
                window.getText().setText("Incorrect X Declaration, O Wins");
            } else if (player == 'O') {
                window.getText().setText("Incorrect O Declaration, X Wins");
            }
        }
    }

    private int check3x3(JButton[][] grid, char player) {
        for(int i = 0; i < 3; i++) {
            if(grid[0][i].getText().charAt(0) == player || grid[1][i].getText().charAt(0) == player || grid[2][i].getText().charAt(0) == player) {return 1;}
            if(grid[i][0].getText().charAt(0) == player || grid[i][1].getText().charAt(0) == player || grid[i][2].getText().charAt(0) == player) {return 1;}
        }
        if(grid[0][0].getText().charAt(0) == player || grid[1][1].getText().charAt(0) == player || grid[2][2].getText().charAt(0) == player) {return 1;}
        if(grid[0][2].getText().charAt(0) == player || grid[1][1].getText().charAt(0) == player || grid[2][0].getText().charAt(0) == player) {return 1;}
        return 0;
    }

}
