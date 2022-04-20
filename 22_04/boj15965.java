import java.io.*;
public class boj15965 {
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
	static boolean prime[]=new boolean[8000001];
	public static void main(String[] args) {
		Reader in = new Reader();
		int n = in.nextInt();
		checkprime();
		int idx = 2;
		int cnt = 0;
		while(true) {
			if(!prime[idx]) {
				if(++cnt==n) {
					System.out.println(idx);
					break;
				}
			}
			idx++;
		}
	}
	private static void checkprime() {
		int leng = prime.length;
		int sqrt = (int)Math.sqrt(leng);
		for(int i=2;i<=sqrt;i++) {
			if(prime[i]) continue;// 소수가아니면패스
			for(int j=i*i;j<leng;j=j+i) {
				prime[j] = true; // 소수면 소수의 배수는 소수가아니기에 트루로 변경
			}
		}
	}
}