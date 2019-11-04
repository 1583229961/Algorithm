package i.algorithm.dynamic;

import java.util.Scanner;

public class CutRope {
	public static void rope(int a) {
		int []dp=new int[a+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		for (int i = 4; i < a+1; i++) {
			for (int j = 0; j <= i/2; j++) {//取j=i/2是为了避免重复的运算.如2*6和6*2相同
				dp[i]=Math.max(dp[j]*dp[i-j],dp[i]);
			}
			
		}
		

		System.out.println(dp[a]);
	}
	
	
public static void main(String []args) {
	Scanner scanner=new Scanner(System.in);
	int a=scanner.nextInt();
	rope(a);
}
}
