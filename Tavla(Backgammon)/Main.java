import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	
	static Board board;
	
	static int zar1;
	static int zar2;
	static int addition_white;
	static int addition_red;
	public void Show() {
		board.Stones_to_Board();
		for(int i = 0;i < board.the_board.length;i++) {
			for(int j = 0;j < board.the_board[0].length;j++) {
				System.out.print(board.the_board[i][j]);
			}
			System.out.println();
		}
	}
	
	static ReentrantLock lock1 = new ReentrantLock();
	static ReentrantLock lock2 = new ReentrantLock();
	static ReentrantLock lock3 = new ReentrantLock();
	
	public static class White implements Runnable{
		int id;
		String symbol;
		public White(int id) {
			symbol = "w";
			this.id = id;
			
		}
		public void run() {
			
			int zar = 0;
			if(id == 0) zar = zar1;
			else zar = zar2;
			int num = -1;
			int new_num = 0;
			
			lock1.lock();
			if(addition_white > 0) {
				
				if(board.stones[24-zar][0].equals("r") & !board.stones[24-zar][1].equals("r")) {
					board.stones[24-zar][0] = "w";
				
					zar = 0;
					addition_white--;
				}
				else if(board.stones[24-zar][0].equals(" ")) {
					
					board.stones[24-zar][0] = "w";
				
					zar = 0;
					addition_white--;
				}
				else if(board.stones[24-zar][0].equals("w")) {
					int heap = 0;
					for(int j = 0;j < 10;j++) {
						if(!board.stones[24-zar][j].equals("w")) {
							heap = j;
							break;
						}
					}
					board.stones[24-zar][heap] = "w";
					
					zar = 0;
					addition_white--;
				}
			}
			lock1.unlock();
			
			
			boolean no_move = true;
			boolean collect = false;
			
			lock2.lock();
		
			if(board.Game_end_white().equals("w")) {
				collect = true;
				
				if(board.stones[zar-1][0].equals("w")) {
					
					int heap = 0;
					for(int j = 0;j < 10;j++) {
						if(!board.stones[zar-1][j].equals("w")) {
							heap = j;
							break;
						}
					}
					board.stones[zar-1][heap-1] = " ";
				}
				else if(!board.stones[zar-1][0].equals("w")) {
					
					for(int i = 6;i >= 0;i--) {
						for(int j = 9;j >= 0;j--) {
							if(board.stones[i][j].equals("w")) {
								num = i;
								new_num = num - zar;
								if(new_num >= 0 && !board.stones[new_num][1].equals("r")) {
									if(board.stones[new_num][0].equals("r")) {
										addition_red++;
										board.stones[new_num][0] = symbol;
										board.stones[i][j] = " ";
										break;
									}
									else if(board.stones[new_num][0].equals(" ")) {
										board.stones[new_num][0] = symbol;
										board.stones[i][j] = " ";
										break;
										
									}
									else if(board.stones[new_num][0].equals("w")) {
										int heap = 0;
										for(int k = 1;k < board.stones[0].length;k++) {
											if(!board.stones[new_num][k].equals("w")) {
												heap = k;
												break;
											}
										}
										board.stones[new_num][heap] = "w";
										board.stones[i][j] = " ";
									
										break;
									}
									
								}
								no_move = false;
								break;
							}
							num = -1;
						}
						if(num == i)break;
					}
				}
				if(!no_move){
					
					for(int j = zar - 1;j >= 0;j--) {
						if(board.stones[j][0].equals("w")) {
							int heap = 0;
							for(int k = 0;k < 10;k++) {
								if(!board.stones[j][k].equals("w")) {
									heap = k;
									break;
								}
							}
							board.stones[j][heap-1] = " ";
							break;
						}
					}
				}
			}
			lock2.unlock();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock1.lock();
			
			lock1.unlock();
			if(addition_white == 0 & !collect) {
				
				for(int i = board.stones.length - 1;i >= 0;i--) {
					for(int j = 9;j >= 0;j--) {
						if(board.stones[i][j].equals("w")) {
							
							num = i;
							new_num = num - zar;
			
							if(new_num < 24 && new_num >= 0 && !board.stones[new_num][1].equals("r")) {
								lock3.lock();
								if(board.stones[new_num][0].equals("r")) {
									addition_red++;
									board.stones[new_num][0] = symbol;
									board.stones[i][j] = " ";
								
									
								}
								else if(board.stones[new_num][0].equals(" ")) {
									board.stones[new_num][0] = symbol;
									board.stones[i][j] = " ";
								
									
								}
								else if(board.stones[new_num][0].equals("w")) {
									int heap = 0;
									for(int k = 1;k < board.stones[0].length;k++) {
										if(!board.stones[new_num][k].equals("w")) {
											heap = k;
											break;
										}
									}
									board.stones[new_num][heap] = "w";
									board.stones[i][j] = " ";
								
									
								}
								lock3.unlock();
								break;
							}
							num = -1;
						}
					}
					
					if(num == i)break;
				}

			}
			
			
		}
	}
	public static class Red implements Runnable{
		int id;
		String symbol;
		public Red(int id) {
			symbol = "r";
			this.id = id;
			
		}
		public void run() {
			
			int zar = 0;
			if(id == 0) zar = zar1;
			else zar = zar2;
			int num = -1;
			int new_num = 0;
			
			lock1.lock();
			
			if(addition_red > 0) {
				
				if(board.stones[zar-1][0].equals("w") & !board.stones[zar-1][1].equals("w")) {
					board.stones[zar-1][0] = "r";
					
					zar = 0;
					addition_red--;
				}
				else if(board.stones[zar-1][0].equals(" ")) {
					board.stones[zar-1][0] = "r";
			
					zar = 0;
					addition_red--;
				}
				else if(board.stones[zar-1][0].equals("r")) {
					int heap = 0;
					for(int j = 0;j < 10;j++) {
						if(!board.stones[zar-1][j].equals("r")) {
							heap = j;
							break;
						}
					}
					board.stones[zar-1][heap] = "r";
			
					zar = 0;
					addition_red--;
				}
			}
			lock1.unlock();
			
		
			boolean no_move = true;
			boolean collect = false;
			lock2.lock();
	
			if(board.Game_end_red().equals("r")) {
				collect = true;
				
				if(board.stones[24-zar][0].equals("r")) {
			
					int heap = 0;
					for(int j = 0;j < 10;j++) {
						if(!board.stones[24-zar][j].equals("r")) {
							heap = j;
							break;
						}
					}
					board.stones[24-zar][heap - 1] = " ";
				}
				else if(!board.stones[24-zar][0].equals("r")) {
				
					for(int i = 18;i < 24;i++) {
						for(int j = 9;j >= 0;j--) {
							if(board.stones[i][j].equals("r")) {
								num = i;
								new_num = num + zar;
								if(new_num < 24 && !board.stones[new_num][1].equals("w")) {
									if(board.stones[new_num][0].equals("w")) {
										addition_red++;
										board.stones[new_num][0] = symbol;
										board.stones[i][j] = " ";
										break;
									}
									else if(board.stones[new_num][0].equals(" ")) {
										board.stones[new_num][0] = symbol;
										board.stones[i][j] = " ";
										break;
										
									}
									else if(board.stones[new_num][0].equals("r")) {
										int heap = 0;
										for(int k = 1;k < board.stones[0].length;k++) {
											if(!board.stones[new_num][k].equals("r")) {
												heap = k;
												break;
											}
										}
										board.stones[new_num][heap] = "r";
										board.stones[i][j] = " ";
										break;
										
									}
								
								}
								no_move = false;
								break;
							}
							num = -1;
						}
						if(num == i)break;
					}
				}
				if(!no_move){
					
					for(int j = 24 - zar;j < 24;j++) {
						if(board.stones[j][0].equals("r")) {
							int heap = 0;
							for(int k = 0;k < 10;k++) {
								if(!board.stones[j][k].equals("r")) {
									heap = k;
									break;
								}
							}
							board.stones[j][heap-1] = " ";
							break;
						}
					}
				}
			}
			lock2.unlock();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock1.lock();
			
			lock1.unlock();
			if(addition_red == 0 & !collect) {
				
				for(int i = 0;i < board.stones.length;i++) {
					for(int j = 9;j >= 0;j--) {
						if(board.stones[i][j].equals("r")) {
						
							num = i;
							new_num = num + zar;
							
							
							if(new_num < 24 && new_num >= 0 && !board.stones[new_num][1].equals("w")) {
								lock3.lock();
								if(board.stones[new_num][0].equals("w")) {
									addition_white++;
									board.stones[new_num][0] = symbol;
									
									board.stones[i][j] = " ";
								
									
								}
								else if(board.stones[new_num][0].equals(" ")) {
									board.stones[new_num][0] = symbol;
								
									board.stones[i][j] = " ";
									
									
								}
								else if(board.stones[new_num][0].equals("r")) {
									int heap = 0;
									
									for(int k = 1;k < board.stones[0].length;k++) {
										if(!board.stones[new_num][k].equals("r")) {
											heap = k;
											break;
										}
									}
									
									board.stones[new_num][heap] = "r";
									board.stones[i][j] = " ";
									
									
								}
								lock3.unlock();
								break;
							}
							num = -1;
						}
					}
					
					if(num == i)break;
				}
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		board = new Board();
		System.out.println("Oyuna hosgeldiniz");
		System.out.println();
		Thread[] white = new Thread[2];
		Thread[] red = new Thread[2];
		for(int i = 0;i < 2;i++) {
			white[i] = new Thread(new White(i));
			red[i] = new Thread(new Red(i));
		}
		String player1 = "";
		String player2 = "";
		int first_red = 0;
		int first_white = 0;
		main.Show();
		
		do{
			first_red = (int)(Math.random()*6) + 1;
			first_white = (int)(Math.random()*6) + 1;
		}while(first_red == first_white);
		
		System.out.println("red ilk zar : "+first_red);
		System.out.println("white ilk zar : "+first_white);
		
		int clock = 2;
		
		if(first_red > first_white) {
			System.out.println("ilk baslayacak olan Red oyuncusu ");
			player1 = "RED";
			player2 = "WHITE";
		
			
			while(!board.Game_end()) {
				zar1 = (int)(Math.random()*6) + 1;
				zar2 = (int)(Math.random()*6) + 1;
				System.out.println("------------------------------------------------------------------");
				System.out.println(clock+". saniye,"+player1 +" oyuncu , gelen zarlar : "+zar1+" "+zar2);
				
				for(int i = 0;i < red.length;i++) {
					red[i] = new Thread(new Red(i));
					red[i].start();
				}
				for(int i = 0;i < red.length;i++) {
					try {
						red[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				main.Show();
				try {
					Thread.sleep(2000);
					clock+=2;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				zar1 = (int)(Math.random()*6) + 1;
				zar2 = (int)(Math.random()*6) + 1;
				System.out.println("------------------------------------------------------------------");
				System.out.println(clock+". saniye,"+player2 +" oyuncu , gelen zarlar : "+zar1+" "+zar2);
				
				for(int i = 0;i < white.length;i++) {
					white[i] = new Thread(new White(i));
					white[i].start();
				}
				for(int i = 0;i < white.length;i++) {
					try {
						white[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				main.Show();
				try {
					Thread.sleep(2000);
					clock+=2;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("ilk baslayacak olan White oyuncusu ");
			player1 = "WHITE";
			player2 = "RED";

			while(!board.Game_end()) {
				zar1 = (int)(Math.random()*6) + 1;
				zar2 = (int)(Math.random()*6) + 1;
				System.out.println("------------------------------------------------------------------");
				System.out.println(clock+". saniye,"+player1 +" oyuncu , gelen zarlar : "+zar1+" "+zar2);
				
				for(int i = 0;i < white.length;i++) {
					white[i] = new Thread(new White(i));
					white[i].start();
				}
				for(int i = 0;i < white.length;i++) {
					try {
						white[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				main.Show();
				try {
					Thread.sleep(2000);
					clock+=2;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				zar1 = (int)(Math.random()*6) + 1;
				zar2 = (int)(Math.random()*6) + 1;
				System.out.println("------------------------------------------------------------------");
				System.out.println(clock+". saniye,"+player2 +" oyuncu , gelen zarlar : "+zar1+" "+zar2);
				
				for(int i = 0;i < red.length;i++) {
					red[i] = new Thread(new Red(i));
					red[i].start();
				}
				for(int i = 0;i < red.length;i++) {
					try {
						red[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				main.Show();
				try {
					Thread.sleep(2000);
					clock+=2;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		boolean b = true;
		for(int i = 0;i < 6;i++) {
			if(board.stones[i][0].equals("w")) {
				System.out.println("Kazanan : Red");
				b = false;
				break;
			}
		}
		if(b) System.out.println("Kazanan : White");
		
	}

}
