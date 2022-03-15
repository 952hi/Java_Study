import java.io.*;
import java.util.StringTokenizer;
public class boj1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(stz.nextToken());
		int y = Integer.parseInt(stz.nextToken());
		int w = Integer.parseInt(stz.nextToken());
		int h = Integer.parseInt(stz.nextToken());
		int res = Integer.MAX_VALUE;
		res = Math.min(Math.abs(0-x), Math.abs(w-x));
		res = Math.min(res, Math.abs(0-y));
		res = Math.min(res, Math.abs(h-y));
		System.out.println(res);
	}
}
