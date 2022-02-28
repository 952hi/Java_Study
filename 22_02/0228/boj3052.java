import java.util.Scanner;

public class boj3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] comp = new int[42];
		for(int i=0;i<10;i++) {
			comp[sc.nextInt()%42]+=1;
		}
		int res=0;
		for(int i=0;i<42;i++) {
			if(comp[i]!=0) res++;
		}
		System.out.println(res);
	}
}
