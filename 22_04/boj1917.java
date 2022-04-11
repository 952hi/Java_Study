import java.io.*;
import java.util.*;
public class boj1917 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		int temp;
		for(int i=0;i<n;i++) {
			temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(q.isEmpty()) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else q.offer(temp);
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}