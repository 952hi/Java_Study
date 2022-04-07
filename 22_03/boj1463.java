import java.util.*;
public class boj1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int comp[] = new int[n+4];
		comp[0] = 0;
		comp[1] = 0;
		comp[2] = 1;
		comp[3] = 1;
		for(int i=4;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			if(i%3==0) min = Math.min(min, comp[i/3]+1);
			if(i%2==0) min = Math.min(min, comp[i/2]+1);
			min = Math.min(min, comp[i-1]+1);
			comp[i] = min;
		}
		System.out.println(comp[n]);
	}
}