import java.io.*;
import java.util.*;
public class boj16933 {
	static int row,col,k,map[][],cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		row = Integer.parseInt(stz.nextToken());
		col = Integer.parseInt(stz.nextToken());
		k = Integer.parseInt(stz.nextToken());
		cnt = -1;
		map = new int[row][col];
		String comp;
		for (int i = 0; i < row; i++) {
			comp= br.readLine();
			for (int j = 0; j < col; j++) {
				if(comp.charAt(j)=='0') continue;
				map[i][j] = 1;
			}
		}
		if(row==1 && col==1) {
			System.out.println(1);
		}else {
			bfs(0,0);
			System.out.println(cnt);
		}
	}
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	private static void bfs(int x, int y) {
		Queue<int []> q = new LinkedList<int[]>();
		boolean[][][] visited = new boolean[row][col][k+1];
		visited[x][y][0] = true;
		q.offer(new int[] {x,y,0,0,0});// x,y,k,move,낮밤
		int temp[],nx,ny,val,check,move;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp[0]==row-1 && temp[1]==col-1) {
				cnt = temp[3]+1;
				return;
			}
			for(int i=0;i<4;i++) {
				nx = temp[0] + dxdy[0][i];
				ny = temp[1] + dxdy[1][i];
				if(0<= nx && nx<row && 0<=ny && ny<col && temp[2]<= k) {
					val = temp[2];
					move = temp[3];
					check = temp[4];
					if(map[nx][ny]==1) {
						if(temp[4]==1 ) { // 밤
							q.offer(new int[] {temp[0],temp[1],val,move+1,0});
						}else { // 낮
							val ++;
							if(  val<=k && !visited[nx][ny][val])  {
								q.offer(new int[] {nx,ny,val,move+1,1});
								visited[nx][ny][val] = true;
							}
						}
					}else {
						if(!visited[nx][ny][val] && val<=k) {
							if(check == 1) check = 0;
							else check = 1;
							q.offer(new int[] {nx,ny,val,move+1,check});
							visited[nx][ny][val] = true;
						}
					}
				}
			}
		}
	}
}