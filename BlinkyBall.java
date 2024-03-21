import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{
    // Constructors
    public BlinkyBall()
    {
        super();
    }

    public BlinkyBall(int x, int y)
    {
        super(x, y);
    }

    public BlinkyBall(int x, int y, int wid, int ht)
    {
        super(x, y, wid, ht);
    }

    public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
    {
        super(x, y, wid, ht, Color.BLACK, xSpd, ySpd);
    }

    public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
    {
        super(x, y, wid, ht, col, xSpd, ySpd);
    }

    // Method to generate random color
    private Color randomColor()
    {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }

    // Override moveAndDraw method to change color every time the ball moves
    @Override
    public void moveAndDraw(Graphics window)
    {
        // Change color before moving and drawing
        setColor(randomColor());
        super.moveAndDraw(window);
    }
}
