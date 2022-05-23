import java.io.*;
import java.util.*;
public class boj11650 {
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
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = in.nextInt();
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->(o1[0]==o2[0])?o1[1]-o2[1]:o1[0]-o2[0]);
		for(int i=0;i<n;i++) q.offer(new int[] {in.nextInt(),in.nextInt()});
		int temp[];
		for(int i=0;i<n;i++) {
			temp = q.poll();
			sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
