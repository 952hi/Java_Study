import java.io.*;
import java.util.Arrays;
public class boj11404 {
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
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		int max = 1<<29;
		int map[][] = new int[n][n];
		for(int i=0;i<n;i++) Arrays.fill(map[i],max);
		int s,e;
		for(int i=0;i<m;i++) {
			s = in.nextInt()-1;
			e = in.nextInt()-1;
			map[s][e] = Math.min(in.nextInt(), map[s][e]);
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				if(k==i) continue;
				for(int j=0;j<n;j++) {
					if(i==j||j==k) continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1<<29) sb.append("0").append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}