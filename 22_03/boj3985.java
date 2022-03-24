import java.io.*;
import java.util.*;
public class boj3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int m = Integer.parseInt(br.readLine());
		int cake[] = new int[m];
		int people = Integer.parseInt(br.readLine());
		int check[] = new int[people+1];
		int max = 0;
		int idx = 0;
		for(int i=0;i<people;i++) {
			stz = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stz.nextToken())-1;
			int end = Integer.parseInt(stz.nextToken());
			if (max < end - start) {
				max = Math.max(max, (end-start));
				idx = i+1;
			}
			for(int j = start;j<end;j++) {
				if(cake[j]!=0) continue;
				cake[j] = i+1;
				check[i+1] += 1;
			}
		}
		System.out.println(idx);
		max = 0;
		for(int i=1;i<people+1;i++) {
			if(max<check[i]) {
				max = check[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}
}