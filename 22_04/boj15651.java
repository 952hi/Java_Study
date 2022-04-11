import java.io.*;
import java.util.*;
public class boj15651 {
	static int input[],n,cnt,res[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stz.nextToken());
		cnt = Integer.parseInt(stz.nextToken());
		input = new int[n];
		res = new int[cnt];
		int j=1;
		for(int i=0;i<n;i++) input[i] = j++;
		perm(0);
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void perm(int idx) {
		if(idx == cnt) {
			for(int i=0;i<cnt;i++) sb.append(res[i]).append(" ");
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			res[idx] = input[i];
			perm(idx+1);
		}
	}
}
