package i.algorithm.dynamic;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Change {

	/*******
	 * 
	 * 
	 * 
	 * @param money
	 * @param a     定义数组存储每一步的最优解, 0 1 2 3 4 5 6 ..... 0 1 5 10 50
	 * 
	 */
	// 二维数组法
	public static void givechange(int money, int[] a) {
		int d[][] = new int[a.length][money + 1];// 定义二位数组,储存使用I种钱的次数
		for (int i = 1; i < money + 1; i++) {
			if (i % a[0] == 0) {
				d[0][i] = 1;
			}
		}
		for (int i = 0; i < a.length; i++) {
			d[i][0] = 1;
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < money + 1; j++) {
				if (j < a[i]) {
					d[i][j] = d[i - 1][j];// 零钱比面值小,不能使用该面值的钱找零
				} else {
					d[i][j] = d[i - 1][j] + d[i][j - a[i]];
				}
			}
		}

		System.out.println(d[a.length - 1][money]);
	}

	// 一维数组法
	public static int change2(int amount, int[] coins) {
		int dp[] = new int[amount + 1];
		// 初始化第一个，代表金额为1时的组合数即0+0+0+0...这1种组合
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) { // 依次更新钱数为0--amount的组合数
				if (j >= coins[i]) { // 如果当前的钱比钱的面额大
					dp[j] += dp[j - coins[i]]; // 当前的组合数 =之前的组合数 + dp[j-coins[i]]的组合数
				}
			}
		}
		System.out.println(dp[amount]);
		return dp[amount];

	}

	// 寻找最小硬币数
	public static void min(int money, int[] a) {
		int amount[] = new int[a.length];
		for (int i = a.length - 1; i >=0; i--) {
			if (money >= a[i]) {
				amount[i] = money / a[i];
				money = money % a[i];
			}
			
		}
		for (int i = 0; i < amount.length; i++) {
			System.out.println(amount[i]);
		}

	}

	public static void min2(int money,int []a)	{
		
		int []dp=new int [money+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i]=666;
		}
		for(int i = 0;i<=money;i++){
		//	dp[i]=Integer.MAX_VALUE;
	        for(int j = 0;j<a.length;j++){
	            if(i >=a[j]){
	                dp[i] = Math.min(dp[i],dp[i-a[j]]+1);
	                
	            }
	        }
	    }
		
	System.out.println(dp[money]);
		
	}

	public static void main(String[] args) {
		int[] change = { 1, 2, 4, 50 };
		
		/*
		 * givechange(20, change); change2(20, change); min(6, change);
		 */
		  min2(23, change);
	}
}
