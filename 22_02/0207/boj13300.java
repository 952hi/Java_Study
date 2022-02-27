import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] comp = new int[6][2];
		int sex,classdigit,res=0;
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken());
		
		for(int t=0;t<n;t++) {
			stz = new StringTokenizer(br.readLine()," ");
			sex = Integer.parseInt(stz.nextToken());
			classdigit = Integer.parseInt(stz.nextToken())-1;
			comp[classdigit][sex] += 1;
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				if(comp[i][j]==0) continue;
				res += Math.ceil((double)comp[i][j]/k);
			}
		}
		System.out.println(res);
	}
}