package field;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import view.Game;

public abstract class Item {
	protected int x;
	protected int y;
	/**
	 * Max speed is 10 <br />
	 * Hit speed for towers and movement for enemies
	 */
	protected byte speed;
	protected int value; // price/payout
	protected Image img;

	protected Game game;

	public Item(int x, int y, byte speed, int value, Game game) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.value = value;
		this.game = game;
	}

	/** Returns absolute x!! */
	public int getX() {
		return x;
	}

	/** Returns absolute y!! */
	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.drawImage(this.getImage(), x, y, null);
		g.setColor(Color.black);
	}

	public byte[] getLoc() {
		return new byte[] { (byte) (x / Game.interval), (byte) (y / Game.interval) };
	}

	protected Image getImage() {
		return img;
	}

	public abstract void run();

	public int getValue() {
		return value;
	}

	protected Image loadImageFromFile(String FileLoc) {
		String root = (System.getProperty("user.dir")).replace('\\', '/');
		root += "/assets/";

		try {
			Image temp = ImageIO.read(new File(root + FileLoc));
			return temp.getScaledInstance(Game.interval * 3 / 4, Game.interval * 3 / 4, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File " + FileLoc + " not Found");
			System.exit(1);
		}
		return null;

	}

}