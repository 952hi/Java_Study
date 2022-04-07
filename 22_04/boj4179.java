import java.io.*;
import java.util.*;
public class boj4179 {
	static int map[][],time,row,col;
	static boolean visited[][][];
	static int[][] dxdy = {{0,0,1,-1},{1,-1,0,0}};
	static Queue<Data> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		row = Integer.parseInt(stz.nextToken());
		col = Integer.parseInt(stz.nextToken());
		String temp;
		map = new int[row][col];
		visited = new boolean[row][col][2];
		Data start = null;
		
		List<Data> list = new ArrayList<Data>(); 
		for (int i = 0; i < row; i++) {
			temp = br.readLine();
			for (int j = 0; j < col; j++) {
				if(temp.charAt(j)=='#') {
					map[i][j]=-1;
				}else if(temp.charAt(j)=='J') {
					map[i][j]=1;
					start = new Data(i, j);
				}else if(temp.charAt(j)=='F') {
					map[i][j]=-2;
					list.add(new Data(i, j));
				}
			}
		}
		q.add(start);
		visited[start.x][start.y][0]=true;
		for(int i=0,size=list.size();i<size;i++) {
			visited[list.get(i).x][list.get(i).y][1] = true;
			q.add(list.get(i));
		}
		if(start.x == 0 || start.y ==0) {
			System.out.println(1);
		}else bfs();
	}
	private static void bfs() {
		Data comp;
		int nx,ny;
		int check =2;
		while(!q.isEmpty()) {
			comp = q.poll();
			if(map[comp.x][comp.y]==check) {
				if(escape()) return;
				else check+=1;
			}
			for(int i=0;i<4;i++) {
				nx = comp.x + dxdy[0][i];
				ny = comp.y + dxdy[1][i];
				if(0<=nx && nx<row && ny<col && 0<=ny && map[nx][ny]!=-1 ) {
					if(map[comp.x][comp.y]>0) {
						if(map[nx][ny]==-2 || visited[nx][ny][0]) continue;
						visited[nx][ny][0] = true;
						map[nx][ny]= map[comp.x][comp.y]+1;
						q.offer(new Data(nx, ny));
					}else if(map[comp.x][comp.y]==-2) {
						if(visited[nx][ny][1]) continue;
						visited[nx][ny][1]=true;
						map[nx][ny] = -2;
						q.offer(new Data(nx, ny));
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	private static boolean escape() {
		int min = Integer.MAX_VALUE;
		// 테두리 상단
		for(int i=0;i<col;i++) {
			if(map[0][i]>0) {
				min = Math.min(min, map[0][i]);
			}
		}
		// 테두리 하단
		for(int i=0;i<col;i++) {
			if(map[row-1][i]>0) {
				min = Math.min(min, map[row-1][i]);
			}
		}
		// 테두리 좌측
		for(int i=0;i<row;i++) {
			if(map[i][0]>0) {
				min = Math.min(min, map[i][0]);
			}
		}
		// 테두리 우측
		for(int i=0;i<row;i++) {
			if(map[i][col-1]>0) {
				min = Math.min(min, map[i][col-1]);
			}
		}
		if(min!=Integer.MAX_VALUE) {
			System.out.println(min);
			return true;
		}else return false;
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

