import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;

    public Pong() {
        ball = new Ball(400, 300, 10, 10, Color.BLACK, 3, 1);
        leftPaddle = new Paddle(10, 250, 10, 80, Color.BLUE, 5);
        rightPaddle = new Paddle(780, 250, 10, 80, Color.RED, 5);
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this); // starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;

        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        if (!(ball.getX() >= 10 && ball.getX() <= 780)) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= 550)) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        // Check collision with left paddle
// Check collision with left paddle
if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())
        && (ball.getY() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()
                || ball.getY() + ball.getHeight() >= leftPaddle.getY()
                        && ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight())) {
    if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())) {
        ball.setYSpeed(-ball.getYSpeed());
    } else {
        ball.setXSpeed(-ball.getXSpeed());
    }
}

// Check collision with right paddle
if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() - Math.abs(ball.getXSpeed())
        && (ball.getY() >= rightPaddle.getY() && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()
                || ball.getY() + ball.getHeight() >= rightPaddle.getY()
                        && ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight())) {
    if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() + Math.abs(ball.getXSpeed())) {
        ball.setYSpeed(-ball.getYSpeed());
    } else {
        ball.setXSpeed(-ball.getXSpeed());
    }
}
        
        
  /*      if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth()
                && ball.getY() >= leftPaddle.getY()
                && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        // Check collision with right paddle
        if (ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth()
                && ball.getY() >= rightPaddle.getY()
                && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()) {
            ball.setXSpeed(-ball.getXSpeed());
        }
*/
        // Check if the paddles need to be moved
        if (keys[0]) {
            leftPaddle.moveUp();
        }
        if (keys[1]) {
            leftPaddle.moveDown();
        }
        if (keys[2]) {
            rightPaddle.moveUp();
        }
        if (keys[3]) {
            rightPaddle.moveDown();
        }

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
        case 'W':
            keys[0] = true;
            break;
        case 'Z':
            keys[1] = true;
            break;
        case 'I':
            keys[2] = true;
            break;
        case 'M':
            keys[3] = true;
            break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
        case 'W':
            keys[0] = false;
            break;
        case 'Z':
            keys[1] = false;
            break;
        case 'I':
            keys[2] = false;
            break;
        case 'M':
            keys[3] = false;
            break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
