import java.awt.Color;
import java.awt.Graphics;

public class Block {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Block() {
        xPos = 0;
        yPos = 0;
        width = 10;
        height = 10;
        color = Color.BLACK;
    }

    public Block(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = Color.BLACK;
    }

    public Block(int x, int y, int w, int h, Color col) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = col;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void setColor(Color col) {
        color = col;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(xPos, yPos, width, height);
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(xPos, yPos, width, height);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Block) {
            Block otherBlock = (Block) obj;
            return xPos == otherBlock.getX() && yPos == otherBlock.getY() &&
                    width == otherBlock.getWidth() && height == otherBlock.getHeight() &&
                    color.equals(otherBlock.getColor());
        }
        return false;
    }

    public String toString() {
        return "x: " + xPos + ", y: " + yPos + ", width: " + width + ", height: " + height + ", color: " + color;
    }
}
