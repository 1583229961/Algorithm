package i.algorithm;

import java.util.Arrays;



public class HeapSort {
	public static void main(String args[]) {
		int[] a = new int[] { 16, 25, 34, 27, 30, 5, 7, 4, 41, 55 };
		HeapSort.heapSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void heapSort(int[] a) {
		if (a==null||a.length<=1) {
			return;
		}
		buildheap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			swap(a, 0,i);

			maxheap(a,0, i);
		}
	}

	public static void buildheap(int []a) {
		if (a==null||a.length<=1) {
			return;
		}
		int half=a.length;
		for (int i = half; i >=0; i--) {
			maxheap(a,i, a.length);
		}
	}

	private static void maxheap(int[] a, int i,int heapsize) {
		int left =  i*2 + 1;
		int right = i*2 + 2;
		int largest = i;
	
		if (left < heapsize && a[i] < a[left]) {
			largest = left;
		}
		if (right < heapsize && a[largest] < a[right]) {
			largest = right;
		}
		if (largest != i) {
			swap(a, largest, i);
			maxheap(a, i,heapsize);
			
		}
	}

	private static void swap(int[] a, int a1, int a2) {
		int temp; // java不支持普通类型的引用传递,所以交换值只能通过数组交换
		temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;

	}
}
