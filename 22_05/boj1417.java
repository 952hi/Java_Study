import java.io.*;
import java.util.Arrays;
public class boj1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] temp = br.readLine().toCharArray();
		Arrays.sort(temp);
		for(int i=0,size=temp.length;i<size;i++)  System.out.print(temp[size-i-1]);
	}
}
