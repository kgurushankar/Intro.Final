import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.JFrame;

import view.*;

public class Main extends JFrame implements /* ComponentListener, */ KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private Game game;
	private TitleScreen title;
	private Credits credits = new Credits();
	private boolean gameRunning;
	private boolean paused;

	enum CurrentView {
		Game, Title, Credits
	}

	CurrentView view = CurrentView.Title;

	public Main() {
		super("Tower Defense");
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
		addMouseListener(this);
		setFocusable(true);
		requestFocusInWindow();
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		title = new TitleScreen();
		title.setBackground(Color.white);
		add(title);
		gameRunning = false;
		revalidate();

	}

	public void startGame() {
		clearScreen();
		game = new Game();
		game.setBackground(Color.WHITE);
		add(game);
		revalidate();
	}

	public void titleScreen() {
		clearScreen();
		title = new TitleScreen();
		title.setBackground(Color.white);
		add(title);
		revalidate();

	}

	public void clearScreen() {
		if (view == CurrentView.Credits) {
			remove(credits);
		} else if (view == CurrentView.Game) {
			remove(game);
		} else if (view == CurrentView.Title) {
			remove(title);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		// m.startGame();

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
		if (e.getKeyCode() == KeyEvent.VK_F) {
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setUndecorated(true);
		} else if (view == CurrentView.Credits) {

		} else if (view == CurrentView.Game) {
			if (e.getKeyCode() == KeyEvent.VK_P) {
				System.out.println("P");
				if (game.isPaused()) {
					game.resume();
				} else {
					game.pause();
				}
			}
		} else if (view == CurrentView.Title) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println("Begin Game");
				this.startGame();
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

	/* All component Listener Code is below */
	/*
	 * 
	 * @Override public void componentResized( ComponentEvent arg0) { if
	 * (this.getExtendedState() != JFrame.MAXIMIZED_BOTH) { int W = 16; int H =
	 * 9; Rectangle b = arg0.getComponent().getBounds (); if (b.getWidth() * H
	 * >= b.getHeight() * W) { arg0.getComponent().setBounds (b.x, b.y, b.height
	 * * W / H, b.height); } else { arg0.getComponent().setBounds (b.x, b.y,
	 * b.width, b.width * H / W); } } }
	 * 
	 * @Override public void componentMoved(ComponentEvent e) {
	 * 
	 * }
	 * 
	 * @Override public void componentShown(ComponentEvent e) {
	 * 
	 * }
	 * 
	 * @Override public void componentHidden( ComponentEvent e) { game.pause();
	 * System.out.println("PAUSE");
	 * 
	 * }
	 */
}
