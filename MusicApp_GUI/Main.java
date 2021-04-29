import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends MouseAdapter{
	
	JFrame frame;
	ImageIcon background;
	JLabel label;
	Point point;
	public Main() {
		background = new ImageIcon("background.jpg");
		label = new JLabel();
		label.setText("Start");
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("",Font.ITALIC,20));
		label.setIcon(background);
		label.setOpaque(true);
		label.addMouseListener(this);
		
		frame = new JFrame();
		frame.setSize(370,500);
		frame.setTitle("Music Application");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(label);
		
	}
	Songs songs;
	public void mouseClicked(MouseEvent e) {
		point = e.getPoint();
		boolean x = point.getX() > 160 & point.getX() < 204;
		boolean y = point.getY() > 220 & point.getY() < 240;
		if(x & y) {
			frame.dispose();
			songs = new Songs();
			PlaySong.getSongs(songs);
		}
	}
	public static void main(String[] args) {
		new Main();

	}

}
