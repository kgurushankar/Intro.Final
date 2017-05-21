package field;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import view.Game;

public abstract class Item {
	protected int x;
	protected int y;
	/** Max speed is 10 <br />
	 * Hit speed for towers and */
	protected byte speed;
	protected byte value; // price/payout
	protected Image img;
	protected boolean needsNewGoal = false;

	public Item(int x, int y, byte speed, byte value) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.value = value;
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
	}

	public byte[] getLoc() {
		return new byte[] { (byte) (x / Game.interval), (byte) (y / Game.interval) };
	}

	protected Image getImage() {
		return img;
	}

	public abstract void run();

	public byte getValue() {
		return value;
	}

	protected Image loadImageFromFile(String FileLoc) {
		String root = (System.getProperty("user.dir")).replace('\\', '/');
		root += "/assets/";

		try {
			Image temp = ImageIO.read(new File(root + FileLoc));
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File " + FileLoc + " not Found");
			System.exit(1);
		}
		return null;

	}

}