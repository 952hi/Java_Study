import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
public class boj11279 {
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
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1);
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = in.nextInt();
		for(int i=0;i<n;i++) {
			int comp = in.nextInt();
			if(comp==0) {
				if(q.isEmpty()) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}else q.offer(comp);
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}

}
