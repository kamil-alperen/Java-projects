import java.util.ArrayList;

public class Item {
	
	// BURADA ETRAFI SARILAN TASLARIN RENK DEGISTIRMESI GERCEKLESTIRILMISTIR
	
	String symbol;
	static Board board = new Board();
	ArrayList<Integer> index1 = new ArrayList<>();
	ArrayList<Integer> index2 = new ArrayList<>();
	String index1_done = "";
	String index2_done = "";
	public Item(String symbol) {
		this.symbol = symbol;
	}
	public void show() {
		for(int i = 0;i < index1.size();i++) {
			System.out.println("i : "+index1.get(i));
		}
		for(int i = 0;i < index2.size();i++) {
			System.out.println("j : "+index2.get(i));
		}
	}
	public void Collect_closed_stones(String symbol) {
		String oppsymbol = "";
		if(symbol.equals(" x "))oppsymbol = " o ";
		else if(symbol.equals(" o "))oppsymbol = " x ";
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				index1_done = "";
				index2_done = "";
				int count = 0;
				if(board.item[i][j] != null && board.item[i][j].symbol.equals(symbol)) {
					index1_done = i + "";
					index2_done = j + "";
					if(i-1 >= 0 & i-1 < 9 & j >= 0 & j < 9) {
							if(board.item[i-1][j] != null && board.item[i-1][j].symbol.equals(symbol)) {
								count += Recursion(i-1,j,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							}
							else if(board.the_board[i-1][j].equals(" - ")) {
								continue;
							}
							else if(board.item[i-1][j] != null && board.item[i-1][j].symbol.equals(oppsymbol)){
								count++;
							}
					}
					else if(!(i-1 >= 0 & i-1 < 9 & j >= 0 & j < 9))count++;
					if(i+1 >= 0 & i+1 < 9 & j >= 0 & j < 9) {
							if(board.item[i+1][j] != null && board.item[i+1][j].symbol.equals(symbol)) {
								count += Recursion(i+1,j,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							}
							else if(board.the_board[i+1][j].equals(" - ")) {
								continue;
							}
							else if(board.item[i+1][j] != null && board.item[i+1][j].symbol.equals(oppsymbol)){
								count++;
							}
					}
					else if(!(i+1 >= 0 & i+1 < 9 & j >= 0 & j < 9))count++;
					if(i >= 0 & i < 9 & j-1 >= 0 & j-1 < 9) {
							if(board.item[i][j-1] != null && board.item[i][j-1].symbol.equals(symbol)) {
								index1_done += i;
								index2_done += j-1;
								count += Recursion(i,j-1,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							}
							else if(board.the_board[i][j-1].equals(" - ")) {
								continue;
							}
							else if(board.item[i][j-1] != null && board.item[i][j-1].symbol.equals(oppsymbol)){
								count++;
							}
					}
					else if(!(i >= 0 & i < 9 & j-1 >= 0 & j-1 < 9))count++;
					if(i >= 0 & i < 9 & j+1 > 0 & j+1 < 9) {
							if(board.item[i][j+1] != null && board.item[i][j+1].symbol.equals(symbol)) {
								count += Recursion(i,j+1,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							}
							else if(board.the_board[i][j+1].equals(" - ")) {
								continue;
							}
							else if(board.item[i][j+1] != null && board.item[i][j+1].symbol.equals(oppsymbol)){
								count++;
							}
					}
					else if(!(i >= 0 & i < 9 & j+1 > 0 & j+1 < 9))count++;
				}
				
				if(count == 4) {
					index1.add(i);
					index2.add(j);
				}
			}
		}
	}
	private int Recursion(int i,int j,String symbol,int ip,int jp,String oppsymbol) {
		int count = 0;
		for(int k = 0;k < index1_done.length();k++) {
			if(index1_done.charAt(k) == '0'+i) {
				for(int m = 0;m < index2_done.length();m++) {
					if(index2_done.charAt(m) == '0'+j) {
						return 1;
					}
				}
			}
		}
			index1_done += i;
			index2_done += j;
			
			if(i-1 >= 0 & i-1 < 9 & j >= 0 & j < 9) {
				if(!(i-1 == ip & j == jp)) {	
						if(board.item[i-1][j] != null && board.item[i-1][j].symbol.equals(symbol)) {
								count += Recursion(i-1,j,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							}
			
						
						else if(board.the_board[i-1][j].equals(" - ")) {
							return 0;
						}
						else if(board.item[i-1][j] != null && board.item[i-1][j].symbol.equals(oppsymbol)){
							count++;
						}
				}
				else count++;
			}
			else if(!(i-1 >= 0 & i-1 < 9 & j >= 0 & j < 9)) count++;
			if(i+1 >= 0 & i+1 < 9 & j >= 0 & j < 9) {
				if(!(i+1 == ip & j == jp)) {		
						if(board.item[i+1][j] != null && board.item[i+1][j].symbol.equals(symbol)) {
								count += Recursion(i+1,j,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							
			
						}
						else if(board.the_board[i+1][j].equals(" - ")) {
							return 0;
						}
						else if(board.item[i+1][j] != null && board.item[i+1][j].symbol.equals(oppsymbol)){
							count++;
						}
				}
				else count++;
			}
			else if(!(i+1 >= 0 & i+1 < 9 & j >= 0 & j < 9)) count++;
			if(i >= 0 & i < 9 & j-1 >= 0 & j-1 < 9) {
				if(!(i == ip & j-1 == jp)) {		
						if(board.item[i][j-1] != null && board.item[i][j-1].symbol.equals(symbol)) {
								count += Recursion(i,j-1,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
							
			
						}
						else if(board.the_board[i][j-1].equals(" - ")) {
							return 0;
						}
						else if(board.item[i][j-1] != null && board.item[i][j-1].symbol.equals(oppsymbol)){
							count++;
						}
				}
				else count++;
			}
			else if(!(i >= 0 & i < 9 & j-1 >= 0 & j-1 < 9)) count++;
			if(i >= 0 & i < 9 & j+1 > 0 & j+1 < 9) {
				if(!(i == ip & j+1 == jp)) {	
						if(board.item[i][j+1] != null && board.item[i][j+1].symbol.equals(symbol)) {
								count += Recursion(i,j+1,symbol,i,j,oppsymbol);// Recursion 1 dönmeli
						
			
						}
						else if(board.the_board[i][j+1].equals(" - ")) {
							return 0;
						}
						else if(board.item[i][j+1] != null && board.item[i][j+1].symbol.equals(oppsymbol)){
							count++;
						}
				}
				else count++;
			}
			else if(!(i >= 0 & i < 9 & j+1 > 0 & j+1 < 9)) count++;
		
		
		if(count == 4) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	
}
