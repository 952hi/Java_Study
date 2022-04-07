import java.io.*;
import java.util.*;
public class boj2468 {
	static int n,map[][],res,maxheight=0,minhegiht=Integer.MAX_VALUE;
	static boolean visited[][],checkarea[][];
	static int[][] dxdy= {{0,0,1,-1},{1,-1,0,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		res = 0;
		for(int i=0;i<n;i++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
				if(maxheight<map[i][j]) maxheight = map[i][j];
				if(minhegiht>map[i][j]) minhegiht = map[i][j];
			}
		}
		for(int k=minhegiht;k<maxheight;k++) {
			int val = 0;
			visited = new boolean[n][n];
			checkarea = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]<=k && !visited[i][j]) {
						bfs(i,j,k);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!visited[i][j] && !checkarea[i][j]) {
						checkarea(i,j);
						val++;
					}
				}
			}
			res = Math.max(res, val);
		}
		if(res==0)System.out.println(1);
		else System.out.println(res);
	}
	private static void checkarea(int x, int y) {
		Queue<Data> q = new LinkedList<Data>();
		
		q.offer(new Data(x, y));
		checkarea[x][y]=true;
		int nx,ny;
		Data comp;
		while(!q.isEmpty()) {
			comp = q.poll();
			for(int i=0;i<4;i++) {
				nx = comp.x+dxdy[0][i];
				ny = comp.y+dxdy[1][i];
				if(0<=nx && nx<n && 0<=ny && ny<n && !checkarea[nx][ny] && !visited[nx][ny]) {
					checkarea[nx][ny] =true;
					q.offer(new Data(nx, ny));
				}
			}
		}
		
	}
	private static void bfs(int x,int y,int height) {
		Queue<Data> q = new LinkedList<Data>();
		visited[x][y] = true;
		q.offer(new Data(x, y));
		Data comp;
		int nx,ny;
		while(!q.isEmpty()) {
			comp = q.poll();
			for(int i=0;i<4;i++) {
				nx = comp.x+dxdy[0][i];
				ny = comp.y+dxdy[1][i];
				if(0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && map[nx][ny]<=height) {
					visited[nx][ny] = true;
					q.offer(new Data(nx, ny));
				}
			}
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