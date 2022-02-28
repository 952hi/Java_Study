import java.util.Scanner;

public class boj2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int comp = 1;
		if(n==1) {
			System.out.println(1);
		}
		else {
			for(int i=1;i<n;i++) {
				comp = comp+6*i;
				if(comp>=n) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
