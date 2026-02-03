import java.awt.*;

public class EllipseShape extends BaseShape {
    public EllipseShape(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size / 2);
    }
}

