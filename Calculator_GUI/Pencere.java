import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pencere extends JFrame{
	public Pencere() {
		JFrame f = new JFrame();
		f.setTitle("Hata");
		f.setSize(300,200);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel l = new JLabel("Hatali Giris!",SwingConstants.CENTER);
		l.setForeground(Color.red);
		f.add(l);
		f.setVisible(true);
	}


}
