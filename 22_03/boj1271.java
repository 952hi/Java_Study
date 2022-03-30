package acmicpcNet;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class boj1271 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(stz.nextToken());
		BigInteger m = new BigInteger(stz.nextToken());
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
	}
}