import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class boj11866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(stz.nextToken());
		int K = Integer.parseInt(stz.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++) {
			list.add(i+1);
		}
		int cnt = 1;
		sb.append("<");
		while(!list.isEmpty()) {
			for(int i=0;i<list.size();i++,cnt++) {
				if(cnt==K) {
					sb.append(list.get(i)).append(",").append(" ");
					list.remove(i--);
					cnt=0;
				}
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}