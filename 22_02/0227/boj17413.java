import java.io.*;
import java.util.Stack;
public class boj17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String temp = br.readLine();
		int idx = 0;
		int size = temp.length();
		boolean check = false;
		Stack<Character> st = new Stack<>();
		while(idx<size) {
			if(check && temp.charAt(idx)!='>' ) {
				if(temp.charAt(idx)==' ') {
					sb.append(" ");
					idx+=1;
					continue;
				}
				else {
					sb.append(temp.charAt(idx++));
					continue;
				}
			}
			if(temp.charAt(idx)=='<') {
				if(!st.isEmpty()) {
					for(int i=0,stsize=st.size();i<stsize;i++) {
						sb.append(st.pop());
					}
				}
				check = true;
				sb.append("<");
				idx+=1;
				continue;
			}else if(temp.charAt(idx)=='>') {
				check = false;
				sb.append(">");
				idx+=1;
				continue;
			}else if(temp.charAt(idx)==' ') {
				for(int i=0,stsize=st.size();i<stsize;i++) {
					sb.append(st.pop());
				}
				sb.append(" ");
				idx++;
				continue;
			}else {
				st.push(temp.charAt(idx));
				idx++;
			}
		}
		if(!st.isEmpty()) {
			for(int i=0,stsize=st.size();i<stsize;i++) {
				sb.append(st.pop());
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}