import java.io.*;
import java.util.*;
public class JO1733 {
	static int map[][],cnt;
	static int dxdy[][] = {{1,1,1,0},{-1,0,1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		map = new int[19][19];
		for(int i=0;i<19;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<19;j++) {
				map[i][j]= Integer.parseInt(stz.nextToken());
			}
		}
		boolean check =false;
out:	for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]==1) {
					for(int k=0;k<4;k++) {
						cnt = 1;
						reversdfs(i,j,map[i][j],k);
						dfs(i,j,map[i][j],k);
						if(cnt==5) {
							if(k==0) {
								win(map[i][j],i+5,j-3);
							}else win(map[i][j],i+1,j+1);
							check = true;
							break out;
						}
					}
				}else if(map[i][j]==2){
					for(int k=0;k<4;k++) {
						cnt = 1;
						reversdfs(i,j,map[i][j],k);
						dfs(i,j,map[i][j],k);
						if(cnt==5) {
							if(k==0) {
								win(map[i][j],i+5,j-3);
							}else win(map[i][j],i+1,j+1);
							check = true;
							break out;
						}
					}
				}
			}
		}
		if(!check)System.out.println(0);
	}
	private static void win(int i, int i2, int j) {
		System.out.println(i);
		System.out.println(i2+" "+j);
	}
	private static void dfs(int x, int y, int color,int dir) {
		int nx,ny;
		nx = x+dxdy[0][dir];
		ny = y+dxdy[1][dir];
		if(0<=nx && nx<19 && 0<=ny && ny<19 && map[nx][ny]==color) {
			cnt +=1;
			dfs(nx,ny,color,dir);
		}
	}
	private static void reversdfs(int x, int y, int color,int dir) {
		int nx,ny;
		nx = x-dxdy[0][dir];
		ny = y-dxdy[1][dir];
		if(0<=nx && nx<19 && 0<=ny && ny<19 && map[nx][ny]==color) {
			cnt +=1;
			reversdfs(nx,ny,color,dir);
		}
	}
}