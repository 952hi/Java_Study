import java.io.*;
import java.util.*;
public class SWEA1767 {
	static int n,map[][],cnt,res,max;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=tc;t++) {
			cnt = 0;
			res = Integer.MAX_VALUE;
			max = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			list = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				StringTokenizer stz = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					map[i][j]= Integer.parseInt(stz.nextToken());
					if(map[i][j]==1) {
						if(i==0 || j==0 || i==n-1 || j==n-1) continue;
						list.add(new int[] {i,j});
						cnt ++;
					}
				}
			}
			sub(0,0);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	static int[][] dxdy= {{0,0,1,-1},{1,-1,0,0}};
	private static void sub(int idx, int pcnt) {
		if(idx==cnt) {
			int check =getlength();
			if(pcnt>max) {
				max = pcnt;
				res = check;
			}else if(pcnt==max) {
				if(res>getlength()) {
					res = check;
				}
			}
			
			return;
		}
		
		int[] core= list.get(idx);
		for(int i=0;i<4;i++) {
			if(isAvaillable(core[0],core[1],i)) {
				setStatus(core[0],core[1],i,2);
				sub(idx+1,pcnt+1);
				setStatus(core[0], core[1], i, 0);
			}
		}
		
		sub(idx+1, pcnt);
	}
	private static int getlength() {
		int length = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==2) length+=1;
			}
		}
		return length;
	}
	
	private static void setStatus(int x, int y, int d, int s) {
		int nx=x,ny=y;
		while(true) {
			nx += dxdy[0][d];
			ny += dxdy[1][d];
			if(nx<0 || nx>=n || ny>= n || 0>ny)break;
			map[nx][ny]=s;
		}
	}
	
	private static boolean isAvaillable(int x, int y, int d) {
		int nx=x,ny=y;
		while(true) {
			nx += dxdy[0][d];
			ny += dxdy[1][d];
			if(nx<0 || nx>=n || ny>= n || 0>ny)break;
			if(map[nx][ny]==2 || map[nx][ny]==1) return false;
		}
		return true;
	}
	
}