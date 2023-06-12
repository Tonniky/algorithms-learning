package zcyversion.chapter_4_recursionanddp;

public class Problem_02_MinPathSum {

	public static int minPathSum1(int[][] m) {   //
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {   //对边界情况进行考虑
			return 0;
		}
		int row = m.length;                          //行的数目
		int col = m[0].length;                       //列的数目
		int[][] dp = new int[row][col];              //使用二维数组排列
		dp[0][0] = m[0][0];                          //对[0][0]点进行赋值
		for (int i = 1; i < row; i++) {              //对行进行赋值    dp[i][0]
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {              //对列进行赋值    dp[0][j]
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];   //对两边的值进行比较，取较小的
			}
		}
		return dp[row - 1][col - 1];           //返回最低端的值
	}

	public static int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length); 	//判断是行还是列多
		int less = Math.min(m.length, m[0].length); 	//
		boolean rowmore = more == m.length;             //是否行更多
		int[] arr = new int[less];                      //使用
		arr[0] = m[0][0];                               //对arr[0]进行赋值
		for (int i = 1; i < less; i++) {                //
			arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);   //对less的值进行赋值
		}
		for (int i = 1; i < more; i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);       //
			for (int j = 1; j < less; j++) {                       //
				arr[j] = Math.min(arr[j - 1], arr[j])
						+ (rowmore ? m[i][j] : m[j][i]);
			}
		}
		return arr[less - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	// for test
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// int[][] m = generateRandomMatrix(3, 4);
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 },
				{ 8, 8, 4, 0 } };
		printMatrix(m);
		System.out.println(minPathSum1(m));
		System.out.println(minPathSum2(m));

	}
}
