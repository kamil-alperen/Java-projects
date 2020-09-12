import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bitwise extends JFrame implements MouseListener,WindowListener,ActionListener,Text{

	public Bitwise() {
		
		setTitle("Bit Duzeyinde Hesap Makinesi");
		setSize(330,330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		area.add(field);
		
		JButton and = new JButton("&");
		and.setName("&");
		and.addMouseListener(this);
		JButton or = new JButton("|");
		or.setName("|");
		or.addMouseListener(this);
		JButton not = new JButton("!");
		not.setName("!");
		not.addMouseListener(this);
		JButton sonuc = new JButton("=");
		sonuc.setName("=");
		sonuc.addMouseListener(this);
		JButton gelismis = new JButton("Gelismis");
		gelismis.setName("Gelismis");
		gelismis.addActionListener(this);
		JButton temizle = new JButton("Temizle");
		temizle.setName("Temizle");
		temizle.addMouseListener(this);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel1.add(area);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel2.add(and);
		panel2.add(or);
		panel2.add(not);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,3));
		panel3.add(gelismis);
		panel3.add(temizle);
		panel3.add(sonuc);
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		pane.setDividerLocation(200);
		pane.add(panel1);
		pane.add(panel2);
		JSplitPane main = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		main.setDividerLocation(210);
		main.add(pane);
		main.add(panel3);
		
		add(main);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new GelismisHesapMakinesi();
		
	}
	public static void main(String[] args) {
		new Bitwise();

	}
	String previous;
	String sign;
	int push;
	@Override
	public void mouseClicked(MouseEvent e) {
		Component c = e.getComponent();
		String s = c.getName();
		if(s.equals("&")) {
			try {
				previous = area.getText();
				area.setText("");
				sign = "&";
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("|")) {
			try {
				previous = area.getText();
				area.setText("");
				sign = "|";
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("!")) {
			try {
				String str = area.getText();
				String sonuc = "";
				for(int i = 0;i < str.length();i++) {
					if(str.charAt(i) == 49) {
						sonuc += "0";
					}
					else sonuc += "1";
				}
				area.setText(sonuc);
			}
			catch(Exception ex) {
				area.setText("");
				new Pencere();
			}
		}
		else if(s.equals("=")) {
			String sonuc = "";
			try {
				String next = area.getText();
				if(sign.equals("&")) {
					String str = "" + previous;
					String str2 = "" + next;
					for(int i = 0;i < str.length();i++) {
						if(str.charAt(i) == 49 & str2.charAt(i) == 49) {
							sonuc += "1";
						}
						else sonuc += "0";
					}
				
				}
				else if(sign.equals("|")) {
					String str = previous + "";
					String str2 = next + "";
					for(int i = 0;i < str.length();i++) {
						if(str.charAt(i) == 48 & str2.charAt(i) == 48) {
							sonuc += "0";
						}
						else sonuc += "1";
					}
					
				}
				
				area.setText(sonuc);
			}
			catch(Exception ex){
				area.setText("");
				new Pencere();
			}
			
		}
		else if(s.equals("Temizle")) {
			try {
				sign = "";
				previous = "";
				area.setText("");
			}
			catch(Exception ex){
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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
