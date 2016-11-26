
public class main {
	
	private final static int[] H = {2, 1, -1, -2, -2, -1,  1,  2};
	private final static int[] V = {1, 2,  2,  1, -1, -2, -2, -1};
	public static int[][] board;
	public static int N = 8;
	public static int boardSize;
	public static int initialX = 7;
	public static int initialY = 7;
	
	public static void main(String[] args) {
		
		boardSize = N * N;

		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
		
		board[initialX][initialY] = 1;

		if (tryMove(2, initialX, initialY)) {
			System.out.println("Sucesso!");
			drawBoard();
		} 
		else {
			System.out.println("Error!");
		}

	}
	
	
	public static boolean tryMove(int progress, int currentX, int currentY){
		boolean done = (progress > boardSize);
		int move = 0;
		int newX, newY;
		
		while (!done && move < 8) {
			newX = currentX + H[move]; 
			newY = currentY + V[move];
			
			if (newX >= 0 && newX < N && newY >= 0 && newY < N && board[newX][newY] == 0) {
				
				board[newX][newY] = progress;
				
				//System.out.println(progress);
				done = tryMove(progress + 1, newX, newY);
				
				if (!done) {
					board[newX][newY] = 0;
				}
			}
			move++;
		}
		return done;	
	}
	
	public static void drawBoard(){
		
		System.out.println(" ----------------------------------------------");
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(" | " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println(" ----------------------------------------------");
        }
		
	}
	
}
