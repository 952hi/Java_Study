import java.io.*;
public class boj1978 {
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
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		int comp = 0;
		int cnt = 0;
		for(int i=0;i<n;i++) {
			comp= in.nextInt();
			if(checkprime(comp)) cnt++;
		}
		System.out.println(cnt);
	}
	private static boolean checkprime(int comp) {
		if(comp==1) return false;
		boolean check = true;
		for(int i=2;i<=(int)Math.sqrt(comp);i++) {
			if(comp%i==0) {
				check = false;
				break;
			}
		}
		return check;
	}
}