import java.io.*;
public class JO_beginner_1341 {
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
		int s = in.nextInt();
		int e = in.nextInt();
		boolean chk = false;
		
		if(s>e) {
			chk = true;
		}
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(chk) {
			for(int i=s;i>=e;i--) {
				for(int k=1;k<=9;k++) {
					sb.append(i).append(" * ").append(k).append(" = ");
					if(i*k<10) sb.append(" ").append(i*k);
					else sb.append(i*k);
					if(k%3==0) sb.append("\n");
					else sb.append("   ");
				}
				sb.append("\n");
			}
		}else {
			for(int i=s;i<=e;i++) {
				for(int k=1;k<=9;k++) {
					sb.append(i).append(" * ").append(k).append(" = ");
					if(i*k<10) sb.append(" ").append(i*k);
					else sb.append(i*k);
					if(k%3==0) sb.append("\n");
					else sb.append("   ");
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
