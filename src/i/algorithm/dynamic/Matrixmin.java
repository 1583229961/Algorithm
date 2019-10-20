package i.algorithm.dynamic;

//给出一个矩阵,只能向右或向下走,计算从左上到右下的最短距离
public class Matrixmin {
	
	public static void min(int a[][]) {
		int line=a.length;
		int row=a[0].length;
		int dp[][]=new int[line][row];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < line; j++) {
				if (i==0&&j==0) {
					dp[0][0]=a[0][0];
				}
				else if (i==0) {
					dp[i][j]=dp[i][j-1]+a[i][j];
				}
				else if(j==0)
				{
					dp[i][j]=dp[i-1][j]+a[i][j];
				}
				else {
					dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+a[i][j];
				}
				
			}
		}
		System.out.println(dp[line-1][row-1]);
		
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 5, 6, 7, 8 }, { 6, 7, 8, 9 } };
		min(a);
	}

}
