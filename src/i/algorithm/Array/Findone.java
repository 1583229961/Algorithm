package i.algorithm.Array;
//找出数组中只出现一次的数字
public class Findone {
public static int  Find(int []a,int times) {
	int one=0;
	int n=a.length;
	int []count=new int[32];
	for (int i = 0; i <n; i++) {
		for (int j = 0; j < 32; j++) {
			count[j]+=((a[i]>>j)&1);
			
		}
	}
	for (int j = 0; j < 32; j++) {
		if(count[j]%times!=0)
		{
			one+=(1<<j);
		}
		
	}
	return one;
}
	public static void main(String []args) {
		int []a= {1,1,1,2,2,2,4};
		int num=Find(a, 3);
		System.out.println(num);
	}
	
}
