import java.io.*;
import java.math.BigInteger;
public class boj2407 {
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
		int a = in.nextInt();
		int b = in.nextInt();
		BigInteger[][] dp = new BigInteger[a+1][a+1];
		for(int i=1;i<=a;i++){
            for(int j=0;j<=i;j++){
                if(j == 0 || j==i)
                    dp[i][j] = new BigInteger("1");
                else
                    dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
            }
        }
		System.out.println(dp[a][b]);
	}
}
