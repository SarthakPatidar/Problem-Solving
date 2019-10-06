package algorithm.backtracking;

/*
 * Problem - 
 * 	Given a Knight in a chess board of NxN dimensions.
 * 	Find path taken by Knight so that it would visit
 *  every box exactly once and cover the entire board.
 */
public class KnightsMove {

	private static int N = 8; // size of chess board

	public static void main(String args[]) {
		solveKnight();
	}

	private static void solveKnight() {
		int x[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int sol[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = -1;
			}
		}

		sol[0][0] = 0;

		if (solveKnightUtil(0, 0, 1, x, y, sol) == false) {
			return;
		} else {
			printSol(sol);
		}
	}

	private static void printSol(int[][] sol) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static boolean solveKnightUtil(int x_val, int y_val, int moveNumber, int[] x, int[] y, int[][] sol) {
		// TODO Auto-generated method stub

		if (moveNumber == N * N)
			return true;

		for (int i = 0; i < N; i++) {
			int next_x = x_val + x[i];
			int next_y = y_val + y[i];

			if (isSafe(next_x, next_y, sol) == true) {

				sol[next_x][next_y] = moveNumber;

				if (solveKnightUtil(next_x, next_y, moveNumber + 1, x, y, sol) == true) {
					return true;
				} else {
					sol[next_x][next_y] = -1;
				}
			}
		}

		return false;
	}

	private static boolean isSafe(int x, int y, int[][] sol) {
		// TODO Auto-generated method stub
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
	}
}
