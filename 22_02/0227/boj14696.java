import java.io.*;
import java.util.StringTokenizer;
public class boj14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stz;
		int n = Integer.parseInt(br.readLine());
		for(int t=0;t<n;t++) {
			int playA[] = new int[5];
			int playB[] = new int[5];
			stz = new StringTokenizer(br.readLine()," ");
			int size = Integer.parseInt(stz.nextToken());
			for(int i=0;i<size;i++) playA[Integer.parseInt(stz.nextToken())] +=1;
			stz = new StringTokenizer(br.readLine()," ");
			size = Integer.parseInt(stz.nextToken());
			for(int i=0;i<size;i++) playB[Integer.parseInt(stz.nextToken())] +=1;
			if(playA[4]>playB[4]) sb.append("A").append("\n");
			else if(playA[4]<playB[4]) sb.append("B").append("\n");
			else {
				if(playA[3]>playB[3]) sb.append("A").append("\n");
				else if(playA[3]<playB[3]) sb.append("B").append("\n");
				else {
					if(playA[2]>playB[2]) sb.append("A").append("\n");
					else if(playA[2]<playB[2]) sb.append("B").append("\n");
					else {
						if(playA[1]>playB[1]) sb.append("A").append("\n");
						else if(playA[1]<playB[1]) sb.append("B").append("\n");
						else {
							sb.append("D").append("\n");
						}
					}
				}
			}
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
}