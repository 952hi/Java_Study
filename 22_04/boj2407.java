import java.io.*;
public class boj2407 {
	static class Reader {
		int bfs = 1 << 16;
		byte[] buffer = new byte[bfs];
		int bufferLeft = 0, bufferState = 0;
		DataInputStream dis = new DataInputStream(System.in);

		byte read() {
			if (bufferLeft == bufferState) {
				try {
					bufferState = dis.read(buffer, bufferLeft = 0, bfs);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (bufferState == -1)
					buffer[0] = -1;
			}
			return buffer[bufferLeft++];
		}

		int nextInt() {
			int n = 0;
			byte b = read();
			while (b <= ' ')
				b = read();
			boolean neg = (b == '-');
			if (neg)
				b = read();
			do
				n = n * 10 + b - '0';
			while ('0' <= (b = read()) && b <= '9');
			if (neg)
				return -n;
			return n;
		}
	}
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int m = in.nextInt();
		if(n==m) System.out.println(1);
//		else {
//			for(int i=n,k=m;i>n-m;i--,k--) {
//				
//			}
//		}
	}
}