package i.algorithm;

import javax.naming.ldap.SortControl;

public class QuickSort3 {

	public static void Sort(int[] A, int low, int high) {
		if (low < high) {
			int index = quicksort(A, low, high);
			quicksort(A, low, index - 1);
			quicksort(A, index + 1, high);

		}
	}

	public static int quicksort(int[] A, int low, int high) {
		int Temp = low;
		while (low < high) {
			while (low < high && A[high] >= A[Temp]) {
				high--;
			}
		
			while (low < high && A[low] <= A[Temp]) {
				low++;
			}
	
			swap(A, low, high);
		
		}
		swap(A, low, Temp);
		return low;
	}
	public static void swap(int [] a,int a1, int a2) {
		int temp;							//java不支持普通类型的引用传递,所以交换值只能通过数组交换
		temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;

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
