import java.io.*;
import java.util.*;

public class boj17143 {
	static int row,col,sharkcnt,humen,res,maxshark;
	static int[][] map;
	static int[][] dxdy = { { -1,1,0,0}, { 0,0,1,-1 } }; // 상 하 우 좌
	static Sharkinfo[] shark;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		row = Integer.parseInt(stz.nextToken());
		col = Integer.parseInt(stz.nextToken());
		sharkcnt = Integer.parseInt(stz.nextToken());
		map = new int[row][col]; // 속도 방향 크기
		shark = new Sharkinfo[sharkcnt];
		maxshark = sharkcnt;
		int idx = 0;
		humen = -1;
		res = 0;
		int x,y,s,d,z;
		for(int i=0;i<row;i++) Arrays.fill(map[i], -1);
		for(int i=0;i<sharkcnt;i++) {
			stz = new StringTokenizer(br.readLine());
			x = Integer.parseInt(stz.nextToken())-1;
			y = Integer.parseInt(stz.nextToken())-1;
			s = Integer.parseInt(stz.nextToken());
			d = Integer.parseInt(stz.nextToken())-1;
			z = Integer.parseInt(stz.nextToken());
			map[x][y] = idx;
			shark[idx++] = new Sharkinfo(x,y,s, d, z);
		}
		
		while(true) {
			if(!fishing()) {
				System.out.println(res);
				break;
			}
			moveShark();
		}
	}
	private static void moveShark() {
		for(int i=0;i<sharkcnt;i++) {
			if(shark[i]==null) continue;
            if(shark[i].speed==0) continue;
			move(shark[i].x,shark[i].y,i);
		}
		Sharkok();
	}
	private static void Sharkok() {
		for(int i=0;i<sharkcnt;i++) {
			if(shark[i]==null) continue;
            int x1 = shark[i].x;
            int y1 = shark[i].y;
			map[x1][y1] = i;
			for(int j=0;j<sharkcnt;j++) {
				if(i==j) continue;
				if(shark[j]==null||shark[i]==null) continue;
                int x2 = shark[j].x;
                int y2 = shark[j].y;
				if(x1 == x2 && y1 == y2) {
					if(shark[i].size>shark[j].size) {
						map[x2][y2]= -1;
						map[x1][y1]= i;
						shark[j] = null;
						maxshark--;
						continue;
					}else if(shark[j].size>shark[i].size) {
						map[x1][y1]= -1;
						map[y2][y2]= j;
						shark[i] = null;
						maxshark--;
						continue;
					}
				}
			}
		}
	}
	private static void move(int i, int j, int idx) {
		int nx = i;
		int ny = j;
		map[i][j]=-1;
		int mok = 0;
		int mod = 0;
		int length=0;
		int checkdir = shark[idx].dir;
		int checkspeed = shark[idx].speed;
		if(checkdir == 0 || checkdir == 1) {
			//상 하
			length = (row-2)*2+2;
			mod = checkspeed%length;
			while(mod>0) {
				nx = nx+dxdy[0][checkdir];
				if(nx<0 || nx>=row) {
					nx = nx-dxdy[0][checkdir];
					if(checkdir==0) checkdir=1;
					else checkdir = 0;
				}else mod--;
			}
			shark[idx].x = nx;
			shark[idx].dir=checkdir;
		}else if(checkdir == 2 || checkdir == 3) {
			// 우 좌
			length = (col-2)*2+2;
			mod = checkspeed%length;
			while(mod>0) {
				ny = ny+dxdy[1][checkdir];
				if(ny<0 || ny>=col) {
					ny = ny-dxdy[1][checkdir];
					if(checkdir==2) checkdir=3;
					else checkdir = 2;
				}else mod--;
			}
			shark[idx].y = ny;
			shark[idx].dir=checkdir;
		}
	}
	private static boolean fishing() {
		humen++;
		if(maxshark==0) return false;
		if(humen==col) return false;
		int i=0;
		while(i<row) {
			if(map[i][humen]!=-1) {
				res += shark[map[i][humen]].size;
				shark[map[i][humen]] = null;
				maxshark--;
				map[i][humen] = -1;
				break;
			}
			i++;
		}
		return true;
	}
	static class Sharkinfo{
		int x;
		int y;
		int speed;
		int dir;
		int size;
		public Sharkinfo(int x, int y, int speed, int dir, int size) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}