import java.io.*;
public class boj1934 {
	// 유클리드 호제
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
		
		int tc = in.nextInt();
		for(int i=0;i<tc;i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int res =check(a,b);
			sb.append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static int check(int a, int b) {
		int res=0;
		int mod=0;
		if(a==1||b==1) return a*b;
		if(a>b) {
			mod =mod(a,b);
			res = (a/mod)*(b/mod)*mod; 
		}else if(a<b) {
			mod =mod(b,a);
			res = (a/mod)*(b/mod)*mod; 
		}else {
			res =a;
		}
		return res;
	}
	private static int mod(int a, int b) {
		int res = 0;
		int temp=0;
		while(b!=0) {
			temp=a%b;
			a = b;
			b = temp;
		}
		if(a==0) res=b;
		else if(b==0) res=a;
			
		return res;
	}
}