import java.io.*;
import java.util.*;
public class boj2491 {
	public static void main(String[] args) {
		Reader in = new Reader();
		int N = in.nextInt();
		int comp[] = new int[N];
		for(int i=0;i<N;i++) comp[i]=in.nextInt();
		int max = 1;
		int res[] = new int[N];
		int minus[] = new int[N];
		res[0]=1;
		minus[0]=1;
		for(int i=1;i<N;i++) {
			res[i]=1;
			minus[i]=1;
			if(comp[i]>comp[i-1]) {
				res[i]=Math.max(res[i-1]+1, res[i]);
				if(res[i]>max) max = res[i];
			}else if(comp[i]<comp[i-1]){
				minus[i]=Math.max(minus[i-1]+1, minus[i]);
				if(minus[i]>max) max = minus[i];
			}else {
				res[i]=res[i-1]+1;
				minus[i]=minus[i-1]+1;
				if(res[i]>max) max = res[i];
				if(minus[i]>max) max = minus[i];
			}
		}
		System.out.println(max);
	}
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
}