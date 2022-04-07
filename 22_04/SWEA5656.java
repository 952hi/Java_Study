import java.io.*;
import java.util.*;
public class SWEA5656 {
	static int n,row,col,map[][],shot[],temp[][],res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tc= Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			StringTokenizer stz = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stz.nextToken());
			col = Integer.parseInt(stz.nextToken());
			row = Integer.parseInt(stz.nextToken());
			res = 12*15;
			map = new int[row][col];
			temp = new int[row][col];
			shot = new int[n];
			for(int i=0;i<row;i++) {
				stz = new StringTokenizer(br.readLine());
				for(int j=0;j<col;j++) {
					map[i][j]=Integer.parseInt(stz.nextToken());
				}
			}
			random(0,0);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		sb.setLength(sb.length()-1);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void random(int idx, int cnt) {
		if(cnt==n) {
			for(int i=0;i<row;i++) temp[i] = Arrays.copyOf(map[i],col);
			res = Math.min(res,block());
			return;
		}
		if(res==0) return;
		
		for(int i=0;i<col;i++) {
			shot[cnt] = i;
			random(idx+1,cnt+1);
		}
	}
	private static int block() {
		for(int i=0;i<n;i++) {
			int x= 0;
			while(true) {
				if(temp[x][shot[i]]==0) {
					x++;
				}else {
					crash(x,shot[i],temp[x][shot[i]]);
					down();
					break;
				}
				if(0> x || x >= row) break;
			}
		}
		return areacheck();
	}
	private static void down() {
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<col;j++) {
				if(temp[i][j]==0) {
					int dist =1;
					while(true) {
						if(i-dist<0) break;
						if(temp[i-dist][j]!=0) {
							temp[i][j]=temp[i-dist][j];
							temp[i-dist][j] = 0;
							break;
						}
						dist++;
					}
				}
			}
		}
	}
	private static int areacheck() {
		int digit=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(temp[i][j]!=0) digit++;
			}
		}
		return digit;
	}
	static int[][] dxdy = {{0,0,1,-1},{1,-1,0,0}};
	private static void crash(int x, int y, int power) {
		temp[x][y] = 0;
		if(temp[x][y]==1) {
			return;
		}
		int nx,ny,value;
		for(int i=0;i<4;i++) {
			for(int j=1;j<power;j++) {
				nx = x +dxdy[0][i]*j;
				ny = y +dxdy[1][i]*j;
				if(0<=nx && nx<row && 0<= ny && ny<col && temp[nx][ny]!=0) {
					value = temp[nx][ny];
					temp[nx][ny] = 0;
					crash(nx,ny,value);
				}
			}
		}
	}
}