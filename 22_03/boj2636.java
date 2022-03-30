import java.io.*;
import java.util.*;
public class boj2636 {
	static int r,c,map[][],res,cnt;
	static int [][]dxdy = {{0,0,1,-1},{1,-1,0,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		r= Integer.parseInt(stz.nextToken());
		c= Integer.parseInt(stz.nextToken());
		res =0;
		cnt =0;
		map = new int[r][c];
		for(int i=0;i<r;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<c;j++) {
				
				map[i][j] = Integer.parseInt(stz.nextToken());
				if(map[i][j]==1) cnt+=1;
			}
		}
		cheese(0);
//		for(int i=0;i<r;i++) System.out.println(Arrays.toString(map[i]));
	}
	private static void cheese(int time) {
		int i = 0;
		for(int y=0;y<c;y++) {
			if(map[i][y]==0) {
				air(i,y);
			}
		}
		int j = 0;
		for(int x=0;x<r;x++) {
			if(map[x][j]==0) {
				air(x,j);
			}
		}
		i = r-1;
		for(int y=0;y<c;y++) {
			if(map[i][y]==0) {
				air(i,y);
			}
		}
		j = c-1;
		for(int x=0;x<r;x++) {
			if(map[x][j]==0) {
				air(x,j);
			}
		}
		int nx,ny;
		int count =0;
		for(int x=1;x<r-1;x++) {
			for(int y=1;y<c-1;y++) {
				if(map[x][y]==1 ) {
					for(int k=0;k<4;k++) {
						nx = x + dxdy[0][k];
						ny = y + dxdy[1][k];
						if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny]==-1) {
							map[x][y]=0;
							count +=1;
							break;
						}
					}
				}
			}
		}
		for(int x=0;x<r;x++) {
			for(int y=0;y<c;y++) {
				if(map[x][y]==-1) map[x][y]=0;
			}
		}
		if(cnt-count>0) {
			cnt = cnt -count;
			cheese(time+1);
		}else {
			System.out.println(time+1);
			System.out.println(cnt);
			return;
		}
	}
	private static void air(int x, int y) {
		int nx,ny;
		for(int i=0;i<4;i++) {
			nx = x + dxdy[0][i];
			ny = y + dxdy[1][i];
			if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny]==0) {
				map[nx][ny]=-1;
				air(nx,ny);
			}
		}
	}
}