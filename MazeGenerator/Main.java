package MazeGenerator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze");
        int fieldSize = 600;
        int numSideDivision=75;

        frame.setSize(fieldSize+50,fieldSize+50);

        frame.setLocationRelativeTo(null);

        Maze maze = new Maze(fieldSize,numSideDivision);

        frame.add(maze);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
