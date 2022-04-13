import java.io.*;
import java.util.Arrays;

public class Main {
	static int map[][][],row,col,n,max,temp[][][];
	static Shark shark[];
	static int[][] dxdy = { { -1,1,0,0}, { 0,0,1,-1 } };
	static class Reader {
        int bfs = 1 << 16;
        byte[] buffer = new byte[bfs];
        int bufferPos = 0, bufferState = 0;
        DataInputStream dis = new DataInputStream(System.in);
        byte read() {
            if (bufferPos == bufferState) {
                try {
                    bufferState = dis.read(buffer, bufferPos = 0, bfs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bufferState == -1)
                    buffer[0] = -1;
            }
            return buffer[bufferPos++];
        }
        int nextInt() {
            int rtn = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
                rtn = rtn * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -rtn;
            return rtn;
        }
    }
	static class Shark{
		int x;
		int y;
		int speed;
		int dir;
		int size;
		public Shark(int x, int y, int speed, int dir, int size) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}
		
	}
	public static void main(String[] args) {
		Reader in = new Reader();
		row = in.nextInt();
		col = in.nextInt();
		n = in.nextInt();
		map = new int[row][col][2];
		shark = new Shark[n+1];
		max = n;
		int x,y,s,d,z;
		for(int i=1;i<=n;i++) {
			x = in.nextInt()-1;
			y = in.nextInt()-1;
			s = in.nextInt();
			d = in.nextInt()-1;
			z = in.nextInt();
			shark[i] = new Shark(x, y, s, d, z);
			map[x][y][0] = i;
			map[x][y][1] = z;
		}
		int res =0;
		for(int i=0;i<col;i++) {
			if(max==0) break;
			int k=0;
			while(true) {
				if(k>=row) break;
				if(map[k][i][0]!=0) {
					res += shark[map[k][i][0]].size;
					shark[map[k][i][0]] = null;
					map[k][i][0] = 0;
					map[k][i][1] = 0;
					max --;
					break;
				}
				k++;
			}
			move();
		}
		System.out.println(res);
		
	}
	private static void move() {
		for(int i=1;i<=n;i++) {
			if(shark[i]==null) continue;
			if(shark[i].speed==0) continue;
			sharkmove(i);
		}
		copy(map, temp);
	}
	
	private static void sharkmove(int idx) {
		int x = shark[idx].x;
		int y = shark[idx].y;
		int dir = shark[idx].dir;
		int speed = shark[idx].speed;
		int mod = 0;
		int length = 0;
		temp = new int[row][col][2];
		if(temp[x][y][0]==idx) {
			temp[x][y][0]=0;
			temp[x][y][1]=1;
		}
		copy(temp,map);
		if(dir == 0 || dir == 1) {
			//상 하
			length = (row-2)*2+2;
			mod = speed%length;
			while(mod>0) {
				x = x+dxdy[0][dir];
				if(x<0 || x>=row) {
					x = x-dxdy[0][dir];
					if(dir==0) dir=1;
					else dir = 0;
				}else mod--;
			}
			shark[idx].x = x;
			shark[idx].dir=dir;
		}else if(dir == 2 || dir == 3) {
			// 우 좌
			length = (col-2)*2+2;
			mod = speed%length;
			while(mod>0) {
				y = y+dxdy[1][dir];
				if(y<0 || y>=col) {
					y = y-dxdy[1][dir];
					if(dir==2) dir=3;
					else dir = 2;
				}else mod--;
			}
			shark[idx].y = y;
			shark[idx].dir=dir;
		}
		if(temp[shark[idx].x][shark[idx].y][0] != 0) {
			if(temp[shark[idx].x][shark[idx].y][1] < shark[idx].size) {
				temp[shark[idx].x][shark[idx].y][0] = idx;
				temp[shark[idx].x][shark[idx].y][1] = shark[idx].size;
			}
		}else {
			temp[shark[idx].x][shark[idx].y][0] = idx;
			temp[shark[idx].x][shark[idx].y][1] = shark[idx].size;
		}
	}
	private static void copy(int[][][] temp2, int[][][] map2) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp2[i][j][0] = map2[i][j][0];
				temp2[i][j][1] = map2[i][j][1];
			}
		}
	}
}