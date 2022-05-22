import java.io.*;
import java.util.*;

public class boj16946 {
	static int row, col, map[][], cnt;
	static int[][] dxdy = { { 0, 0, 1, -1 }, { 1, -1, 0, 0 } };
	static HashMap<Integer, Integer> valuemap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		row = Integer.parseInt(stz.nextToken());
		col = Integer.parseInt(stz.nextToken());
		map = new int[row][col];
		String comp;
		for (int i = 0; i < row; i++) {
			comp = br.readLine();
			for (int j = 0; j < col; j++) {
				if (comp.charAt(j) == '0')
					continue;
				map[i][j] = -1;
			}
		}
		int group = 1;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0) {
					cnt = 1;
					map[i][j] = group;
					dfs(i, j, group);
					valuemap.put(group++, cnt);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == -1) {
					sb.append(sum(i, j, group));
				} else
					sb.append(0);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int sum(int x, int y, int digit) {
		boolean[] check = new boolean[digit];
		int res = 1, nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dxdy[0][i];
			ny = y + dxdy[1][i];
			if (0 <= nx && nx < row && 0 <= ny && ny < col && map[nx][ny] != -1 && !check[map[nx][ny]]) {
				check[map[nx][ny]] = true;
				res += valuemap.get(map[nx][ny]);
			}
		}
		return res % 10;
	}

	private static void dfs(int x, int y, int val) {
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dxdy[0][i];
			ny = y + dxdy[1][i];
			if (0 <= nx && nx < row && 0 <= ny && ny < col && map[nx][ny] == 0) {
				cnt++;
				map[nx][ny] = val;
				dfs(nx, ny, val);
			}
		}
	}
}