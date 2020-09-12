public class Board {
	
	static String[][] the_board;
	String[][] stones;
	public Board() {
		stones = new String[24][10];
		
		for(int i = 0;i < stones.length;i++) {
			for(int j = 0;j < stones[0].length;j++) {
				stones[i][j] = " ";
			}
		}
		Initial_Sequence();
		the_board = new String[17][53];
		for(int i = 0;i < the_board[0].length;i++) {
			the_board[0][i] = "_";
			the_board[15][i] = "_";
		}
		the_board[8][25] = "B";
		the_board[8][26] = "A";
		the_board[8][27] = "R";
		for(int i = 1;i < the_board.length - 1;i++) {
				
				the_board[i][0] = "|";
				the_board[i][52] = "|";
				the_board[i][24] = "|";
				the_board[i][28] = "|";
		}
		
		int count = 6;
		for(int i = 30;i < 52;i += 4) {
			the_board[14][i] = count + "";
			count--;
		}
		count = 7;
		for(int i = 22;i > 13 ;i -= 4) {
			the_board[14][i] = count + "";
			count++;
		}
		the_board[14][10] = "0";
		the_board[14][9] = "1";
		the_board[14][6]  = "1";
		the_board[14][5]  = "1";
		the_board[14][2]  = "2";
		the_board[14][1]  = "1";
		for(int i = 1;i < 22;i += 4) {
			the_board[2][i] = "1";
		}
		count = 3;
		for(int i = 2;i < 23;i += 4) {
			the_board[2][i] = count + "";
			count++;
		}
		the_board[2][29] = "1";
		the_board[2][30] = "9";
		for(int i = 33;i < 50;i += 4) {
			the_board[2][i] = "2";
		}
		count = 0;
		for(int i = 34;i < 51;i += 4) {
			the_board[2][i] = count + "";
			count++;
		}
		for(int i = 0;i < the_board.length;i++) {
			for(int j = 0;j < the_board[0].length;j++) {
				if(the_board[i][j] == null) {
					the_board[i][j] = " ";
				}
			}
		}
		Stones_to_Board();
	}
	
	private void Initial_Sequence() {
		for(int i = 0;i < 2;i++) {
			stones[0][i] = "r";
			stones[23][i] = "w";
		}
		for(int i = 0;i < 3;i++) {
			stones[7][i] = "w";
			stones[16][i] = "r";
		}
		for(int i = 0;i < 5;i++) {
			stones[5][i] = "w";
			stones[12][i] = "w";
			stones[11][i] = "r";
			stones[18][i] = "r";
		}
	}
	
	public String Game_end_white() {
		boolean bool = true;
		
		for(int i = 6;i < 24;i++) {
			if(stones[i][0].equals("w")) {
				bool = false;
				break;
			}
		}
	
		if(bool)return "w";
		
		else {
			return "";
		}
	}
	public String Game_end_red() {
		boolean bool = true;
		
		for(int i = 0;i < 18;i++) {
			if(stones[i][0].equals("r")) {
				bool = false;
				break;
			}
		}
		
		if(bool)return "r";
		else return "";
	}
	public boolean Game_end() {
		int count = 0;
		for(int i = 0;i < stones.length;i++) {
			if(stones[i][0].equals("w")) {
				count++;
				break;
			}
		}
		for(int i = 0;i < stones.length;i++) {
			if(stones[i][0].equals("r")) {
				count++;
				break;
			}
		}
		if(count == 2)return false;
		else return true;
	}
	public void Stones_to_Board() {
		
		

		for(int i = 0;i < 5;i++) {
			int j = 0;
			while(j < 6) {
				for(int m = 50;m > 29;m-=4) {
					the_board[i+9][m] = stones[j][4-i];
					j++;
				}
			}
			while(j >= 6 & j < 12) {
				for(int m = 22;m > 1;m -=4) {
					the_board[i+9][m] = stones[j][4-i];
					j++;
				}
			}
			while(j >= 12 & j < 18) {
				for(int m = 2;m <= 22;m +=4) {
					the_board[i+3][m] = stones[j][i];
					j++;
				}
			}
			while(j >= 18 & j < 24) {
				for(int m = 30;m <= 50;m +=4) {
					the_board[i+3][m] = stones[j][i];
					j++;
				}
			}
			
		}

		for(int i = 5;i < 10;i++) {
			int j = 0;
			while(j < 6) {
				for(int m = 49;m > 28;m-=4) {
					the_board[i+4][m] = stones[j][14-i];
					j++;
				}
			}
			while(j >= 6 & j < 12) {
				for(int m = 21;m > 0;m -=4) {
					the_board[i+4][m] = stones[j][14-i];
					j++;
				}
			}
			while(j >= 12 & j < 18) {
				for(int m = 1;m <= 21;m +=4) {
					the_board[i-2][m] = stones[j][i];
					j++;
				}
			}
			while(j >= 18 & j < 24) {
				for(int m = 29;m <= 49;m +=4) {
					the_board[i-2][m] = stones[j][i];
					j++;
				}
			}
			
		}
		
		
		
	}
}
