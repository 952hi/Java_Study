import java.io.*;
import java.util.*;
public class boj2623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[] list;
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		list = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) list[i] = new ArrayList<>();
		int indegree[] = new int[n+1];
		int from,to;
		for(int i=0;i<m;i++) {
			stz = new StringTokenizer(br.readLine());
			stz.nextToken();
			from = Integer.parseInt(stz.nextToken());
			to = Integer.parseInt(stz.nextToken());
			int k=1;
			while(true) {
				list[from].add(to);
				indegree[to] += k;
				from = to;
				if(!stz.hasMoreTokens()) break;
				to = Integer.parseInt(stz.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) q.offer(i);
		}
		boolean check = false;
		if(q.isEmpty()) {
			sb.append(0);
		}else {
			while(!q.isEmpty()) {
				int comp = q.poll();
				sb.append(comp).append("\n");
				
				int size = list[comp].size();
				for(int i=0;i<size;i++) {
					indegree[list[comp].get(i)]--;
					if(indegree[list[comp].get(i)]==0) q.offer(list[comp].get(i));
				}
			}
		}
		for(int i=1;i<n+1;i++) {
			if(indegree[i]!=0) {
				sb.setLength(0);
				sb.append(0);
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}