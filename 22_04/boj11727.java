import java.io.*;
public class boj11727 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long dp[] = new long[n+3];
		dp[1]=1;dp[2]=3;
		for(int i=3;i<=n;i++) dp[i]=(dp[i-1]+(dp[i-2]*2))%10007;
		System.out.println(dp[n]);
	}
}