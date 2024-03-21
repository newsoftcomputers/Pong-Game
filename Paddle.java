import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   // instance variables
   private int speed;

   // Constructors
    public Paddle() {
        super(10, 10, 10, 80); // Default position and size
        speed = 5;
    }

   public Paddle(int x, int y, int h)
   {
      super(x, y, 10, h);
      speed = 5;
   }

   public Paddle(int x, int y, int w, int h, int s)
   {
      super(x, y, w, h);
      speed = s;
   }

   public Paddle(int x, int y, int w, int h, Color col, int s)
   {
      super(x, y, w, h, col);
      speed = s;
   }

   // Getters and Setters
   public int getSpeed()
   {
      return speed;
   }

   public void setSpeed(int s)
   {
      speed = s;
   }

   // Move methods
   public void moveUp() {
        setY(getY() - speed);
    }

    public void moveDown() {
        setY(getY() + speed);
    }

   // toString method
   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}
