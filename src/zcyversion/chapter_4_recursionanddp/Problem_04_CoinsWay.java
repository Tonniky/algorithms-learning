package zcyversion.chapter_4_recursionanddp;

public class Problem_04_CoinsWay {

	public static int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	public static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {      //最终的结果
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {                  //暴力递归
				res += process1(arr, index + 1, aim - arr[index] * i);     //
			}
		}
		return res;
	}

	public static int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {				//排除特殊情况
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];                 //创建一个二维数值
		return process2(arr, 0, aim, map);
	}

	public static int process2(int[] arr, int index, int aim, int[][] map) {       //
		int res = 0;
		if (index == arr.length) {                                                //最终运行到末尾
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {						   //一个循环
				mapValue = map[index + 1][aim - arr[index] * i];				   //map[index+1][aim-arr[index]*i];
				if (mapValue != 0) {					   						   //
					res += mapValue == -1 ? 0 : mapValue;						   //
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);	   //
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;     //将
		return res;
	}

	public static int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {   //对边缘进行判断
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < arr.length; i++) {		//
			for (int j = 1; j <= aim; j++) {
				num = 0;
				for (int k = 0; j - arr[i] * k >= 0; k++) {    //
					num += dp[i - 1][j - arr[i] * k];  //如果使用一个arr[i]的值，
				}
				dp[i][j] = num;                        //那么统计所有的值
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {				//统计边界上的值
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {           //列边界，只对固定位置进行排序
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];    							 //只用i-1种货币的情况
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;     //那么还有的使用先期使用i个arr[i]使用的值
			}
		}
		return dp[arr.length - 1][aim];									//
	}

	public static int coins5(int[] arr, int aim) {	      //
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		for (int j = 0; arr[0] * j <= aim; j++) {
			dp[arr[0] * j] = 1;                 //讨论边界情况
		}
		for (int i = 1; i < arr.length; i++) {                      //
			for (int j = 1; j <= aim; j++) {
				dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;		//
			}
		}
		return dp[aim];
	}

	public static void main(String[] args) {
		int[] coins = { 10, 5, 1, 25 };
		int aim = 2000;

		long start = 0;
		long end = 0;
		System.out.println("===========�����ݹ�ķ���===========");
		start = System.currentTimeMillis();
		System.out.println(coins1(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		aim = 20000;

		System.out.println("===========���������ķ���===========");
		start = System.currentTimeMillis();
		System.out.println(coins2(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("=====��̬�滮O(N*(aim^2))�ķ���=====");
		start = System.currentTimeMillis();
		System.out.println(coins3(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("=======��̬�滮O(N*aim)�ķ���=======");
		start = System.currentTimeMillis();
		System.out.println(coins4(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("====��̬�滮O(N*aim)�ķ���+�ռ�ѹ��===");
		start = System.currentTimeMillis();
		System.out.println(coins5(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

	}

}
