import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Car extends JPanel {
	private int x = 0, y = 0;
	private int direction = 0;
	private int speed = 0;

	Car() {
		x = y = 0;
	}

	Car(int a, int b) {
		x = a;
		y = b;
	}

	public void icSd() {
		speed++;
	}

	public void dcSd() {
		speed--;
	}

	public int sd() {
		return speed;
	}

	public void paint(Graphics g) {
		Image img = createImage(this.getSize().width, this.getSize().height);
		Graphics gp = img.getGraphics();
		int[] xPoints = { x + 10, x + 20, x + 30, x + 40 };
		int[] yPoints = { y + 10, y, y, y + 10 };

		if (System.currentTimeMillis() % 4 == 1)
			gp.setColor(Color.red);
		else
			gp.setColor(Color.green);
		gp.fillPolygon(xPoints, yPoints, 4);

		if (System.currentTimeMillis() % 4 == 2)
			gp.setColor(Color.blue);
		else
			gp.setColor(Color.YELLOW);
		gp.fillRect(x, y + 10, 50, 10);

		if (System.currentTimeMillis() % 4 == 3)
			gp.setColor(Color.pink);
		else
			gp.setColor(Color.CYAN);
		gp.fillRoundRect(x + 10, y + 20, 10, 10, 10, 10);
		if (System.currentTimeMillis() % 4 == 3)
			gp.setColor(Color.cyan);
		else
			gp.setColor(Color.pink);
		gp.fillRoundRect(x + 30, y + 20, 10, 10, 10, 10);
		g.drawImage(img, 0, 0, this);
	}

	public void go() {

		speed = 5;
		final int w = 50;
		while (true) {
			if (x <= this.getSize().width - 50 && direction == 0) {
				x += speed;
				repaint();
				try {
					Thread.sleep(w);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				direction = 1;
			}
			if (x >= 0 && direction == 1) {
				x -= speed;
				repaint();
				try {
					Thread.sleep(w);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				direction = 0;
			}
		}
	}
}

public class NeedForSpeed extends JFrame {
	public Car car = new Car(0, 200);
	private JPanel note = new JPanel();
	private JLabel dispsd = new JLabel("current speed:");
	private JLabel ist = new JLabel("W加速 S减速");

	NeedForSpeed() {
		this.setTitle("这什么车。。");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(car);
		this.add(note, BorderLayout.PAGE_END);
		note.setLayout(new GridLayout(1, 2));
		note.add(ist);
		note.add(dispsd);
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					car.icSd();
					dispsd.setText("current speed: " + car.sd());
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					car.dcSd();
					dispsd.setText("current speed: " + car.sd());
				}
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		car.setBounds(0, 0, 400, 300);
	}

	public static void main(String[] args) {
		NeedForSpeed game = new NeedForSpeed();
		game.car.go();
	}
}