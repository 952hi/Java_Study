import java.io.*;
public class boj9205 {
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
	static int temp[][],n;
	static boolean visited[],check;
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = in.nextInt();
		for(int t=0;t<tc;t++) {
			n = in.nextInt();
			temp = new int[n+2][2];
			visited = new boolean[n+2];
			check = false;
			for(int i=0;i<n+2;i++) {
				temp[i][0] = in.nextInt();
				temp[i][1] = in.nextInt();
			}
			int distance = Math.abs(temp[0][0]-temp[n+1][0])+Math.abs(temp[0][1]-temp[n+1][1]);
			if(distance<=1000) {
				sb.append("happy").append("\n");
			}
			else {
				visited[0] = true;
				dfs(0);
				if(check) sb.append("happy").append("\n");
				else sb.append("sad").append("\n");
			}
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int idx) {
		if(idx == n+1) {
			check = true;
			return;
		}
		if(check) return;
		
		for(int i=1;i<n+2;i++) {
			int dist = Math.abs(temp[idx][0]-temp[i][0])+Math.abs(temp[idx][1]-temp[i][1]);
			if(!visited[i] && dist<=1000 &&!check) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
}