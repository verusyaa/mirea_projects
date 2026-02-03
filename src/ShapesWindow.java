import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ShapesWindow extends JPanel {
    private ArrayList<BaseShape> shapes = new ArrayList<>();
    private Random rnd = new Random();

    public ShapesWindow() {
        setPreferredSize(new Dimension(700, 500));
        generate();
    }

    private void generate() {
        for (int i = 0; i < 20; i++) {
            int size = 30 + rnd.nextInt(100);
            int x = rnd.nextInt(650);
            int y = rnd.nextInt(450);
            Color c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));

            if (rnd.nextBoolean()) {
                shapes.add(new SquareShape(x, y, size, c));
            } else {
                shapes.add(new EllipseShape(x, y, size, c));
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BaseShape s : shapes) {
            s.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShapesWindow panel = new ShapesWindow();
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

