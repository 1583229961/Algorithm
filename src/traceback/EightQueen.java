package traceback;

import java.io.ObjectInputStream.GetField;

public class EightQueen {
	static int num = 8;
	static int sum = 0;
	static int[][] a = new int[num][num];

	static boolean check(int i, int j) {
		for (int k = 0; k < j; k++) {
			if (a[i][k] != 0) {
				return false;
			}
		}
		for (int k = 0; k < i; k++) {
			if (a[k][j] != 0) {
				return false;
			}
		}
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				 if(a[m][n]==1&&Math.abs(m-i)==Math.abs(n-j))
	                    return false;
			}
			for (int n = num-1; n >j; n--) {
				if(a[m][n]==1&&Math.abs(m-i)==Math.abs(n-j))
                    return false;
			}
		}
		return true;
	}
	 static void backtrace(int t){
	        if(t>=num){
	            sum++;
	            for(int i=0;i<num;i++){
	                for(int j=0;j<num;j++)
	                    System.out.print(a[i][j]+" ");
	                System.out.println();
	            }
	            System.out.println();
	        }
	        else{
	                for(int j=0;j<num;j++)
	                    if(check(t,j)){
	                        a[t][j]=1;
	                        backtrace(t+1);
	                       a[t][j]=0;
	                    }
	                
	        }
	    }
	
	public static void main(String[] args) {
	
		backtrace(0);
        System.out.println(sum);
	}

}
