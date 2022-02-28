import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] comp = new int[n];
		StringTokenizer stz= new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) comp[i] = Integer.parseInt(stz.nextToken());
		Arrays.sort(comp);
		int sum = comp[0];
		for(int i=1;i<n;i++) {
			comp[i] += comp[i-1];
			sum += comp[i];
		}
		System.out.println(sum);
	}
}