import java.io.*;
import java.util.PriorityQueue;

public class boj1181 {
	static class Data implements Comparable<Data>{
		String a;
		int len;
		public Data(String a, int len) {
			super();
			this.a = a;
			this.len = len;
		}
		@Override
		public int compareTo(Data o) {
			return this.len==o.len ? this.a.compareTo(o.a):this.len-o.len;
		}
		@Override
		public String toString() {
			return a;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		String temp;
		for(int i=0;i<n;i++) {
			temp = br.readLine();
			pq.offer(new Data(temp, temp.length()));
		}
		String comp = pq.poll().a;
		sb.append(comp).append("\n");
		for(int i=1;i<n;i++) {
			temp = pq.poll().a;
			if(comp.equals(temp)) {
				comp = temp;
				continue;
			}
			comp = temp;
			sb.append(temp).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}