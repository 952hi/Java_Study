import java.io.*;
import java.util.*;
public class boj14889 {
	static int n,map[][],res=Integer.MAX_VALUE;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		perm(0,0);
		System.out.println(res);
	}
	private static void perm(int idx,int cnt) {
		if(cnt==n/2) {
			score();
			return;
		}
		if(idx==n) return;
		if(res==0) return;
		
		check[idx] = true;
		perm(idx+1,cnt+1);
		check[idx] = false;
		perm(idx+1,cnt);
	}
	private static void score() {
		int[] teamA = new int[n/2];
		int[] teamB = new int[n/2];
		
		int idxa=0,idxb=0;
		for(int i=0;i<n;i++) {
			if(check[i]==true) {
				teamA[idxa++] = i;
			}else if(check[i]==false) {
				teamB[idxb++] = i;
			}
		}
		int sumA=0,sumB=0;
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n/2;j++) {
				if(i==j) continue;
				sumA += map[teamA[i]][teamA[j]];
				sumB += map[teamB[i]][teamB[j]];
			}
		}
		res = Math.min(res, Math.abs(sumA-sumB));
	}
}