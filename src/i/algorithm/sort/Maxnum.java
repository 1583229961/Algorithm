package i.algorithm.sort;

public class Maxnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 4, 3, 18, 4, 9 };
		System.out.println(max(a, 0, 0));

	}

	public static int max(int[] a, int i, int ma) {

		if (i < a.length)
		{
			if (a[i] > ma) {
				ma = a[i];
				return max(a, i + 1, ma);
			}
			else {
				return max(a, i + 1, ma);
			}
		}
else {
	return ma;
}
	
		

	}

}
