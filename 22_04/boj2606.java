import java.io.*;
import java.util.*;
public class boj2606 {
	static int adj[][],n,m,res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		res =0;
		adj = new int[n+1][n+1];
		int to,from;
		for(int i=0;i<m;i++) {
			stz = new StringTokenizer(br.readLine());
			to = Integer.parseInt(stz.nextToken());
			from = Integer.parseInt(stz.nextToken());
			adj[to][from] = 1;
			adj[from][to] = 1;
		}
		bfs();
		System.out.println(res);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		boolean visited[] = new boolean[n+1];
		visited[1] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i=1;i<n+1;i++) {
				if(adj[temp][i]==1 && !visited[i]) {
					visited[i] =true;
					q.offer(i);
					res++;
				}
			}
		}
	}
}
