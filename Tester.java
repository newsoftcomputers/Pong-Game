//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
 
import javax.swing.JFrame;
import java.awt.Component;

public class Tester extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Tester()
    {
        super("PONG TESTER");
        setSize(WIDTH,HEIGHT);

        getContentPane().add(new BlockTestTwo());

        //uncomment when you are ready to test the Ball
        getContentPane().add(new BallTestTwo());

        PaddleTestTwo padTest = new PaddleTestTwo();
        ((Component)padTest).setFocusable(true);
        getContentPane().add(padTest);

        
        BlinkyBall blinkyBall = new BlinkyBall(200, 200, 20, 20); // Example parameters
        getContentPane().add(blinkyBall);

        
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Tester run = new Tester();
    }
}