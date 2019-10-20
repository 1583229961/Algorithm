package i.algorithm.dynamic;

public class Upstairs {
public static int method(int n) {
int num=0;
int a[]=new int[n+1];
a[0]=0;
a[1]=1;
a[2]=2;
for (int i = 3; i <=n; i++) {
	a[i]=a[i-1]+a[i-2];
}
System.out.println(a[n]);
	return num;
}
	public static void main(String[] args) {
method(30);
	}

}
