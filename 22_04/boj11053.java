import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int[] temp = new int[n];
		int[] dpFront = new int[n];
		for(int i=0;i<n;i++) {
			temp[i] = Integer.parseInt(stz.nextToken());
		}
		int max=0;
		for(int i=0;i<n;i++) {
			dpFront[i] = 1;
			for(int j=0;j<i;j++) {
				if(temp[j]<temp[i] && dpFront[i]<dpFront[j]+1) {
					dpFront[i] = dpFront[j] +1;
				}
			}
			if(max<dpFront[i]) max = dpFront[i];
		}
		System.out.println(max);
	}
}