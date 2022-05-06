import java.io.*;
import java.util.*;
public class boj17478 {
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
	static int n;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = in.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		dfs(0,"");
		bw.write(sb.toString());
		bw.flush();
	}
	private static void dfs(int idx,String temp) {
		if(idx==n) {
			sb.append(temp).append("\"재귀함수가 뭔가요?\"").append("\n");
			sb.append(temp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
			sb.append(temp).append("라고 답변하였지.").append("\n");
			return;
		}
		sb.append(temp).append("\"재귀함수가 뭔가요?\"").append("\n");
		sb.append(temp).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
		sb.append(temp).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
		sb.append(temp).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
		dfs(idx+1,temp+"____");
		sb.append(temp).append("라고 답변하였지.").append("\n");
	}
}
