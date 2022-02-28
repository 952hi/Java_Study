import java.io.*;
import java.util.StringTokenizer;
public class boj2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		int res=0;
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[100][100];
		for(int t=0;t<n;t++) {
			stz = new StringTokenizer(br.readLine()," ");
			int col = Integer.parseInt(stz.nextToken());
			int row = Integer.parseInt(stz.nextToken());
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					map[i+row][j+col]=1;
				}
			}
		}
		int dxdy[][] = {{0,0,1,-1},{-1,1,0,0}};
		int nx,ny;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]==0 || map[i][j]==2) continue;
				for(int k=0;k<4;k++) {
					nx = i+dxdy[0][k];
					ny = j+dxdy[1][k];
					if(0<=nx && ny<100 && nx<100 && 0<=ny) {
						if(map[nx][ny]==0) {
							res++;
						}
					}else {
						res++;
					}
				}
			}
		}
		System.out.println(res);
	}
}
