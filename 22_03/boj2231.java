import java.io.*;

public class boj2231 {
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		res = 0;
		boolean check = false;
		for (int i = 1; i <= m; i++) {
			hap(i, new int[7], 6);
			if (res + i == m) {
				System.out.println(i);
				check = true;
				break;
			}
		}
		if (!check)
			System.out.println(0);
	}

	private static void hap(int i, int[] temp, int idx) {
		if (idx < 0) {
			int sum = 0;
			for (int k = 0; k < 7; k++)
				sum += temp[k];
			res = sum;
			return;
		}
		temp[idx] = i % 10;
		int re = i / 10;
		if (re > 0) {
			hap(re, temp, idx - 1);
		} else {
			int sum = 0;
			for (int k = 0; k < 7; k++) {
				sum += temp[k];
			}
			res = sum;
			return;
		}
	}
}