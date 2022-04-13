import java.io.*;
import java.util.*;
public class boj1261 {
	static int map[][],row,col;
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(stz.nextToken());
		row = Integer.parseInt(stz.nextToken());
		map = new int[row][col];
		
		String temp;
		for (int i = 0; i < row; i++) {
			temp = br.readLine();
			for (int j = 0; j < col; j++) {
				if(temp.charAt(j)=='0') continue;
				map[i][j] = -1;
			}
		}
		
		bfs();
		System.out.println(map[row-1][col-1]);
	}
	private static void bfs() {
		boolean visited[][] = new boolean[row][col];
		visited[0][0] = true;
		
		PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1,int[] o2)-> o1[2]-o2[2]);
		q.offer(new int[] {0,0,0});
		int temp[],nx,ny,val;
		
		while(!q.isEmpty()) {
			temp = q.poll();
			val = map[temp[0]][temp[1]];
			if(visited[row-1][col-1]) return;
			for(int i=0;i<4;i++) {
				nx = temp[0] + dxdy[0][i];
				ny = temp[1] + dxdy[1][i];
				if(0<=nx && nx<row && 0<= ny && ny<col && !visited[nx][ny]) {
					if(map[nx][ny]==-1) {
						map[nx][ny] = val+1;
					}else {
						if(map[nx][ny]!=0 && val>map[nx][ny]) continue;
						map[nx][ny] = val;
					}
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny,val});
				}
			}
		}
	}
}
