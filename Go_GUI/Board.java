
public class Board {
	
	// BURADA GUI'DEN GELEN TAS BILGILERI SOYUT BIR SEKILDE BIR TAHTAYA KONULMUS 
	// VE ITEM SINIFINA BILGI GONDERILMIS VE ITEM SINIFINDAN BILGI ALINMISTIR.
	
	static Item[][] item;
	static String[][] the_board;
	static String[][] another_board;
	static Item it;
	public Board() {
		the_board = new String[9][9];
		for(int i = 0;i < the_board.length;i++) {
			for(int j = 0;j < the_board.length;j++) {
				the_board[i][j] = " - ";
			}
		}
		item = new Item[9][9];
	}
	static int tur; 
	public void Run() {
		String symbol = "";
		if(tur % 2 == 0) {
			symbol = " x ";
		}
		else symbol = " o ";
		Board_to_Another_board();
		it = new Item(" x ");
		Another_board_to_board();
		board_to_Item();
		
		Remove_and_fill_closed_areas(symbol);
		Item_to_Board();
		
		tur++;
	}
	private void board_to_Item() {
		
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(the_board[i][j].equals(" x ")) {
			
					item[i][j] = new Item(" x ");
				}
				else if(the_board[i][j].equals(" o ")) {
		
					item[i][j] = new Item(" o ");
				}
				else {
					item[i][j] = null;
				}
			}
		}
	}
	private void Board_to_Another_board() {
		another_board = new String[9][9];
		for(int i = 0;i < another_board.length;i++) {
			for(int j = 0;j < another_board.length;j++) {
				another_board[i][j] = " - ";
			}
		}
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(the_board[i][j] != null) {
					if(the_board[i][j].equals(" x ")) {
						another_board[i][j] = " x ";
					}
					else if(the_board[i][j].equals(" o ")) {
						another_board[i][j] = " o ";
					}
					else {
						another_board[i][j] = " - ";
					}
				}
			}
		}
	}
	private void Another_board_to_board() {
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(another_board[i][j].equals(" x ")) {
					the_board[i][j] = " x ";
				}
				else if(another_board[i][j].equals(" o ")) {
					the_board[i][j] = " o ";
				}
				else {
					the_board[i][j] = " - ";
				}
			}
		}
	}
	private void Item_to_Board() {
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(item[i][j] == null) {
					the_board[i][j] = " - ";
				}
				else if(item[i][j].symbol.equals(" x ")) {
					the_board[i][j] = " x ";
				}
				else if(item[i][j].symbol.equals(" o ")) {
					the_board[i][j] = " o ";
				}
			}
		}
	}
	int[] indexi;
	int[] indexj;
	
	private void Remove_and_fill_closed_areas(String symbol) {
		
		String s = "";
		if(symbol.equals(" x "))s = " o ";
		else if(symbol.equals(" o "))s = " x ";
		it.Collect_closed_stones(s);
		
		
		indexi = new int[it.index1.size()];
		for(int i = 0;i < it.index1.size();i++) {
			indexi[i] = it.index1.get(i);
		
		}
		indexj = new int[it.index2.size()];
		for(int j = 0;j < it.index2.size();j++) {
			indexj[j] = it.index2.get(j);
		
		}
		
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				for(int k = 0;k < indexi.length;k++) {
					for(int m = 0;m < indexj.length;m++) {
						if(indexi[k] == i && indexj[m] == j) {
						
							item[i][j].symbol = symbol;
						}
					}
				}
			}
		}
		
		
	}
		
	public boolean Check_for_endgame() {
		for(int i = 0;i < the_board.length;i++) {
			for(int j = 0;j < the_board.length;j++) {
				if(the_board[i][j].equals(" - "))return true;
			}
		}
		return false;
	}
}
