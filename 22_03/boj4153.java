import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj4153 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		
		while(true){
			stz = new StringTokenizer(br.readLine()," ");
			int comp[] = {Integer.parseInt(stz.nextToken()),Integer.parseInt(stz.nextToken()),Integer.parseInt(stz.nextToken())};
			
			int cnt=0;
			for(int i=0;i<3;i++) {
				if(comp[i]==0) cnt++;
			}
			
			if(cnt == 3) break;
			
			Arrays.sort(comp);
			
			int obj;
			int height;
			obj = (int)Math.sqrt(Math.pow(comp[2], 2));
			height = (int)Math.sqrt(Math.pow(comp[0], 2)+Math.pow(comp[1], 2));
			
			if(obj == height) sb.append("right").append("\n");
			else sb.append("wrong").append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}