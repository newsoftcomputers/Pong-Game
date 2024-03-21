import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable {
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;

    public PaddleTestTwo() {
        ball = new Ball(200, 200, 10, 10, Color.BLACK, 3, 1);
        leftPaddle = new Paddle(10, 200, 10, 80, Color.BLUE, 5);
        rightPaddle = new Paddle(580, 200, 10, 80, Color.RED, 5);
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);
        addKeyListener(this);

        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        // Clear the canvas
        window.clearRect(0, 0, getWidth(), getHeight());
        
        // Draw the ball
        ball.moveAndDraw(window);

        // Draw the left paddle first
        leftPaddle.draw(window);
        
        // Draw the right paddle next
        rightPaddle.draw(window);

        // Check and update ball position
        if (!(ball.getX() >= 10 && ball.getX() <= 550)) {
            ball.setXSpeed(-ball.getXSpeed());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= 450)) {
            ball.setYSpeed(-ball.getYSpeed());
        }

        // Check and update left paddle position
        if (keys[0]) {
            leftPaddle.moveUp();
        }
        if (keys[1]) {
            leftPaddle.moveDown();
        }
        
        // Check and update right paddle position
        if (keys[2]) {
            rightPaddle.moveUp();
        }
        if (keys[3]) {
            rightPaddle.moveDown();
        }
    }

    // Implement KeyListener methods
    public void keyPressed(KeyEvent e) {
        switch (Character.toUpperCase(e.getKeyChar())) {
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
        switch (Character.toUpperCase(e.getKeyChar())) {
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

    public void keyTyped(KeyEvent e) {}

    // Implement Runnable method
    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint(); // Force canvas repaint
            }
        } catch (Exception e) {}
    }
}
