package i.algorithm.Greed;

public class Change {
	public static void min(int money, int[] a) {
		int amount[] = new int[a.length];
		for (int i = a.length - 1; i >=0; i--) {
			if (money >= a[i]) {
				amount[i] = money / a[i];
				money = money % a[i];
			}
			
		}
		for (int i = 0; i < amount.length; i++) {
			System.out.println(amount[i]);
		}

	}
	public static void main(String[] args) {
		int[] change = { 1, 2, 4, 50 };
		min(30, change);
	}

}
