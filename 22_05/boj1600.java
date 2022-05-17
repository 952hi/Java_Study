import java.io.*;
import java.util.*;

public class boj1600 {
	static class Reader {
		int bfs = 1 << 16;
		byte[] buffer = new byte[bfs];
		int bufferPos = 0, bufferState = 0;
		DataInputStream dis = new DataInputStream(System.in);

		byte read() {
			if (bufferPos == bufferState) {
				try {
					bufferState = dis.read(buffer, bufferPos = 0, bfs);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (bufferState == -1)
					buffer[0] = -1;
			}
			return buffer[bufferPos++];
		}

		int nextInt() {
			int rtn = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
				rtn = rtn * 10 + c - '0';
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -rtn;
			return rtn;
		}
	}
	static int row, col, k, map[][], cnt;
	public static void main(String[] args) {
		Reader in = new Reader();
		k = in.nextInt();
		col = in.nextInt();
		row = in.nextInt();
		cnt = -1;
		map = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(in.nextInt()==1) {
					map[i][j]=-1;
				}
			}
		}
		if(row==1 && col==1) System.out.println(0);
		else {
			bfs();
			System.out.println(cnt);
		}
	}

	static int[][] dxdy = { { 0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2 }, { 1, -1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1 } };

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0,0,0});//move,x,y,k;\
		boolean visited[][][] = new boolean[row][col][k+1];
		int nx,ny,comp[],val;
		while(!q.isEmpty()) {
			comp = q.poll();
			if(comp[1]==row-1 && comp[2]==col-1) {
				cnt = comp[0]; 
				return;
			}
			int i;
			if(comp[3]==k) i=3;
			else i=11;
			for(;i>=0;i--) {
				nx = comp[1] + dxdy[0][i];
				ny = comp[2] + dxdy[1][i];
				if(0<=nx && nx<row && 0<=ny && ny<col && map[nx][ny]!=-1 && k>=comp[3]) {
					val = comp[3];
					if(i>3) val+=1;
					if(val>k || visited[nx][ny][val]) continue;
					visited[nx][ny][val]=true;
					q.offer(new int[] {comp[0]+1,nx,ny,val});
				}
			}
		}
	}
}