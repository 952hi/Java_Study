import java.io.*;
public class boj15652 {
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
	static int n,m,input[],res[],cnt=0;
	static boolean check[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Reader in = new Reader();
		n = in.nextInt();
		m = in.nextInt();
		input = new int[n];
		res = new int[m];
		check = new boolean[n];
		for(int i=0;i<n;i++) input[i] = i+1;
		perm(0);
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void perm(int idx) {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				sb.append(res[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[i] && i!=n-1) continue;
			res[idx] = input[i];
			if(i==n-1 && cnt<n) check[cnt++] = true;
			perm(idx+1);
			
		}
	}
}