import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java. awt. Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.Border;

public class GUI extends JFrame implements MouseListener,ActionListener,WindowListener{
	
	// BU PROGRAM CALISTIRILACAK
	/* Etrafi sarilan taslardan sadece biri degistiriliyor.Asagidaki RoundedBorder sinifiyla
	   alakali bir problem.
	*/
	static Board board = new Board();
	JPanel[] paneller;
	String title;
	String[][] buttons;
	JButton button;
	boolean state;
	int tur_sayisi;
	int count = 0;
	public static final Color LIGHT_BROWN = new Color(153,102,0);
	public GUI() {
		addWindowListener(this);
		button = new JButton();
		button.setSize(new Dimension(56,55));
		button.setBackground(LIGHT_BROWN);
		button.setBorder(new RoundedBorder(60));
		buttons = new String[9][9];
		state = true;
		title = "Siyah";
		setTitle(title);
		setName("GO Oyunu");
		setSize(660,660);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new GridLayout(11,11));
		paneller = new JPanel[121];
		for(int i = 0;i < 121;i++) {
			paneller[i] = new JPanel();
			paneller[i].addMouseListener(this);
			paneller[i].setName(i+"");
		}
		
		
		JLabel a = new JLabel("A");
		paneller[1].add(a);
		JLabel b = new JLabel("B");
		paneller[2].add(b);
		JLabel c = new JLabel("C");
		paneller[3].add(c);
		JLabel d = new JLabel("D");
		paneller[4].add(d);
		JLabel e = new JLabel("E");
		paneller[5].add(e);
		JLabel f = new JLabel("F");
		paneller[6].add(f);
		JLabel g = new JLabel("G");
		paneller[7].add(g);
		JLabel h = new JLabel("H");
		paneller[8].add(h);
		JLabel j = new JLabel("J");
		paneller[9].add(j);
		JLabel bir = new JLabel("1");
		paneller[11].add(bir);
		JLabel iki = new JLabel("2");
		paneller[22].add(iki);
		JLabel uc = new JLabel("3");
		paneller[33].add(uc);
		JLabel dort = new JLabel("4");
		paneller[44].add(dort);
		JLabel bes = new JLabel("5");
		paneller[55].add(bes);
		JLabel alti = new JLabel("6");
		paneller[66].add(alti);
		JLabel yedi = new JLabel("7");
		paneller[77].add(yedi);
		JLabel sekiz = new JLabel("8");
		paneller[88].add(sekiz);
		JLabel dokuz = new JLabel("9");
		paneller[99].add(dokuz);
		JButton pas = new JButton("pas");
		pas.setPreferredSize(new Dimension(58,48));
		pas.addActionListener(this);
		paneller[115].add(pas);
		
		for(int i = 0;i < 121;i++) {
			add(paneller[i]);
		}
	
		
		setVisible(true);
	}
	
	
	public void paint(Graphics g) {
		g.setColor(LIGHT_BROWN);
		paneller[115].setBackground(Color.WHITE);
		for(int i = 0;i < 10;i++) {
			paneller[i].setBackground(Color.WHITE);
		}
		for(int i = 11;i <= 99;i = i + 11) {
			paneller[i].setBackground(Color.WHITE);
		}
		g.fillRect(68, 88, 522, 504);
		
		g.setColor(Color.BLACK);
		for(int i = 58;i < 600;i = i + 58) {
			g.drawLine( i+10, 88, i+10, 592);
			
		}
		for(int i = 56;i < 600;i = i + 56) {
			g.drawLine(68, i+32, 590, i+32);
		}
	}
	public static void main(String[] args) {
		GUI game = new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(title.equals("Siyah")) {
			title = "Beyaz";
			
		}
		else {
			title = "Siyah";
		}
		setTitle(title);
		
		
	}
	JPanel wanted;
	int x,y; 
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Component c = e.getComponent();
		String name = c.getName();
		
		state = true;
		
		
		int bolum;
		for(int i = 12;i < 109;i++) {
			if(i % 11 != 0) {
				if(paneller[i].getName().equals(name)) {
					wanted = paneller[i];
				
					bolum = i - 12;
					y = bolum / 11;
					x = bolum % 11;
					break;
				}
			}
		}
		
		
		wanted.add(button);	
		
		
		if(title.equals("Siyah")) {
			buttons[x][y] = " x ";
		}
		else {
			buttons[x][y] = " o ";
		}
		if(title.equals("Siyah")) {
			title = "Beyaz";
			
		}
		else {
			title = "Siyah";
		}
		tur_sayisi++;
		setTitle(title);
		
	}

	int[] index_i;
	int[] index_j;
	public void Change_buttons(String symbol) {
		
		index_i = new int[board.indexi.length];
	
		index_j = new int[board.indexj.length];
		String sign = "";
		if(symbol.equals("Siyah")) {
			sign = " o ";
		}
		else {
			sign = " x ";
		}
		
		for(int i = 0;i < index_i.length;i++) {
			index_i[i] = board.indexi[i];
		}
		for(int i = 0;i < index_j.length;i++) {
			index_j[i] = board.indexj[i];
		}
		
		int count = 0;
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				for(int k = 0;k < index_i.length;k++) {
					for(int m = 0;m < index_j.length;m++) {
						if(index_i[k] == i && index_j[m] == j) {
							count = i + 12;
							count = (j * 11) + count;
							title = symbol;
							wanted = paneller[count];
							buttons[i][j] = sign;
							wanted.add(button);
							button.setBorder(new RoundedBorder(60));
						}
					}
				}
			}
		}
	}
	int tur;
	public void Play() {
		state = false;
		String symbol = "";
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(buttons[i][j] != null) {
					
					board.the_board[i][j] = buttons[i][j];
				}
				else {
					board.the_board[i][j] = " - ";
				}
			}
		}
		board.Run();
		if(tur % 2 == 0)symbol = "Beyaz";
		else symbol = "Siyah";
		Change_buttons(symbol);
		tur++;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	
	private class RoundedBorder implements Border{
		private int radius;

		RoundedBorder(int radius) {
		        this.radius = radius;
		}
		  

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

			if(tur_sayisi % 2 == 1) {
				g.setColor(Color.BLACK);
				
			}
			else {
				g.setColor(Color.WHITE);
				
			}
			
			g.fillRoundRect(x, y, width-1, height-1, radius, radius);
			
			if(state) {
				Play();
				
			}
		
			
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		new Exit();
		
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

	class Exit extends JFrame implements MouseListener,WindowListener{
		public Exit() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addWindowListener(this);
			setTitle("EXIT");
			setSize(300,150);
			setLayout(new BorderLayout());
			JLabel label = new JLabel("Cikmak istediginizden emin misiniz ?");
			JButton yes = new JButton("EVET");
			yes.setName("yes");
			yes.addMouseListener(this);
			JButton no = new JButton("HAYIR");
			no.setName("no");
			no.addMouseListener(this);
			JPanel top = new JPanel();
			top.setSize(new Dimension(300,100));
			JPanel bottom = new JPanel();
			top.add(label);
			bottom.add(yes);
			bottom.add(no);
			
			add(top,BorderLayout.NORTH);
			add(bottom,BorderLayout.CENTER);
			setVisible(true);
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Component c = e.getComponent();
			if(c.getName().equals("yes")) {
					System.exit(0);
			}
			else
				dispose();
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


}
