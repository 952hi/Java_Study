import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class boj13277 {
	static int map[][],zero,one,minus,n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(stz.nextToken());
		BigInteger b = new BigInteger(stz.nextToken());
		System.out.println(a.multiply(b));
	}
}
