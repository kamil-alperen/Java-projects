import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Go {
	static Board board = new Board();
	
	private void Show() {
		
		char[] letters = new char[9];
		System.out.println("     THE BOARD     ");
		System.out.println("  1  2  3  4  5  6  7  8  9 ");
		for(int i = 0;i < letters.length;i++) {
			letters[i] = (char)(i+97);
		}
		for(int i = 0;i < board.the_board.length;i++) {
			System.out.print(letters[i]);
			for(int j = 0;j < board.the_board.length;j++) {
				System.out.print(board.the_board[i][j]);
			}
			System.out.println();
		}
	}
	
	
	Scanner key = new Scanner(System.in);
	static int count;

	public void Play() {
		
		boolean b = true;
		char letter = 0;
		int number = 0;
		String answer = "";
		System.out.println("The Person1(black) plays : ");
		try {
			
			answer = key.nextLine();
			
			if(answer.contains("save text")) {
				b = false;
				int idx = answer.indexOf("text");
				idx = idx + 5;
				String key_word = answer.substring(idx);
				PrintWriter pw = new PrintWriter(new FileOutputStream(key_word));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						pw.write(board.the_board[i][j].substring(1,2)+" ");
					}
				
				}
				pw.close();
				System.out.println("The game is saved ");
				Play();
			}
			else if(answer.contains("save binary")) {
				b = false;
				int idx = answer.indexOf("binary");
				idx = idx + 7;
				String key_word = answer.substring(idx);
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(key_word));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						oos.writeUTF(board.the_board[i][j].substring(1,2));
					}
				}
				oos.close();
				System.out.println("The game is saved ");
				Play();
			}
			else if(answer.equals("p")) count++;
			else {
				
				letter = answer.charAt(1);
				number = answer.charAt(0) - 48;
			}
		}
		catch(Exception e) {
			System.out.println("Incorrect number or character.Try again");
			b = false;
			Play();
			
		}
		if(!answer.equals("p") & b) {
			board.Place_stone(number, letter, " x ");
		}
	}
	public void Play2() {
	
		boolean b = true;
		char letter = 0;
		int number = 0;
		String answer = "";
		System.out.println("The Person2(white) plays : ");
		try {
			answer = key.nextLine();
			
			if(answer.contains("save text")) {
				b = false;
				int idx = answer.indexOf("text");
				idx = idx + 5;
				String key_word = answer.substring(idx);
				PrintWriter pw = new PrintWriter(new FileOutputStream(key_word));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						pw.write(board.the_board[i][j].substring(1,2)+" ");
					}
				}
				pw.close();
				System.out.println("The game is saved ");
				Play2();
			}
			else if(answer.contains("save binary")) {
				b = false;
				int idx = answer.indexOf("binary");
				idx = idx + 7;
				String key_word = answer.substring(idx);
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(key_word));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						oos.writeUTF(board.the_board[i][j].substring(1,2));
					}
				}
				oos.close();
				System.out.println("The game is saved ");
				Play2();
			}
			else if(answer.equals("p")) count++;
			else {
				letter = answer.charAt(1);
				number = answer.charAt(0) - 48;
			}
		}
		catch(Exception e) {
			System.out.println("Incorrect number or character.Try again");
			b = false;
			Play2();
		}
		if(!answer.equals("p") & b) {
			board.Place_stone(number, letter, " o ");
		}
	}
	
	public static void main(String[] args) {
		Go go = new Go();
		if(args.length == 0) {
			Player player_black = new Player(" x ");
			Player player_white = new Player(" o ");
			System.out.println("Welcome to the new Go Game ");
			go.Show();
			System.out.println("Firstly ,the Person1 who will play with black stones will begin");
		
			while(board.Check_for_endgame()) {
				go.Play();
				go.Show();
				if(count == 2)break;
				go.Play2();
				go.Show();
				if(count == 2)break;
			}
			System.out.println("The game is over");
			int black_areas = player_black.Calcuate_areas(player_black.symbol);
			int white_areas = player_white.Calcuate_areas(player_white.symbol);
			System.out.println("the Person1 who plays with BLACK stones has "+black_areas+" stones");
			System.out.println("the Person2 who plays with WHITE stones has "+white_areas+" stones");
			
			if(black_areas < white_areas) {
				System.out.println("The Winner is the Person2 who plays with WHITE stones");
			}
			else if(black_areas > white_areas){
				System.out.println("The Winner is the Person1 who plays with BLACK stones");
			}
			else {
				System.out.println("There is not Winner");
			}
		}
		else if(args[0].equals("-load_t")) {
			String message = args[1];
			Player player_black = new Player(" x ");
			Player player_white = new Player(" o ");
			try {
				Scanner s = new Scanner(new FileInputStream(message));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						go.board.the_board[i][j] = " "+s.next()+" ";
					}
				}
				s.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome to the new Go Game ");
			go.Show();
			System.out.println("Firstly ,the Person1 who will play with black stones will begin");
		
			while(board.Check_for_endgame()) {
				go.Play();
				go.Show();
				if(count == 2)break;
				go.Play2();
				go.Show();
				if(count == 2)break;
			}
			System.out.println("The game is over");
			int black_areas = player_black.Calcuate_areas(player_black.symbol);
			int white_areas = player_white.Calcuate_areas(player_white.symbol);
			System.out.println("the Person1 who plays with BLACK stones has "+black_areas+" stones");
			System.out.println("the Person2 who plays with WHITE stones has "+white_areas+" stones");
			
			if(black_areas < white_areas) {
				System.out.println("The Winner is the Person2 who plays with WHITE stones");
			}
			else if(black_areas > white_areas){
				System.out.println("The Winner is the Person1 who plays with BLACK stones");
			}
			else {
				System.out.println("There is not Winner");
			}
		}
		else if(args[0].equals("-load_b")) {
			String message = args[1];
			Player player_black = new Player(" x ");
			Player player_white = new Player(" o ");
			try {
				ObjectInputStream o = new ObjectInputStream(new FileInputStream(message));
				for(int i = 0;i < 9;i++) {
					for(int j = 0;j < 9;j++) {
						go.board.the_board[i][j] = " "+o.readUTF()+" ";
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome to the new Go Game ");
			go.Show();
			System.out.println("Firstly ,the Person1 who will play with black stones will begin");
		
			while(board.Check_for_endgame()) {
				go.Play();
				go.Show();
				if(count == 2)break;
				go.Play2();
				go.Show();
				if(count == 2)break;
			}
			System.out.println("The game is over");
			int black_areas = player_black.Calcuate_areas(player_black.symbol);
			int white_areas = player_white.Calcuate_areas(player_white.symbol);
			System.out.println("the Person1 who plays with BLACK stones has "+black_areas+" stones");
			System.out.println("the Person2 who plays with WHITE stones has "+white_areas+" stones");
			
			if(black_areas < white_areas) {
				System.out.println("The Winner is the Person2 who plays with WHITE stones");
			}
			else if(black_areas > white_areas){
				System.out.println("The Winner is the Person1 who plays with BLACK stones");
			}
			else {
				System.out.println("There is not Winner");
			}
		}
		else if(args[0].equals("-input")) {
			String message = args[1];
			Player player_black = new Player(" x ");
			Player player_white = new Player(" o ");
			System.out.println("Welcome to the new Go Game ");
			int num = 0;
			int p = 0;
			String str = "";
			try {
				Scanner s = new Scanner(new FileInputStream(message));
				String[] symbols = {" x "," o "};
				
				while(s.hasNextLine()) {
					str = s.nextLine();
					if(str.equals("p")) {
						if(p == 2) {
							break;
						}
						num++;
						p++;
						System.out.println("The tour is passed");
						go.Show();
						continue;
					}
					else if(str.contains("save text")) {
						p = 0;
						int idx = str.indexOf("text");
						idx = idx + 5;
						String key_word = str.substring(idx);
						PrintWriter pw = new PrintWriter(new FileOutputStream(key_word));
						for(int i = 0;i < 9;i++) {
							for(int j = 0;j < 9;j++) {
								pw.write(board.the_board[i][j].substring(1,2)+" ");
							}
						
						}
						pw.close();
						System.out.println("The game is saved ");
					}
					else if(str.contains("save binary")) {
						p = 0;
						int idx = str.indexOf("binary");
						idx = idx + 7;
						String key_word = str.substring(idx);
						try {
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(key_word));
							for(int i = 0;i < 9;i++) {
								for(int j = 0;j < 9;j++) {
									oos.writeUTF(board.the_board[i][j].substring(1,2));
								}
							}
							oos.close();
							System.out.println("The game is saved ");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {
						p = 0;
						board.Place_stone(str.charAt(0) - 48, str.charAt(1), symbols[num]);
						num++;
						if(num % 2 == 0)num = 0;
						go.Show();
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(num == 1 & p != 2) {
				while(board.Check_for_endgame()) {
					go.Play2();
					go.Show();
					if(count == 2)break;
					go.Play();
					go.Show();
					if(count == 2)break;
				}
			}
			else if(num % 2 == 0 & p != 2) {
				while(board.Check_for_endgame()) {
					go.Play();
					go.Show();
					if(count == 2)break;
					go.Play2();
					go.Show();
					if(count == 2)break;
				}
			}
		
			System.out.println("The game is over");
			int black_areas = player_black.Calcuate_areas(player_black.symbol);
			int white_areas = player_white.Calcuate_areas(player_white.symbol);
			System.out.println("the Person1 who plays with BLACK stones has "+black_areas+" stones");
			System.out.println("the Person2 who plays with WHITE stones has "+white_areas+" stones");
			
			if(black_areas < white_areas) {
				System.out.println("The Winner is the Person2 who plays with WHITE stones");
			}
			else if(black_areas > white_areas){
				System.out.println("The Winner is the Person1 who plays with BLACK stones");
			}
			else {
				System.out.println("There is not Winner");
			}
		}
		
	}
}
