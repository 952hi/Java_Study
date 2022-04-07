import java.io.*;
import java.util.*;
public class SWEA3307 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			int res = 0;
			int n = Integer.parseInt(br.readLine());
			int[] comp = new int[n];
			int[] temp = new int[n];
			Arrays.fill(temp, 1);
			stz = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) comp[i] = Integer.parseInt(stz.nextToken());
			for(int i=1;i<n;i++) {
				for(int j=0;j<i;j++) {
					if(comp[j]<=comp[i]) {
						if(temp[i]<temp[j]+1) {
							temp[i]=temp[j]+1;
							res = Math.max(res, temp[i]);
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}