package utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window {

    GameState state = GameState.BLOCKING;
    int blockedCells = 0;
    JPanel textArea;
    JButton[][][] boardButtons = new JButton[3][3][3];

    public Window() {
        JFrame frame = new JFrame("3D Tic Tac Toe");
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));
        textArea = new JPanel(new GridLayout(1,1));
        JLabel text = new JLabel("Blocking", SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Sans-Serif", Font.PLAIN, 36));
        textArea.add(text);
        JPanel gameArea = generateGameArea();
        JPanel winButtonArea = generateWinArea();
        frame.add(textArea);
        frame.add(gameArea);
        frame.add(winButtonArea);
        frame.setVisible(true);
    }

    private JPanel generateGameArea() {
        JPanel gameArea = new JPanel(new GridLayout(1,3));
        gameArea.setSize(900,300);
        for(int i = 0; i < 3; i++) {
            JPanel threegrid = new JPanel(new GridLayout(3,3));
            for(int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    JButton newButton = new JButton();
                    newButton.setText("-");
                    if(i == 1) {
                        newButton.setBackground(Color.LIGHT_GRAY);
                    } else {
                        newButton.setBackground(Color.WHITE);
                    }
                    newButton.addActionListener(new CellListener(this));
                    threegrid.add(newButton);
                    boardButtons[i][j][k] = newButton;
                }
            }
            gameArea.add(threegrid);
        }
        return gameArea;
    }

    private JPanel generateWinArea() {
        JPanel winArea = new JPanel(new GridLayout(1,2));
        winArea.setBorder(new EmptyBorder(50,10,50,10));
        JButton XWinButton = new JButton();
        XWinButton.setText("Declare X Win");
        XWinButton.addActionListener(new WinListener(this));
        XWinButton.setBackground(new Color(255,110,110));
        JButton OWinButton = new JButton();
        OWinButton.setText("Declare O Win");
        OWinButton.addActionListener(new WinListener(this));
        OWinButton.setBackground(new Color(110,190,255));
        winArea.add(XWinButton);
        winArea.add(OWinButton);
        return winArea;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public JButton[][][] getBoardButtons() {
        return boardButtons;
    }

    public GameState getState() {
        return state;
    }

    public JLabel getText() {
        return (JLabel) textArea.getComponent(0);
    }

    public void addCellBlocked() {
        this.blockedCells++;
    }

    public int cellsBlocked(){
        return blockedCells;
    }

}
