package i.algorithm.Greed;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Machine {

	/**
	 * @param a
	 * @param m
	 */
	public static void work(Integer[] a, int m) {
		int l = a.length;
		int b=l/m;
		int[] time = new int[m];
		Arrays.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return -1;
				} else if (o1 < o2) {
					return 1;
				} else {
					return 0;
				}
			}

		});
		
		if (a.length < m) {
			
			for (int i = 0; i < m ; i++) {
				time[i] = a[i];
			}
		}

		else {
			for (int i = 0; i < m ; i++) {
				time[i] = a[i];
			}
			for (int i = m; i < a.length; i++) {
				
				Arrays.sort(time);
				time[0]=time[0]+a[i];
			}
			
		}
		System.out.println(time[m-1]);
	}

	public static void main(String[] args) {
		Integer[] a = { 0, 2, 14, 4, 16, 6, 5, 3 };
		int m = 3;
		work(a, m);
	}

}
