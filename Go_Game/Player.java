import java.util.Scanner;

public class Player{
	int has_area;
	static Board board = new Board();
	String symbol;
	public Player(String symbol){
		has_area = 0;
		this.symbol = symbol;
	}
	
	
	public int Calcuate_areas(String symbol) {
		int areas = 0;
		for(int i = 0;i < board.the_board.length;i++) {
			for(int j = 0;j < board.the_board.length;j++) {
				if(board.the_board[i][j].equals(symbol)) {
					areas += 1;
				}
			}
		}
		return areas;
	}
	
	
	
}
