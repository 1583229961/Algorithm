package i.algorithm.dynamic;

public class MaxIncreasingArraay {
	public static void Increase(int a[]) {
			int []dp=new int[a.length+1];
		dp[0]=1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if(a[i]>a[j])
				{
					dp[i]=Math.max(dp[j]+1, dp[i]);		
	//dp存的是以下标结尾的数字前最长的递增子数列,不是整个数组的最长递增子数列,main函数中的a数组就可以证明这点
				}
			}
		}        int max=0;
        for(int i=0; i<a.length; i++){
            if(dp[i]>max)
            	max=dp[i];
        }

		System.out.println(max);
	}

	public static void main(String[] args) {
		int[] a = { 23,5,40,44,45,22,23};
		Increase(a);
	}

}
