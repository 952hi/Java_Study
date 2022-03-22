import java.io.*;
import java.util.*;
public class boj10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> q = new Stack<>();
		int comp = 0;
		for(int i=0;i<n;i++) {
			comp = Integer.parseInt(br.readLine());
			if(comp == 0) {
				if(q.isEmpty()) continue;
				else q.pop();
			}else {
				q.add(comp);
			}
		}
		int sum = 0;
		while(!q.isEmpty()) {
			sum += q.pop();
		}
		System.out.println(sum);
	}
}
