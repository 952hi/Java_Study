import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class boj1916 {
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
		int m = in.nextInt();
		int s,e,val;
		ArrayList<int[]> adj[] = new ArrayList[n];
		for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
		for(int i=0;i<m;i++) {
			s = in.nextInt()-1;
			e = in.nextInt()-1;
			val = in.nextInt();
			adj[s].add(new int[] {e,val});
		}
		int sno=in.nextInt()-1;
		int eno=in.nextInt()-1;
		int distance[] = new int[n];
		Arrays.fill(distance, 1<<30);
		boolean visited[] = new boolean[n];
		PriorityQueue<int[]> q= new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
		q.offer(new int[] {0,sno});
		distance[sno] = 0;
		int temp[];
		int cnt=0;
		while(!q.isEmpty()) {
			temp = q.poll();
			int from = temp[1];
			if(visited[from] && adj[from]==null) continue;
			
			visited[from] = true;
			cnt++;
			if(cnt==n) break;
			int size = adj[from].size();
			for(int i=0;i<size;i++) {
				int to = adj[from].get(i)[0];
				if(visited[to]) continue;
				int dist = adj[from].get(i)[1];
				if(distance[to]>distance[from]+dist) {
					distance[to] = distance[from]+dist;
					q.offer(new int[] {distance[to],to});
				}
			}
		}
		System.out.println(distance[eno]);
	}
}