package i.algorithm.Greed;

public class Activityarrange {

	public static void Arrange(int[] begin, int[] end) {
		int j = 1;
		int count = 1;
		boolean[] b = new boolean[begin.length];
		b[0]=true;
		for (int i = 2; i < end.length; i++) {
			if (begin[i] >= end[j]) {
				j = i;
				b[i] = true;
				count++;
			} else {
				b[i] = false;
			}
		}
		for (int i = 0; i < b.length; i++) {
			if (b[i] ==true) {
				System.out.println(begin[i] + " "+end[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] begin = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] end = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		Arrange(begin, end);
	}

}
