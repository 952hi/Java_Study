import java.io.*;
public class boj1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			char temp[] = br.readLine().toCharArray();
			int size = temp.length;
			if(size == 1 && temp[0]=='0') break;
			boolean check =false ;
			for(int i=0;i<size/2;i++) {
				if(temp[i] != temp[size-1-i]) {
					System.out.println("no");
					check = true;
					break;
				}
			}
			if(!check) System.out.println("yes");
		}
	}
}