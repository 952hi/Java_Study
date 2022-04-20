import java.io.*;
public class boj1629 {
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
	static long mod;
	public static void main(String[] args) {
		Reader in = new Reader();
		long a=in.nextInt(),b=in.nextInt();
		mod=in.nextInt();
		System.out.println(power(a,b));
	}
	private static long power(long x,long y) {
        long res = 1L;
        x = x%mod;
        while(y> 0) {
            if(y%2==1) {
                res = (res*x) % mod;
            }
            y = y>>1;
            x = (x*x) % mod;
        }
        return res;
    }
}
