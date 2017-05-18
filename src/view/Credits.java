package view;

import java.awt.Graphics;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Credits extends JPanel
{
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	//    for(int i = 1;i <=1;)
	    int w = getWidth();
	    int h = getHeight();
	   
	    g.setColor(Color.RED);
	    g.setFont(new Font("Serif", Font.BOLD, 60));
	    g.drawString("Credits",110*w/300 , h/9);
	    g.setColor(Color.DARK_GRAY);
	    g.setFont(new Font("Serif", Font.BOLD, 27));
	    g.drawString("By:Keshav Gurushankar, Jeremy Honma and Jatin Alla",w/9 , h/2);
	   }
	public static void main(String[] args)
{
  JFrame window = new JFrame("Drawings");
  window.setBounds(0, 100, 2900, 500);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Credits canvas = new Credits();
  canvas.setBackground(Color.BLACK);
  window.getContentPane().add(canvas);
  window.setVisible(true);
}}
