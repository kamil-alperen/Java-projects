
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlaySong extends MouseAdapter{
	JFrame frame;
	ImageIcon background;
	JLabel label;
	Clip clip;
	Change b1;
	JPanel b2;
	JPanel b3;
	ImageIcon start = new ImageIcon("start.png");
	ImageIcon stop = new ImageIcon("stop.png");
	JLabel startL = new JLabel();
	JLabel restartL = new JLabel();
	JLabel exitL = new JLabel();
	public PlaySong(Clip clip,int choice) {
		this.clip = clip;
		switch(choice) {
			case 1:
				background = new ImageIcon("ac_dc.jpg");
				break;
			case 2:
				background = new ImageIcon("coming.jpg");
				break;
			case 3:
				background = new ImageIcon("price_tag2.jpg");
				break;
			case 4:
				background = new ImageIcon("scream.jpg");
				break;
			case 5:
				background = new ImageIcon("dark_horse2.png");
				break;
			case 6:
				background = new ImageIcon("madonna2.jpg");
				break;
			case 7:
				background = new ImageIcon("me2.jpg");
				break;
			case 8:
				background = new ImageIcon("lights.png");
				break;
			case 9:
				background = new ImageIcon("rolling2.jpg");
				break;
			case 10:
				background = new ImageIcon("toxic2.jpg");
				break;
			case 11:
				background = new ImageIcon("look2.jpg");
				break;
		}
		
		label = new JLabel();
		label.setIcon(background);
		label.setOpaque(true);
		label.setBounds(0, 0, 360, 360);
		
		ImageIcon restart = new ImageIcon("restart.png");
		ImageIcon exit = new ImageIcon("exit.png");
		

		startL.setIcon(start);
		restartL.setIcon(restart);
		exitL.setIcon(exit);
		
		startL.setOpaque(true);
		restartL.setOpaque(true);
		exitL.setOpaque(true);
		
		startL.setBounds(0,360,90,90);
		restartL.setBounds(180,360,90,90);
		exitL.setBounds(270,360,90,90);
	
		JPanel bottom = new JPanel(new GridLayout(1,3));
		b1 = new Change();
		b1.addMouseListener(this);
		b1.add(startL);
		b2 = new JPanel();
		b2.addMouseListener(this);
		b2.add(restartL);
		b3 = new JPanel();
		b3.addMouseListener(this);
		b3.add(exitL);
		bottom.add(b1);
		bottom.add(b2);
		bottom.add(b3);
		bottom.setBounds(0, 360, 360, 120);
		
		frame = new JFrame();
		frame.setSize(375,480);
		frame.setTitle("Music Application");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(label);
		frame.add(bottom);
		frame.setVisible(true);
		
	}
	boolean startBool = false;
	public void options(int choice) {
		switch(choice) {
			case 1:
				if(startBool)clip.start();
				else clip.stop();
				break;
			case 2:
				clip.stop();
				break;
			case 3:
				clip.setMicrosecondPosition(0);
				break;
			case 4:
				clip.stop();
				clip.setMicrosecondPosition(0);
		}
		
	}
	static Songs songs;
	public static void getSongs(Songs s) {
		songs = s;
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == b1) {
			boolean x = e.getX() > 32 & e.getX() < 87;
			boolean y = e.getY() > 7 & e.getY() < 62;
			if(x & y) {
				startBool = !startBool;
				options(1);
				b1.getB(startBool);
			}
		}
		else if(e.getSource() == b2) {
			boolean x = e.getX() > 33 & e.getX() < 87;
			boolean y = e.getY() > 7 & e.getY() < 62;
			if(x & y) {
				options(3);
			}
		}
		else if(e.getSource() == b3) {
			boolean x = e.getX() > 34 & e.getX() < 84;
			boolean y = e.getY() > 4 & e.getY() < 64;
			if(x & y) {
				options(4);
				frame.dispose();
				songs.frame.setVisible(true);
			}
		}
	}
	private class Change extends JPanel{
		boolean b = false;
		public void getB(boolean bool) {
			b = bool;
			this.repaint();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(b) { // put stop image
				start = new ImageIcon("stop.png");
				start.paintIcon(this, g, 32, 7);
				startL.setBounds(0,360,90,90);
				b1.add(startL);
			}
			else { // put start image
				start = new ImageIcon("start.png");
				start.paintIcon(this, g, 32, 7);
				startL.setBounds(0,360,90,90);
				b1.add(startL);
			}
		}
	}
}
