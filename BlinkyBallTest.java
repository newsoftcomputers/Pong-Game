import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class BlinkyBallTest extends Canvas implements Runnable {
    private BlinkyBall blinkyBall;

    public BlinkyBallTest() {
        blinkyBall = new BlinkyBall(200, 200, 20, 20, Color.RED, 3, 1); // Example parameters
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        blinkyBall.moveAndDraw(window);
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
