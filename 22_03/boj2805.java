import java.io.*;
import java.util.*;
public class boj2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		long sum=0;
		long comp[] = new long[N];
		stz = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			comp[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(comp);
		long left=0,right=comp[N-1],mid=0;
		
		while(left<=right) {
			mid = (left+right)/2;
			sum = 0;
			for(int i=0;i<N;i++) {
				if(comp[i] > mid) sum += (comp[i] -mid);
			}
			
			if(sum >= M) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		System.out.println(right);
	}
}