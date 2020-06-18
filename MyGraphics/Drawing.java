package MyGraphics;

import java.awt.*;
import javax.swing.JFrame;

public class Drawing extends Canvas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Drawing();
        canvas.setSize(400, 400);

        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Метод, который рисует овал внутри
    // переданного прямоугольника. Сам прямоугольник он не рисует.
    public void boxOval(Graphics g, Rectangle bb) {
        g.fillOval(bb.x, bb.y, bb.width, bb.height);
    }

    public void RecMickey(Graphics g,Rectangle bb)
    {
        // Голова
        boxOval(g, bb);

        // Уши будут в два раза меньше
        int dx = bb.width / 2;
        int dy = bb.height / 2;
        // Прямоугольник отвечающий за ухо
        Rectangle half = new Rectangle(bb.x, bb.y, dx, dy);

        // Передвигаем прямоугольник влево и вверх
        half.translate(-dx / 2, -dy / 2);
        boxOval(g, half);

        if(half.width>1 && half.height>1)
            RecMickey(g,half);

        // Передвигаем прямоугольник вправо
        half.translate(dx * 2, 0);
        boxOval(g, half);

        if(half.width>1 && half.height>1)
            RecMickey(g,half);
    }

    // Рисуем Микки Мауса
//    public void mickey(Graphics g, Rectangle bb) {
//        // Голова
//        boxOval(g, bb);
//
//        // Уши будут в два раза меньше
//        int dx = bb.width / 2;
//        int dy = bb.height / 2;
//        // Прямоугольник отвечающий за ухо
//        Rectangle half = new Rectangle(bb.x, bb.y, dx, dy);
//
//        // Передвигаем прямоугольник влево и вверх
//        half.translate(-dx / 2, -dy / 2);
//        boxOval(g, half);
//
//        // Передвигаем прямоугольник вправо
//        half.translate(dx * 2, 0);
//        boxOval(g, half);
//    }

    public void JapaneseFlag(Graphics g, Rectangle r)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,400,400);
        g.setColor(Color.WHITE);
        g.fillRect(r.x,r.y,r.width,r.height);
        Rectangle sun=new Rectangle(r.x+r.width/3,r.y+r.height/3,r.width/3,r.width/3);
        g.setColor(Color.RED);
        boxOval(g,sun);
    }

    public void paint(Graphics g) {
        // Вызываем метод для рисования мыши
        RecMickey(g, new Rectangle(150, 150, 100, 100));
     //   JapaneseFlag(g,new Rectangle(50,50,100,60));
    }
}
