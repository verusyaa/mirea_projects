import java.awt.*;

public class SquareShape extends BaseShape {
    public SquareShape(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}

