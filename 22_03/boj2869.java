import java.io.*;
import java.util.StringTokenizer;
public class boj2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(stz.nextToken());
		int b = Integer.parseInt(stz.nextToken());
		int v = Integer.parseInt(stz.nextToken());
		double res =0.0;
		v = v-b;
		a = a-b;
		res = (double)v/a;
		System.out.println((int)Math.ceil(res));
	}
}
