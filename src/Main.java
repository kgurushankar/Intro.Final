
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import field.tower.BunnyTower;
import field.tower.CatTower;
import field.tower.RabbitTower;
import field.tower.Tower;
import view.Credits;
import view.Game;
import view.Loading;
import view.TitleScreen;

public class Main extends JFrame implements /* ComponentListener, */ KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private Game game;
	private TitleScreen title;
	private Credits credits = new Credits();
	private Loading l = new Loading();

	enum CurrentView {
		Game, Title, Credits
	}

	CurrentView view = CurrentView.Title;

	public Main() {
		super("Tower Defense");
		try {
			Font temp = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Fonts/Quicksand-Light.ttf"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(temp);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
		addMouseListener(this);
		setFocusable(true);
		requestFocusInWindow();
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		if (fs) {
			setUndecorated(true);
			setVisible(true);
		}
		title = new TitleScreen();
		title.setBackground(Color.white);
		add(title);
		revalidate();

	}

	public void startGame() {
		clearScreen();
		game = new Game();
		game.setBackground(Color.WHITE);
		remove(l);
		view = CurrentView.Game;
		add(game);
		revalidate();
	}

	public void titleScreen() {
		clearScreen();
		title = new TitleScreen();
		title.setBackground(Color.white);
		remove(l);
		view = CurrentView.Title;
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
		add(l);
		revalidate();
	}

	public static void main(String[] args) {
		Main m = new Main();

	}

	private byte towerChosen = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		if (view == CurrentView.Game) {
			System.out.println("game " + e.getX() * 1.0 / Game.interval + " " + e.getY() * 1.0 / Game.interval);
			if (e.getX() >= Game.interval * 10.25 && e.getX() <= Game.interval * 12.25) {
				if (e.getY() >= Game.interval * .25 && e.getY() <= Game.interval * 2.25) {
					towerChosen = 1;
				} else if (e.getY() >= Game.interval * 2.5 && e.getY() <= Game.interval * 4.5) {
					towerChosen = 2;
				} else if (e.getY() >= Game.interval * 4.75 && e.getY() <= Game.interval * 6.75) {
					towerChosen = 3;
				}
				System.out.println("select");
			} else if (towerChosen != 0) {
				System.out.println("placing");
				if (e.getX() <= Game.interval * 15 && e.getY() <= Game.interval * 10) {
					Tower t = null;
					if (towerChosen == 1) {
						t = new BunnyTower((byte) (e.getX() / Game.interval), (byte) (e.getY() / Game.interval), game);
					} else if (towerChosen == 2) {
						t = new CatTower((byte) (e.getX() / Game.interval), (byte) (e.getY() / Game.interval), game);
					} else if (towerChosen == 3) {
						t = new RabbitTower((byte) (e.getX() / Game.interval), (byte) (e.getY() / Game.interval), game);
					}
					towerChosen = 0;
					System.out.println("send" + t.getClass());
					game.placeTower(t);
				}
			}
		}

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
		if (view == CurrentView.Credits) {

		} else if (view == CurrentView.Game) {
			if (e.getKeyChar() == 'p') {
				if (game.isPaused()) {
					game.resume();
				} else {
					game.pause();
				}
			}
		} else if (view == CurrentView.Title) {
			if (e.getKeyChar() == ' ') {
				this.startGame();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private Rectangle old = new Rectangle(100, 100, 800, 600);
	private boolean fs = true;

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_F11) {
			setVisible(false);
			dispose();
			if (!fs) {
				old = this.getBounds();
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				setUndecorated(true);
				fs = true;
			} else {
				this.setBounds(old);
				setUndecorated(false);
				fs = false;
			}
			setVisible(true);
		}

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
	 * 
	 * }
	 */
}
