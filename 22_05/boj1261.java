import java.io.*;
import java.util.*;
public class boj1261 {
	static int row,col,cnt;
	static char comp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		col = Integer.parseInt(stz.nextToken());
		row = Integer.parseInt(stz.nextToken());
		comp = new char[row][col];
		for (int i = 0; i < row; i++) comp[i] = br.readLine().toCharArray();
		bfs();
		System.out.println(cnt);
	}
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		q.offer(new int[] {0,0,0});//x y
		int temp[],nx,ny,val;
		boolean checked[][] = new boolean[row][col];
		checked[0][0] = true;
		
		while(!q.isEmpty()) {
			temp = q.poll();
			// 도착하면 리턴
			if(temp[0]==row-1 && col-1==temp[1]) {
				cnt = temp[2]; 
				return;
			}
			for(int i=0;i<4;i++) {
				nx = temp[0]+dxdy[0][i];
				ny = temp[1]+dxdy[1][i];
				// 방문체크 및 범위 확인
				if(0<=nx && nx<row && 0<=ny && ny<col && !checked[nx][ny]) {
					val = temp[2];
					// 벽있으면 증가
					if(comp[nx][ny]=='1') {
						val += 1;
					}
					checked[nx][ny] = true;
					q.offer(new int[] {nx,ny,val});
				}
			}
		}
	}
}