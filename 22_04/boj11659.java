import java.io.*;
import java.util.Arrays;
public class boj11659 {
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
		int m = in.nextInt();
		int temp[] = new int[n];
		int sum[] = new int[n+1];
		for(int i=0;i<n;i++) temp[i] = in.nextInt();
		sum[0] = temp[0];
		for(int i=1;i<n;i++) sum[i] = sum[i-1] + temp[i];
		int start,end;
		for(int i=0;i<m;i++) {
			start = in.nextInt()-1;
			end = in.nextInt()-1;
			if(start==end) sb.append(temp[start]).append("\n");
			else {
				if(start==0) {
					sb.append(sum[end]).append("\n");
				}else {
					sb.append(sum[end]-sum[start-1]).append("\n");
				}
			}
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}