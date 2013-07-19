import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

import javax.swing.JDialog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testTest5 {

    private test5 t = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        t = new test5();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void test() throws InterruptedException, AWTException {
        Thread a = new Thread() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                // t.showDialog();
                super.run();
            }
        };
        a.start();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Robot robot = new Robot();
        robot.mouseMove(screenSize.width / 2 - 50, screenSize.height / 2 + 25);
        robot.delay(1000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(300);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        System.out.print("!!");

        a.join();
    }
}
