import java.io.*;
import java.util.*;
public class boj1755{
	public static void main(String[] args) throws IOException {
		// 빠른 입출력을 위한 버퍼드리더와 라이터 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 여러번 출력하기보다 한번에 출력하기 위해 스트링빌더 선언
		StringBuilder sb = new StringBuilder();
		// 입력값이 스페이스바 간격이 존재하므로 잘라서 입력받기위한 스트링토크나이저 선언
		StringTokenizer stz = new StringTokenizer(br.readLine());
		
		// 시작값과 끝값 입력받기
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		
		// 숫자에 따라 영문자로 변경해줄 배열 선언
		String[] comp = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		// 숫자와 영문자 모두 가지고 있기위한 객체 배열 선언
		// digit 숫자 alpha 영문자
		Data[] temp = new Data[m-n+1];
		
		// 배열의 인덱스를 처리하는 idx변수
		int idx = 0;
		// 영문자로 변환할때의 check변수
		String check;
		
		// 시작값부터 끝값까지 반복문
		for(int i=n;i<=m;i++) {
			// 10으로 나눴을때 0이라는 말은 한자리수라는 뜻
			if(i/10==0) {
				// 한자리 수 라면 바로 영문자로 변환
				check = comp[i];
			}else {
				// 두자리 수라면 두 영문자 사이 스페이스바 삽입
				check = comp[i/10]+" "+comp[i%10];
			}
			// 배열에 생성한 영문자와 i를 넣어줌 i는 숫자
			temp[idx++] = new Data(i, check); 
		}
		
		// 영문자를 사전순으로 변경을 위한 정렬
		Arrays.sort(temp);
		
		// 10번째 수마다 줄바꿈을 해주기 위한 line 변수
		int line = 0;
		
		// 0부터 idx까지 반복문 
		for(int i=0;i<idx;i++) {
			// 줄바꿈확인을위해 1증가
			line++;
			// 정렬된 temp배열의 숫자를 스트링빌더에 넣어줌
			sb.append(temp[i].digit).append(" ");
			// 10이라면 줄을 바꿔주어야 하기에 조건문으로 확인
			if(line==10) {
				// 마지막 뛰어쓰기 삭제
				sb.setLength(sb.length()-1);
				// 줄바꿈
				sb.append("\n");
				// 줄바꿈 확인변수 초기화
				line = 0;
			}
		}
		// 만약 출력해야할수가 10의 배수라면 마지막 개행문자 삭제
		if(idx%10==0) sb.setLength(sb.length()-1);
		
		//출력
		bw.write(sb.toString());
		bw.flush();
	}
	
	// 숫자와 영문자를 같이 사용하기위한 객체
	// 영문자의 정렬을 하기위해 Comparable 인터페이스 상속
	static class Data implements Comparable<Data>{
		// 숫자
		int digit;
		// 영문자
		String alpha;
		
		// 생성자 선언
		public Data(int digit, String alpha) {
			super();
			this.digit = digit;
			this.alpha = alpha;
		}
		//영문자의 사전순 비교를 위한 메소드 재정의
		@Override
		public int compareTo(Data o) {
			return this.alpha.compareTo(o.alpha);
		}
	}
}