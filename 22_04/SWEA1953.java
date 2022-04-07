import java.io.*;
import java.util.*;
public class SWEA1953 {
	static int row,col,map[][],time,res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			stz = new StringTokenizer(br.readLine());
			row = Integer.parseInt(stz.nextToken());
			col = Integer.parseInt(stz.nextToken());
			int startx = Integer.parseInt(stz.nextToken());
			int starty = Integer.parseInt(stz.nextToken());
			time = Integer.parseInt(stz.nextToken());
			map = new int[row][col];
			res = 1;
			for (int i = 0; i < row; i++) {
				stz = new StringTokenizer(br.readLine());
				for (int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(stz.nextToken());
				}
			}
			sb.append("#").append(t).append(" ");
			if(time==1) {
				sb.append(1).append("\n");
			}else {
				bfs(startx,starty);
				sb.append(res).append("\n");
			}
		}
		sb.setLength(sb.length());
		bw.write(sb.toString());
		bw.flush();
	}
	// 0동 1서 2남 3북
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } },temp;
	static Queue<Data> q = new LinkedList<Data>();
	private static void bfs(int startx, int starty) {
		temp = new int[row][col];
		q.offer(new Data(startx, starty));
		temp[startx][starty] = 1;
		Data comp;
		int nx,ny;
		while(!q.isEmpty()) {
			comp = q.poll();
			if(map[comp.x][comp.y]==1) {
				for(int i=0;i<4;i++) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==2) {
				for(int i=2;i<4;i++) {
					ny = comp.y + dxdy[1][i];
					nx = comp.x + dxdy[0][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==3) {
				for(int i=0;i<2;i++) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==4) {
				//상 우
				for(int i=0;i<4;i+=3) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==5) {
				// 우 남
				for(int i=0;i<4;i+=2) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==6) {
				for(int i=1;i<3;i++) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}else if(map[comp.x][comp.y]==7) {
				// 상좌
				for(int i=1;i<4;i+=2) {
					nx = comp.x + dxdy[0][i];
					ny = comp.y + dxdy[1][i];
					escape(nx,ny,temp[comp.x][comp.y],i);
				}
			}
		}
	}
	private static void escape(int nx, int ny,int val,int i) {
		if(0<=nx && nx< row && ny< col && ny>= 0 && map[nx][ny]!=0 && temp[nx][ny]==0) {
			if(i==0&&map[nx][ny]==2) return;
			if(i==0&&map[nx][ny]==4) return;
			if(i==0&&map[nx][ny]==5) return;
			if(i==1&&map[nx][ny]==2) return;
			if(i==1&&map[nx][ny]==6) return;
			if(i==1&&map[nx][ny]==7) return;
			if(i==2&&map[nx][ny]==3) return;
			if(i==2&&map[nx][ny]==5) return;
			if(i==2&&map[nx][ny]==6) return;
			if(i==3&&map[nx][ny]==3) return;
			if(i==3&&map[nx][ny]==4) return;
			if(i==3&&map[nx][ny]==7) return;
			temp[nx][ny] =  val+1;
			res++;
			if(time<=val+1) return;
			q.offer(new Data(nx, ny));
		}
	}
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}