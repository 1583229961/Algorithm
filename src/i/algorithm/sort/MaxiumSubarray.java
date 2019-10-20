package i.algorithm.sort;

public class MaxiumSubarray {

	public static int FindMaxSubarray(int[] A, int low, int high) {
		if (low == high) {
			return A[low];
		} else {
			int mid = (low + high) / 2;
			int Leftmax = FindMaxSubarray(A, low, mid);
			int Rightmax = FindMaxSubarray(A, mid + 1, high);
			int Crossmax = FindMaxCross(A, low, mid, high);
			if (Leftmax > Rightmax && Leftmax > Crossmax) {//�Ƚ����ҵ����͵Ĵ�С
				return Leftmax;
			} else if (Rightmax > Leftmax && Rightmax > Crossmax) {
				return Rightmax;
			} else {
				return Crossmax;
			}
		}

	}

	public static  int FindMaxCross(int[] A, int low, int mid, int high) {
		int rightmax = Integer.MIN_VALUE;//���������ڱ�
		int leftmax = Integer.MIN_VALUE;
		int Maxleft = 0, Maxright = 0;
		for (int i = mid + 1; i <=high; i++) {
			Maxright = Maxright + A[i];

			if (Maxright > rightmax) {
				rightmax = Maxright;//mid�ұߵ�����

			}
		}
		for (int j = mid; j >= low; j--) {
			Maxleft = Maxleft + A[j];

			if (Maxleft > rightmax) {
				leftmax = Maxleft;//mid��ߵ�����

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
