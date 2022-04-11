import java.io.*;
import java.util.*;

public class boj11401 {
	static long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int r = Integer.parseInt(stz.nextToken());
		sb.append(nCr(n,r));
		bw.write(sb.toString());
		bw.flush();

	}
	private static long nCr(int n, int r) {
		if(r==0) return 1L;
		
		long factorial[] = new long[n+1];
		factorial[0]=1;
		for(int i=1;i<=n;i++) factorial[i] = factorial[i-1] * i % mod;
			
		return (factorial[n]*power(factorial[r],mod-2)%mod*power(factorial[n-r],mod-2)%mod)%mod;
	}
	private static long power(long x,long y) {
		long res = 1L;
		x = x%mod;
		while(y> 0) {
			if(y%2==1) {
				res = (res*x) % mod;
			}
			y = y>>1;
			x = (x*x) % mod;
		}
		return res;
	}
}
