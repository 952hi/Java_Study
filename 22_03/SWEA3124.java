import java.io.*;
import java.util.*;
public class Solution {
	static class Node{
		int to;
		int wei;
		Node link;
		public Node(int to, int wei, Node link) {
			super();
			this.to = to;
			this.wei = wei;
			this.link = link;
		}
	}
	static class Data implements Comparable<Data>{
		int no;
		int wei;
		public Data(int no, int wei) {
			super();
			this.no = no;
			this.wei = wei;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.wei, o.wei);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer stz;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			stz = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(stz.nextToken());
			int m = Integer.parseInt(stz.nextToken());
			Node[] node = new Node[n+1];
			for(int i=0;i<m;i++) {
				stz = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(stz.nextToken());
				int to = Integer.parseInt(stz.nextToken());
				int wei = Integer.parseInt(stz.nextToken());
				node[from] = new Node(to, wei, node[from]);
				node[to] = new Node(from, wei, node[to]);
			}
			boolean[] v = new boolean[n+1];
			PriorityQueue<Data> q = new PriorityQueue<>();
			q.offer(new Data(1, 0));
			int cnt=0;
			long res=0;
			Data comp;
			while(!q.isEmpty()) {
				comp = q.poll();
				if(v[comp.no]) continue;
				
				v[comp.no] = true;
				res += comp.wei;
				cnt++;
				if(cnt==n) break;
				for(Node a = node[comp.no];a!=null;a=a.link) {
					if(!v[a.to]) q.offer(new Data(a.to, a.wei));
				}
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}