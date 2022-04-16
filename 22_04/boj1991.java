import java.io.*;
import java.util.StringTokenizer;
public class boj1991 {
	static int n,alpha[]=new int[26];
	static char tree[]=new char[100000];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<100000;i++) tree[i] ='.';
		for(int i=1;i<26;i++) alpha[i] = -1;
		char root,left,right;
		int idx;
		
		for(int i=0;i<n;i++) {
			stz = new StringTokenizer(br.readLine()," ");
			root = stz.nextToken().charAt(0);
			left = stz.nextToken().charAt(0);
			right = stz.nextToken().charAt(0);
			idx = alpha[root-65];
			tree[idx] = root;
			
			if(left!='.') {
				alpha[left-65]=idx*2+1;
				tree[idx*2+1] = left;
			}
			if(right!='.') {
				alpha[right-65]=idx*2+2;
				tree[idx*2+2] = right;
			}
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void postorder(int idx) {
		if(tree[idx]=='.') return;
		if(idx*2+1<100000)postorder(idx*2+1);
		if(idx*2+2<100000)postorder(idx*2+2);
		sb.append(tree[idx]);
	}
	private static void inorder(int idx) {
		if(tree[idx]=='.') return;
		if(idx*2+1<100000)inorder(idx*2+1);
		sb.append(tree[idx]);
		if(idx*2+2<100000)inorder(idx*2+2);
	}
	private static void preorder(int idx) {
		if(tree[idx]=='.') return;
		sb.append(tree[idx]);
		if(idx*2+1<100000)preorder(idx*2+1);
		if(idx*2+2<100000)preorder(idx*2+2);
	}
}
