import java.io.*;
import java.util.*;
public class boj2252 {
	static int n,m;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stz.nextToken());
		m = Integer.parseInt(stz.nextToken());
		list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) list[i] = new ArrayList<>();
		int[] inde = new int[n+1];
		int from,to;
		for(int i=0;i<m;i++) {
			stz = new StringTokenizer(br.readLine());
			from = Integer.parseInt(stz.nextToken());
			to = Integer.parseInt(stz.nextToken());
			list[from].add(to);
			inde[to] += 1; 
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			if(inde[i]==0) q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		if(q.size()==0) {
			// -> 사이클이 발생해서 더이상진행이 불가능할때
			System.out.println("불가능 ");
		}else {
			int cur = -1;
			while(!q.isEmpty()) {
				cur = q.poll();
				sb.append(cur).append(" ");
				
				for(int i=0;i<list[cur].size();i++) {
					int idx = list[cur].get(i);
					inde[idx] -=1;
					if(inde[idx]==0) q.offer(idx);
				}
			}
		}
		System.out.println(sb.toString());
	}
}