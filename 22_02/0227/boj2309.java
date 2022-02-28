import java.io.*;
import java.util.Arrays;

public class boj2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int comp[] = new int[9];
		for(int i=0;i<9;i++) comp[i] = Integer.parseInt(br.readLine());
		int sum=0;
		int one =0;
		int two =0;
		for(int i=0;i<9;i++) sum = sum+comp[i];
		Arrays.sort(comp);
		for(int i=0;i<8;i++) {
			for(int j=1;j<9;j++) {
				if(i==j) continue;
				if(sum-(comp[i]+comp[j])==100) {
					one = i;
					two = j;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(i==one || i==two) continue;
			System.out.println(comp[i]);
		}
	}
}