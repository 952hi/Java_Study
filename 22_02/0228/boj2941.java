import java.io.*;
public class boj2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String comp = br.readLine();
		int cnt=0;
		for(int i=0,size=comp.length();i<size;i++) {
			if(comp.charAt(i)=='c') {
				if(comp.charAt(i+1)=='-') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				else if(comp.charAt(i+1)=='=') {
					cnt+=1; 
					i+=1;
					if(i>=size) break;
					continue;
				}
				cnt++;
				continue;
			}else if(comp.charAt(i)=='d') {
				if(comp.charAt(i+1)=='-') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				else if(comp.charAt(i+1)=='z') {
					if(comp.charAt(i+2)=='=') {
						cnt+=1;
						i+=2;
						if(i>=size) break;
						continue;
					}
				}
				cnt++;
				continue;
			}else if(comp.charAt(i)=='l') {
				if(comp.charAt(i+1)=='j') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				cnt++;
				continue;
			}else if(comp.charAt(i)=='n') {
				if(comp.charAt(i+1)=='j') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				cnt++;
				continue;
			}else if(comp.charAt(i)=='s') {
				if(comp.charAt(i+1)=='=') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				cnt++;
				continue;
			}else if(comp.charAt(i)=='z') {
				if(comp.charAt(i+1)=='=') {
					cnt+=1;
					i+=1;
					if(i>=size) break;
					continue;
				}
				cnt++;
				continue;
			}
			if(comp.charAt(i)!='=' || comp.charAt(i)!='-')	cnt++;
		}
		System.out.println(cnt);
	}
}