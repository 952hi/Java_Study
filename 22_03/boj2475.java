import java.io.*;
import java.util.StringTokenizer;
public class boj2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int comp = 0;
		int sum = 0;
		for(int i=0;i<5;i++) {
			comp = Integer.parseInt(stz.nextToken());
			if(comp == 0) continue;
			else sum += (int)Math.pow(comp, 2);
		}
		System.out.println(sum%10);
	}
}
