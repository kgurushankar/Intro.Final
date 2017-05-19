import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import view.Game;
import view.TitleScreen;

public class Main extends JFrame implements ComponentListener, KeyListener, MouseListener {
	Game game;
	TitleScreen title;
	boolean gameRunning;
	boolean paused;

	public Main() {
		super("Tower Defense");
		addComponentListener(this);
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true);
		requestFocusInWindow();
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		title = new TitleScreen();
		title.setBackground(Color.white);
		add(title);
		gameRunning = false;
		revalidate();
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		int W = 4;
		int H = 3;
		Rectangle b = arg0.getComponent().getBounds();
		if (b.getWidth() * H >= b.getHeight() * W) {
			arg0.getComponent().setBounds(b.x, b.y, b.height * W / H, b.height);
		} else {
			arg0.getComponent().setBounds(b.x, b.y, b.width, b.width * H / W);
		}

	}

	public void startGame() {
		clearScreen();
		game = new Game();
		game.setBackground(Color.WHITE);
		add(game);
		gameRunning = true;
		revalidate();
	}

	public void titleScreen() {
		clearScreen();
		title = new TitleScreen();
		title.setBackground(Color.white);
		add(title);
		gameRunning = false;
		revalidate();

	}

	public void clearScreen() {
		if (!gameRunning) {
			remove(title);
			title = null;
		} else {
			remove(game);
			game = null;
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.startGame();
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		game.pause();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			System.out.println("P");
			if (game.isPaused()) {
				game.resume();
			} else {
				game.pause();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
