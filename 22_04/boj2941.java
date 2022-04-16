import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int size = temp.length();
		temp += "  ";
		int res = 0;
		for(int i=0;i<size;i++) {
			if(temp.charAt(i)=='=' || temp.charAt(i)=='-') continue;
			
			if(temp.charAt(i)=='c') {
				if(temp.charAt(i+1)=='=') {
					i++;
					res++;
					continue;
				}else if(temp.charAt(i+1)=='-') {
					i++;
					res++;
					continue;
				}
			}else if(temp.charAt(i)=='d') {
				if(temp.charAt(i+1)=='z') {
					if(temp.charAt(i+2)=='=') {
						i+=2;
						res++;
						continue;
					}
				}else if(temp.charAt(i+1)=='-') {
					i++;
					res++;
					continue;
				}
			}else if(temp.charAt(i)=='l' && temp.charAt(i+1)=='j'){
				i++;
				res++;
				continue;
			}else if(temp.charAt(i)=='n' && temp.charAt(i+1)=='j'){
				i++;
				res++;
				continue;
			}else if(temp.charAt(i)=='s' && temp.charAt(i+1)=='='){
				i++;
				res++;
				continue;
			}else if(temp.charAt(i)=='j' && temp.charAt(i+1)=='='){
				i++;
				res++;
				continue;
			}
			res++;
		}
		System.out.println(res);
	}
}