import java.io.*;
import java.util.StringTokenizer;
public class boj15649 {
	static int n,m,comp[],res[];
	static boolean checked[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		
		comp = new int[n];
		res = new int[m];
		checked = new boolean[n];
		
		int idx = 0;
		for(int i=1;i<=n;i++) comp[idx++] = i;
		perm(0);
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void perm(int idx) {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				sb.append(res[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if(checked[i]) continue;
			checked[i] = true;
			res[idx] = comp[i];
			perm(idx+1);
			checked[i] = false;
		}
	}
}