import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.*;

public class Main extends JPanel {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Tower Defense");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(3);
		Map map = new Map();
		Stats stats = new Stats();
		Controls controls = new Controls();
		map.setBackground(Color.WHITE);
		w.add(stats);
		w.add(map);
		w.add(controls);
		w.setResizable(true);
		w.setVisible(true);
	}
}
