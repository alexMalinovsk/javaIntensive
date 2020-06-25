package Snake;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        int fieldSize = 600;
        int numOfSideDivision=75;

        frame.setSize(fieldSize+16,fieldSize+39);

        frame.setLocationRelativeTo(null);

        Game game=new Game(numOfSideDivision,numOfSideDivision,fieldSize/numOfSideDivision,10);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_W)
                    game.dir=1;
                if(e.getKeyCode()==KeyEvent.VK_D)
                    game.dir=2;
                if(e.getKeyCode()==KeyEvent.VK_S)
                    game.dir=3;
                if(e.getKeyCode()==KeyEvent.VK_A)
                    game.dir=4;
                if(e.getKeyCode()==KeyEvent.VK_Q)
                    game.pause=!game.pause;
            }
        });

        frame.add(game);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        System.out.print(" \t");
//        for(int i=1;i<11;i++)
//        {
//            System.out.print(i+"\t");
//        }
//        System.out.print("\n");
//        for(int i=1;i<11;i++)
//        {
//            System.out.print(i+"\t");
//            for(int j=1;j<11;j++)
//            {
//                System.out.print(i*j+"\t");
//            }
//            System.out.println();
//        }
    }
}
