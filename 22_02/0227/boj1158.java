import java.io.*;
import java.util.*;
public class boj1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		List<Integer> list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stz.nextToken());
		int k = Integer.parseInt(stz.nextToken())-1;
		sb.append("<");
		for(int i=0;i<n;i++) list.add(i+1);
		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx+k)%list.size();;
			sb.append(list.get(idx)).append(",").append(" ");
			list.remove(idx);
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}