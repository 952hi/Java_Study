import java.io.*;
import java.util.*;
public class SWEA1249 {
	static int n,map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			String temp;
			for(int i=0;i<n;i++) {
				temp = br.readLine();
				for(int j=0;j<n;j++) {
					if(temp.charAt(j)!='0') {
						map[i][j]=temp.charAt(j)-'0';
					}
				}
			}
			sb.append("#").append(t).append(" ");
			bfs();
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
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
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		q.offer(new Data(0, 0));
		int temp[][] = new int[n][n];
		boolean check[][] = new boolean [n][n];
		
		Data comp;
		int nx,ny;
		while(!q.isEmpty()) {
			comp = q.poll();
			for(int i=0;i<4;i++) {
				nx = comp.x + dxdy[0][i];
				ny = comp.y + dxdy[1][i];
				if(0<=nx && nx<n && 0<= ny && ny<n) {
					if(!check[nx][ny]) {
						check[nx][ny] = true;
						temp[nx][ny] = temp[comp.x][comp.y]+map[nx][ny];
						q.offer(new Data(nx, ny));
					}else {
						if(temp[nx][ny]>map[nx][ny]+temp[comp.x][comp.y]) {
							temp[nx][ny] = temp[comp.x][comp.y]+map[nx][ny];
							q.offer(new Data(nx, ny));
						}
					}
				}
			}
		}
		sb.append(temp[n-1][n-1]).append("\n");
	}
}