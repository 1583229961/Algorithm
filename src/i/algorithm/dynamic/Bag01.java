package i.algorithm.dynamic;


//分析
//第i件商品装或者不装.不装就是i-1的价值,装的话比较装入i的最大价值与不装i-1的价值
public class Bag01 {
	public static void bag(int n, int[] weight, int[] value, int max) {
		int[] w = new int[weight.length + 1];
		int[] v = new int[value.length + 1];
		int[][] d = new int[n+1][max+1];
		for (int i = 1; i < value.length+1; i++) {
			v[i] = value[i-1];
		}
		for (int j = 1; j < weight.length+1; j++) {
			w[j] = weight[j-1];
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < max+1; j++) {
				if (j < w[i]) {//背包容量小于商品,不装
					d[i][j] = d[i - 1][j];
				} else {
					d[i][j] = max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]);
				}

			}
		}

		System.out.println(d[n][max]);
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return (i > j) ? i : j;
	}

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 5 };
		int b[] = { 3, 4, 11, 7 };
		int bag = 8;
		bag(4, a, b, bag);
	}
}
