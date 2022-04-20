import java.io.*;
public class boj1520 {
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
	static int row,col,map[][][];
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	public static void main(String[] args) {
		Reader in = new Reader();
		row = in.nextInt();
		col = in.nextInt();
		map = new int[row][col][2];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j][0] = in.nextInt();
			}
		}
		dfs(0,0);
		
	}
	
	private static int dfs(int x, int y) {
		if(map[x][y][1]!=0) {
			return map[x][y][1];
		}
		int nx,ny;
		for(int i=0;i<4;i++) {
			nx = dxdy[0][i] + x;
			ny = dxdy[1][i] + y;
			if(0<= nx && nx<row && 0<= ny && ny<col && map[x][y][0]>map[nx][ny][0]) {
				map[nx][ny][1] += 1;
				map[x][y][1] = dfs(nx,ny);
			}
		}
		return 0;
	}
}