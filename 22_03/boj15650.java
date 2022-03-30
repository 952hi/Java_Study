import java.io.*;
import java.util.*;
public class boj15650 {
	static int n, m, comp[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		comp = new int[n];
		
		int idx = 0;
		for(int i=1;i<=n;i++) comp[idx++] = i;
		
		combi(0,0,0);
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void combi(int idx, int cnt, int flag) {
		if(idx==n) {
			if(cnt==m) {
				for(int i=0;i<n;i++) {
					if((flag & 1<<i)!=0 ) {
						sb.append(comp[i]).append(" ");
					}
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
			return;
		}
		combi(idx+1, cnt+1, flag | 1<<idx);
		combi(idx+1, cnt, flag);
	}
}