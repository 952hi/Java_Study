// 	tsi03136과 dpsel57의 페어프로그래밍의 결과물입니다. 
import java.io.*;
import java.util.*;
public class boj1948 {
	static int start,end,n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] list = new ArrayList[n+1];
		ArrayList<Integer>[] dest = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			list[i] = new ArrayList<>();
			dest[i] = new ArrayList<>();
		}
		
		int[] nodeMaxvalue = new int[n+1];
		int indegree[] = new int[n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stz.nextToken());
			int to = Integer.parseInt(stz.nextToken());
			int wei = Integer.parseInt(stz.nextToken());
			list[from].add(new int[] {to,wei});  // list 0  to  1 wei
			indegree[to]++;
		}
		StringTokenizer stz = new StringTokenizer(br.readLine());
		start = Integer.parseInt(stz.nextToken());
		end = Integer.parseInt(stz.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			int size = list[temp].size();
			for(int i=0;i<size;i++) {
				int to = list[temp].get(i)[0];
				int wei = list[temp].get(i)[1];
				indegree[to]--;
				
				if(nodeMaxvalue[to] < nodeMaxvalue[temp]+wei) {
					dest[to].clear();
					nodeMaxvalue[to] = nodeMaxvalue[temp]+wei;
					dest[to].add(temp);
				}else if(nodeMaxvalue[to] == nodeMaxvalue[temp]+wei) {
					dest[to].add(temp);
				}
				
				if(indegree[to]==0) q.offer(to);
				
			}
		}
		int res = 0;
		int size = dest[end].size();
		for(int i=0;i<size;i++) {
			q.offer(dest[end].get(i));
			res++;
		}
		
		boolean visited[] = new boolean[n+1];
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			int listsize = dest[temp].size();
			
			for(int i=0;i<listsize;i++) {
				res ++;
				int idx =dest[temp].get(i);
				if(idx!=start && !visited[idx]) {
					visited[idx] = true;
					q.offer(idx);
				}
			}
		}
		sb.append(nodeMaxvalue[end]).append("\n").append(res);
		
		bw.write(sb.toString());
		bw.flush();
	}
}
