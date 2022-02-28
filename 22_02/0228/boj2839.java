import java.util.Scanner;
public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt=0;
		while(true) {
			if(n<=0) break;
			if(n%5==0) {
				cnt=cnt+n/5;
				n= 0;
			}else {
				n=n-3;
				cnt++;
			}
		}
		if(n<0)System.out.println(-1);
		else System.out.println(cnt);
	}
}
