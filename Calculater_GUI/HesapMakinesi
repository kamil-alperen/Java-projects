import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HesapMakinesi extends JFrame implements MouseListener,ActionListener,Text{
	
	public HesapMakinesi() {
		
		setTitle("Hesap Makinesi");
		setSize(330,330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		area.add(field);
		JButton toplama = new JButton("+");
		toplama.setName("+");
		toplama.addMouseListener(this);
		JButton cikarma = new JButton("-");
		cikarma.setName("-");
		cikarma.addMouseListener(this);
		JButton carpma = new JButton("*");
		carpma.setName("*");
		carpma.addMouseListener(this);
		JButton bolme = new JButton("/");
		bolme.setName("/");
		bolme.addMouseListener(this);
		JButton gelismis = new JButton("Gelismis");
		gelismis.setName("Gelismis");
		gelismis.addActionListener(this);
		JButton temizle = new JButton("Temizle");
		temizle.setName("Temizle");
		temizle.addMouseListener(this);
		JButton sonuc = new JButton("=");
		sonuc.setName("=");
		sonuc.addMouseListener(this);
		
	
	
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(area);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,1));
		panel2.add(toplama);
		panel2.add(cikarma);
		panel2.add(carpma);
		panel2.add(bolme);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(gelismis);
		panel3.add(temizle);
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,1));
		panel4.add(sonuc);
		
		JSplitPane top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		top.setDividerLocation(200);
		top.add(panel1);
		top.add(panel2);
		JSplitPane bottom = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		bottom.add(panel3);
		bottom.add(panel4);
		bottom.setDividerLocation(200);
		JSplitPane main = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		main.setDividerLocation(220);
		main.add(top);
		main.add(bottom);
		
		
		add(main);
		setVisible(true);
	}
	double previous;
	String sign;
	@Override
	
	public void mouseClicked(MouseEvent e) {
		
		Component c = e.getComponent();
		String s = c.getName();
		
		if(s.equals("+")) {
			try {
				previous = Double.parseDouble(area.getText());
				area.setText("");
				sign = "+";
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
				
			}
		}
		else if(s.equals("-")) {
			try {
				previous = Double.parseDouble(area.getText());
				sign = "-";
				area.setText("");
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("*")) {
			try {
				previous = Double.parseDouble(area.getText());
				sign = "*";
				area.setText("");
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("/")) {
			try {
				previous = Double.parseDouble(area.getText());
				sign = "/";
				area.setText("");
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("Temizle")) {
			try {
				sign = "";
				previous = 0;
				area.setText("");
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("=")) {
			try {
				double sonuc = 0;
				double next = Double.parseDouble(area.getText());
				if(sign.equals("+")) {
					sonuc = previous + next;
				}
				else if(sign.equals("-")) {
					sonuc = previous - next;
				}
				else if(sign.equals("*")) {
					sonuc = previous * next;
				}
				else if(sign.equals("/")) {
					sonuc = previous / next;
				}
				area.setText(""+sonuc);
				previous = 0;
				sign = "";
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
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
	public void actionPerformed(ActionEvent e) {
		dispose();
		new GelismisHesapMakinesi();
		
	}
	
	public static void main(String[] args) {
		new HesapMakinesi();
		
	}







}
