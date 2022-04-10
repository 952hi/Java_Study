import java.io.*;
import java.util.*;
public class boj9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Character> st = new Stack<>();
		for(int k=0;k<n;k++) {
			String temp = br.readLine();
			int size = temp.length();
			boolean check = false;
			for(int i=0;i<size;i++) {
				if(temp.charAt(i)=='(') {
					st.add('(');
				}else if(temp.charAt(i)==')') {
					if(st.isEmpty()) {
						check = true;
						break;
					}else {
						st.pop();
					}
				}
			}
			if(check) sb.append("NO").append("\n");
			else {
				if(st.isEmpty()) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
			st.clear();
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}