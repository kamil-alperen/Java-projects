
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Songs extends MouseAdapter{
	Clip clip1;
	Clip clip2;
	Clip clip3;
	Clip clip4;
	Clip clip5;
	Clip clip6;
	Clip clip7;
	Clip clip8;
	Clip clip9;
	Clip clip10;
	Clip clip11;
	Clip clip12;
	JFrame frame;
	Shift panel;
	JLabel song1 = new JLabel();
	JLabel song2 = new JLabel();
	JLabel song3 = new JLabel();
	JLabel song4 = new JLabel();
	JLabel song5 = new JLabel();
	JLabel song6 = new JLabel();
	JLabel song7 = new JLabel();
	JLabel song8 = new JLabel();
	JLabel song9 = new JLabel();
	JLabel song10 = new JLabel();
	JLabel song11 = new JLabel();
	ImageIcon image2 = new ImageIcon("feel_it_coming.jpg");
	ImageIcon image8 = new ImageIcon("blinding_lights.png");
	ImageIcon image1 = new ImageIcon("acdc.jpg");
	ImageIcon image4 = new ImageIcon("scream_and_shout.jpg");
	ImageIcon image5 = new ImageIcon("dark_horse.png");
	ImageIcon image6 = new ImageIcon("madonna.jpg");
	ImageIcon image7 = new ImageIcon("me.jpg");
	ImageIcon image3 = new ImageIcon("price_tag.jpg");
	ImageIcon image9 = new ImageIcon("rolling.jpg");
	ImageIcon image10 = new ImageIcon("toxic.jpg");
	ImageIcon image11 = new ImageIcon("look.jpg");
	Point currPoint;
	Point prevPoint;
	EnterExit ee;
	public Songs() {
		addSongs();
		ee = new EnterExit();

		song1.setIcon(image1);
		song2.setIcon(image2);
		song3.setIcon(image3);
		song4.setIcon(image4);
		song5.setIcon(image5);
		song6.setIcon(image6);
		song7.setIcon(image7);
		song8.setIcon(image8);
		song9.setIcon(image9);
		song10.setIcon(image10);
		song11.setIcon(image11);
		
		song1.setOpaque(true);
		song2.setOpaque(true);
		song3.setOpaque(true);
		song4.setOpaque(true);
		song5.setOpaque(true);
		song6.setOpaque(true);
		song7.setOpaque(true);
		song8.setOpaque(true);
		song9.setOpaque(true);
		song10.setOpaque(true);
		song11.setOpaque(true);
		
		
		song1.setBounds(0, 0, 200, 360);
		song2.setBounds(200, 0, 200, 360);
		song3.setBounds(400, 0, 200, 360);
		song4.setBounds(600, 0, 200, 360);
		song5.setBounds(800, 0, 200, 360);
		song6.setBounds(1000, 0, 200, 360);
		song7.setBounds(1200, 0, 200, 360);
		song8.setBounds(1400, 0, 200, 360);
		song9.setBounds(1600, 0, 200, 360);
		song10.setBounds(1800, 0, 200, 360);
		song11.setBounds(2000, 0, 200, 360);
		
		song1.addMouseListener(this);
		song2.addMouseListener(this);
		song3.addMouseListener(this);
		song4.addMouseListener(this);
		song5.addMouseListener(this);
		song6.addMouseListener(this);
		song7.addMouseListener(this);
		song8.addMouseListener(this);
		song9.addMouseListener(this);
		song10.addMouseListener(this);
		song11.addMouseListener(this);
		
		song1.addMouseListener(ee);
		song2.addMouseListener(ee);
		song3.addMouseListener(ee);
		song4.addMouseListener(ee);
		song5.addMouseListener(ee);
		song6.addMouseListener(ee);
		song7.addMouseListener(ee);
		song8.addMouseListener(ee);
		song9.addMouseListener(ee);
		song10.addMouseListener(ee);
		song11.addMouseListener(ee);
		
		song1.addMouseMotionListener(ee);
		song2.addMouseMotionListener(ee);
		song3.addMouseMotionListener(ee);
		song4.addMouseMotionListener(ee);
		song5.addMouseMotionListener(ee);
		song6.addMouseMotionListener(ee);
		song7.addMouseMotionListener(ee);
		song8.addMouseMotionListener(ee);
		song9.addMouseMotionListener(ee);
		song10.addMouseMotionListener(ee);
		song11.addMouseMotionListener(ee);
	
		panel = new Shift();
		panel.setLayout(null);
	
		frame = new JFrame();
		frame.setSize(815,395);
		frame.setTitle("Music Application");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
	
	}
	public void addSongs() {
		File file1 = new File("ac_dc.wav");
		File file2 = new File("I_feel_it_coming.wav");
		File file8 = new File("Blinding_lights.wav");
		File file4 = new File("Scream_and_shout.wav");
		File file3 = new File("price_tag.wav");
		File file6 = new File("madonna.wav");
		File file7 = new File("me.wav");
		File file5 = new File("dark_horse.wav");
		File file9 = new File("rolling.wav");
		File file10 = new File("toxic.wav");
		File file11 = new File("look.wav");
	
		try {
			AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
			AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
			AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
			AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
			AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(file5);
			AudioInputStream audioStream6 = AudioSystem.getAudioInputStream(file6);
			AudioInputStream audioStream7 = AudioSystem.getAudioInputStream(file7);
			AudioInputStream audioStream8 = AudioSystem.getAudioInputStream(file8);
			AudioInputStream audioStream9 = AudioSystem.getAudioInputStream(file9);
			AudioInputStream audioStream10 = AudioSystem.getAudioInputStream(file10);
			AudioInputStream audioStream11 = AudioSystem.getAudioInputStream(file11);
			clip1 = AudioSystem.getClip();
			clip2 = AudioSystem.getClip();
			clip3 = AudioSystem.getClip();
			clip4 = AudioSystem.getClip();
			clip5 = AudioSystem.getClip();
			clip6 = AudioSystem.getClip();
			clip7 = AudioSystem.getClip();
			clip8 = AudioSystem.getClip();
			clip9 = AudioSystem.getClip();
			clip10 = AudioSystem.getClip();
			clip11 = AudioSystem.getClip();
			clip1.open(audioStream1);
			clip2.open(audioStream2);
			clip3.open(audioStream3);
			clip4.open(audioStream4);
			clip5.open(audioStream5);
			clip6.open(audioStream6);
			clip7.open(audioStream7);
			clip8.open(audioStream8);
			clip9.open(audioStream9);
			clip10.open(audioStream10);
			clip11.open(audioStream11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if(song1 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip1,1);
		}
		else if(song2 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip2,2);
		}
		else if(song3 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip3,3);
		}
		else if(song4 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip4,4);
		}
		else if(song5 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip5,5);
		}
		else if(song6 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip6,6);
		}
		else if(song7 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip7,7);
		}
		else if(song8 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip8,8);
		}
		else if(song9 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip9,9);
		}
		else if(song10 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip10,10);
		}
		else if(song11 == e.getSource()) {
			frame.dispose();
			new PlaySong(clip11,11);
		}
	}
	
	class EnterExit extends MouseAdapter{
	
		public void mousePressed(MouseEvent e) {
			prevPoint = e.getPoint();
			panel.pressed(prevPoint);
		}
		public void mouseDragged(MouseEvent e){
			currPoint = e.getPoint();
			panel.dragged(currPoint);
			prevPoint = currPoint;
		}
		
	}
	class Shift extends JPanel{
		Point imageCorner;
		Point prevPoint;	
		public Shift() {
			imageCorner = new Point(0,0);
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(0 - imageCorner.getX()/50 > 0)return;
			if(2000 - imageCorner.getX()/50 < 600)return;
			image1.paintIcon(panel, g, 0 - (int)imageCorner.getX(), 0);
			song1.setBounds(0 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song1);
			
			image2.paintIcon(panel, g, 200 - (int)imageCorner.getX()/100, 0);
			song2.setBounds(200 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song2);
			
			image3.paintIcon(panel, g, 400 - (int)imageCorner.getX(), 0);
			song3.setBounds(400 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song3);
			
			image4.paintIcon(panel, g, 600 - (int)imageCorner.getX(), 0);
			song4.setBounds(600 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song4);
			
			image5.paintIcon(panel, g, 800 - (int)imageCorner.getX(), 0);
			song5.setBounds(800 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song5);
			
			image6.paintIcon(panel, g, 1000 - (int)imageCorner.getX(), 0);
			song6.setBounds(1000 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song6);
			
			image7.paintIcon(panel, g, 1200 - (int)imageCorner.getX(), 0);
			song7.setBounds(1200 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song7);
			
			image8.paintIcon(panel, g, 1400 - (int)imageCorner.getX(), 0);
			song8.setBounds(1400 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song8);
			
			image9.paintIcon(panel, g, 1600 - (int)imageCorner.getX(), 0);
			song9.setBounds(1600 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song9);
			
			image10.paintIcon(panel, g, 1800 - (int)imageCorner.getX(), 0);
			song10.setBounds(1800 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song10);
			
			image11.paintIcon(panel, g, 2000 - (int)imageCorner.getX(), 0);
			song11.setBounds(2000 - (int)imageCorner.getX()/50, 0, 200, 360);
			panel.add(song11);
		}
		public void pressed(Point prev) {
			prevPoint = prev;
		}
		public void dragged(Point curr) {
			imageCorner.translate(	     
					(int)(prevPoint.getX() - curr.getX()),
					(int)(prevPoint.getY() - curr.getY())
			);
			
			repaint(); 
		}
	
	}

}
