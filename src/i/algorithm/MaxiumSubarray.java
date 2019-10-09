package i.algorithm;

public class MaxiumSubarray {

	public static int FindMaxSubarray(int[] A, int low, int high) {
		if (low == high) {
			return A[low];
		} else {
			int mid = (low + high) / 2;
			int Leftmax = FindMaxSubarray(A, low, mid);
			int Rightmax = FindMaxSubarray(A, mid + 1, high);
			int Crossmax = FindMaxCross(A, low, mid, high);
			if (Leftmax > Rightmax && Leftmax > Crossmax) {//比较左右的最大和的大小
				return Leftmax;
			} else if (Rightmax > Leftmax && Rightmax > Crossmax) {
				return Rightmax;
			} else {
				return Crossmax;
			}
		}

	}

	public static  int FindMaxCross(int[] A, int low, int mid, int high) {
		int rightmax = Integer.MIN_VALUE;//设置两个哨兵
		int leftmax = Integer.MIN_VALUE;
		int Maxleft = 0, Maxright = 0;
		for (int i = mid + 1; i <=high; i++) {
			Maxright = Maxright + A[i];

			if (Maxright > rightmax) {
				rightmax = Maxright;//mid右边的最大和

			}
		}
		for (int j = mid; j >= low; j--) {
			Maxleft = Maxleft + A[j];

			if (Maxleft > rightmax) {
				leftmax = Maxleft;//mid左边的最大和

			}
		}
		return leftmax + rightmax;
	}

	public static void main(String[] args) {
		int[] A = { 18,-5,70,-3,58,-99,5,46 };
	int Maxium=	FindMaxSubarray(A, 0, 7);
	System.out.println(Maxium);
	}

}
