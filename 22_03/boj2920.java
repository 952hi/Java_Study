import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int comp = Integer.parseInt(stz.nextToken());
		int temp = 0;
		boolean checkup=false,checkdn=false;
		if(comp == 1) {
			for(int i=1;i<8;i++) {
				temp = Integer.parseInt(stz.nextToken());
				if(comp+1 == temp) {
					comp = temp;
					if(i==7) System.out.println("ascending");
				}else {
					checkup = true;
					break;
				}
			}
			
		}else if(comp == 8) {
			for(int i=1;i<8;i++) {
				temp = Integer.parseInt(stz.nextToken());
				if(comp-1 == temp) {
					comp = temp;
					if(i==7) {
						System.out.println("descending");
					}
				}else {
					checkdn = true;
					break;
				}
			}
		}else {
			System.out.println("mixed");
		}
		if(checkup || checkdn) {
			System.out.println("mixed");

		}
	}
}
