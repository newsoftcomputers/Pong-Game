import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {
    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200, 10, 10); // Default values for position and size
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y, 10, 10); // Default size for the ball
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h) {
        super(x, y, w, h); // Custom size
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color col) {
        super(x, y, w, h, col); // Custom size and color
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
        super(x, y, w, h, col); // Custom size and color
        xSpeed = xSpd;
        ySpeed = ySpd;
    }

    public void setXSpeed(int xSpd) {
        xSpeed = xSpd;
    }

    public void setYSpeed(int ySpd) {
        ySpeed = ySpd;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public void moveAndDraw(Graphics window) {
        // draw a white ball at old ball location
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getWidth(), getHeight());

        setX(getX() + xSpeed);
        setY(getY() + ySpeed);

        // draw the ball at its new location
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Ball) {
            Ball otherBall = (Ball) obj;
            return super.equals(obj) && xSpeed == otherBall.getXSpeed() && ySpeed == otherBall.getYSpeed();
        }
        return false;
    }

    public String toString() {
        return super.toString() + ", xSpeed: " + xSpeed + ", ySpeed: " + ySpeed;
    }
}
