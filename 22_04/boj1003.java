import java.io.*;
public class boj1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		int[] zero = new int[41];
		int[] one = new int[41];
		zero[0] = 1;
		one[0] = 0;
		zero[1] = 0;
		one[1] = 1;
		for(int i=2;i<=40;i++) {
			zero[i] = zero[i-1]+zero[i-2];
			one[i] = one[i-1]+one[i-2];
		}
		for(int t=0;t<tc;t++) {
			int a=Integer.parseInt(br.readLine());
			sb.append(zero[a]).append(" ").append(one[a]).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}