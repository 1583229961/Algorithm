package i.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

/**
 * @param a
 */
public static void bucketsort(int []a) {
	int n=a.length;
	ArrayList<Integer>[]b=new ArrayList[n];
	ArrayList<Integer>d=new ArrayList<Integer>();
	for(int i=0;i<n;i++)
	{
		b[i]=new ArrayList<Integer>();
	}
	for (int i = 0; i < n; i++) {
		int c=a[i]/10;
		b[c].add(a[i]);
	}
	for (int i = 0; i < n; i++) {
		Collections.sort(b[i]);;
	}
	for (int i = 0; i < n; i++) {
		if (b[i].size()!=0) {
			
			d.addAll(b[i]);
		}
		
	}
System.out.print(d);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int a[] = {78,17,39,26,72,94,21,12,23,68};
		  bucketsort(a);
		 System.out.println();
	}

}
