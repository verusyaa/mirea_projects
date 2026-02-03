import java.awt.*;

public abstract class BaseShape {
    protected int x;
    protected int y;
    protected int size;
    protected Color color;

    public BaseShape(int x, int y, int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public abstract void draw(Graphics g);
}

