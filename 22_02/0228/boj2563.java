import java.io.*;
import java.util.StringTokenizer;
public class boj2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int n = Integer.parseInt(br.readLine());
		int start,end;
		int map[][] = new int[100][100];
		for(int t=0;t<n;t++) {
			stz = new StringTokenizer(br.readLine()," ");
			start = Integer.parseInt(stz.nextToken())-1;
			end = Integer.parseInt(stz.nextToken())-1;
			
			for(int x=0;x<10;x++) {
				for(int y=0;y<10;y++) {
					map[x+end][y+start] =1;
				}
			}
		}
		int sum=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}