package i.algorithm.sort;

import javax.naming.ldap.SortControl;

public class QuickSort {

	public static void Sort(int[] A, int low, int high) {
		if (low < high) {
			int index = quicksort(A, low, high);
			quicksort(A, low, index - 1);
			quicksort(A, index + 1, high);

		}
	}

	public static int quicksort(int[] A, int low, int high) {
		int Temp = A[low];
		while (low < high) {
			while (low < high && A[high] >= Temp) {
				high--;
			}
			A[low] = A[high];
			while (low < high && A[low] <= Temp) {
				low++;
			}
			A[high] = A[low];
		}
		A[low] = Temp;
		return high;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 5, 8, 4, 9, 1, 7, 6, 88 };
		Sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.println(i);
		}

	}

}
