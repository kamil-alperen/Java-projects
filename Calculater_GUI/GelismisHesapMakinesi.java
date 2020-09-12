import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GelismisHesapMakinesi extends JFrame implements MouseListener,ActionListener,Text{

	public GelismisHesapMakinesi(){
		setTitle("Gelismis Hesap Makinesi");
		setSize(550,550);
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
		JButton basit = new JButton("Basit");
		basit.setName("Basit");
		basit.addActionListener(this);
		JButton bitwise = new JButton("Bitwise");
		bitwise.setName("Bitwise");
		bitwise.addActionListener(this);
		JButton temizle = new JButton("Temizle");
		temizle.setName("Temizle");
		temizle.addMouseListener(this);
		JButton faktoriyel = new JButton("x!");
		faktoriyel.setName("x!");
		faktoriyel.addMouseListener(this);
		JButton ln = new JButton("ln");
		ln.setName("ln");
		ln.addMouseListener(this);
		JButton ussel = new JButton("x^y");
		ussel.setName("x^y");
		ussel.addMouseListener(this);
		JButton karekok = new JButton("kok(x)");
		karekok.setName("kok(x)");
		karekok.addMouseListener(this);
		JButton sonuc = new JButton("=");
		sonuc.setName("=");
		sonuc.addMouseListener(this);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(area);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,2));
		panel2.add(toplama);
		panel2.add(faktoriyel);
		panel2.add(cikarma);
		panel2.add(ln);
		panel2.add(carpma);
		panel2.add(ussel);
		panel2.add(bolme);
		panel2.add(karekok);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,4));
		panel3.add(basit);
		panel3.add(bitwise);
		panel3.add(temizle);
		panel3.add(sonuc);
		
		JSplitPane pane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		pane1.setDividerLocation(260);
		pane1.add(panel1);
		pane1.add(panel2);
		JSplitPane main = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		main.setDividerLocation(400);
		main.add(pane1);
		main.add(panel3);
		
		
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
		else if(s.equals("x!")) {
			double number = 0;
			double sonuc = 1;
			try {
				number = Double.parseDouble(area.getText());
				for(int i = 2;i <= number;i++) {
					sonuc *= i;
				}
				area.setText(""+sonuc);
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("ln")) {
			double number = 0;
			try {
				number = Double.parseDouble(area.getText());
				area.setText(""+Math.log(number));
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("x^y")) {
			try {
				previous = Double.parseDouble(area.getText());
				sign = "x^y";
				area.setText("");
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("kok(x)")) {
			double number = 0;
			try {
				number = Double.parseDouble(area.getText());
				area.setText(""+Math.pow(number, 0.5));
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
				else if(sign.equals("x^y")) {
					sonuc = Math.pow(previous, next);
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
		String s = e.getActionCommand();
		if(s.equals("Basit")) {
			dispose();
			new HesapMakinesi();
		}
		else if(s.equals("Bitwise")) {
			dispose();
			new Bitwise();
		}
		
	}
	public static void main(String[] args) {
		new GelismisHesapMakinesi();
	}
	


}
