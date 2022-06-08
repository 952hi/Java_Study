import java.io.*;
public class JO_beginner_1291 {
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
		int s,e;
		while(true) {
			s = in.nextInt();
			e = in.nextInt();
			if(2>s || s>9 || e<2 || e>9) {
				System.out.println("INPUT ERROR!");
				continue;
			}else break;
		}
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int start,end;
		boolean chk = false;
		if(s>e) {
			start = s;
			end = e;
			chk = true;
		}else {
			start = s;
			end = e;
		}
		System.out.println(start);
		System.out.println(end);
		for(int i=1;i<=9;i++) {
			if(chk) {
				for(int k=start;k>=end;k--) {
					sb.append(k).append(" * ").append(i).append(" = ");
					if(k*i<10) {
						sb.append(" ").append(k*i);
					}else sb.append(k*i);
					sb.append("   ");
				}
			}else {
				for(int k=start;k<=end;k++) {
					sb.append(k).append(" * ").append(i).append(" = ");
					if(k*i<10) {
						sb.append(" ").append(k*i);
					}else sb.append(k*i);
					sb.append("   ");
				}
			}
			sb.setLength(sb.length()-3);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}
