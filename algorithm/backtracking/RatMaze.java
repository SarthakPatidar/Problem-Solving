package algorithm.backtracking;

/*
 *	Given Maze with following labels: 0,1
 *  Problem - Find path so that rat can escape from maze.
 *
 *	[{1, 0, 0, 0}
 *   {1, 1, 0, 0}
 *   {0, 1, 0, 0}
 *   {0, 1, 1, 1}]
 *   
 *   0 => Dead End(Blocked)
 *   1 => Available Path
 *   2 => Followed Path      
 */
public class RatMaze {
	public static int N = 4;

	public static void main(String args[]) {
		solveMaze();
	}

	private static void solveMaze() {
		// TODO Auto-generated method stub
		int[] xNext = { 1, 0 };
		int[] yNext = { 0, 1 };

		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = 1;
			}
		}

		arr[0][1] = arr[0][2] = arr[0][3] = 0;
		arr[1][2] = 0;
		arr[2][0] = arr[2][2] = arr[2][3] = 0;

		arr[0][0] = 2;

		if (solveMazeUtil(arr, 0, 0, xNext, yNext) == true) {
			printArray(arr);
		} else
			System.out.println("There is no way for Rat to escape");
	}

	private static boolean solveMazeUtil(int[][] arr, int x, int y, int[] xNext, int[] yNext) {
		// TODO Auto-generated method stub

		if (x == N - 1 && y == N - 1)
			return true;

		for (int k = 0; k < 2; k++) {
			int xMove = x + xNext[k];
			int yMove = y + yNext[k];

			if (checkConstraint(xMove, yMove, arr) == true) {
				arr[xMove][yMove] = 2;

				if (solveMazeUtil(arr, xMove, yMove, xNext, yNext) == true)
					return true;
				else
					arr[xMove][yMove] = 1;
			}
		}

		return false;
	}

	private static boolean checkConstraint(int x, int y, int[][] arr) {
		// TODO Auto-generated method stub
		if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y] != 0)
			return true;

		return false;
	}

	public static void printArray(int[][] A) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
