package sw03;

public class Main {

	public static void main(String[] args) {
		k42_P3();
	}
	public static void k42_P1() { //연산 후 대입
		int k42_n; //정수 변수 선언
		k42_n = 1 + 2; //첫번째로 출력해볼 값 입력
 		System.out.printf("# 1-1 : %d\n", k42_n); //printf로 출력 (%d <- n)
		
 		k42_n = 1 + 2 + 3; //두번째로 출력해볼 값 입력
		System.out.printf("# 1-2 : %d\n" , k42_n);
	}
	
	public static void k42_P2() { //누적하기
		int k42_sum; //값이 들어갈 정수 변수 sum
		
		k42_sum = 0; //초기값 대입
		
		for (int k42_i = 1; k42_i < 101; k42_i++) { //i는 1부터 100까지 (  i < 101 )
			k42_sum = k42_sum + k42_i; //반복문 안에서 누적하여 더하기
		}
		System.out.printf("#2 : %d\n" , k42_sum); //sum 그대로 출력
		System.out.printf("#2 - 2 : %d\n" , k42_sum/100); //sum의 평균값 출력
		
		int [] k42_v = {1, 2, 3, 4, 5}; //정수 배열 선언
		int k42_vSum; 
		
		k42_vSum = 0;
		
		for(int k42_i = 0; k42_i < 5; k42_i++) {
			k42_vSum = k42_vSum + k42_v[k42_i]; //배열의 합계 누적
		}
		System.out.printf("#2 - 3 : %d\n" , k42_vSum) ; //출력
	}
	
	public static void k42_P3() {
		//정수형 연산의 버림
		int k42_n = 1000 / 3; //정수형이므로 소수점 아래 값은 저장되지 않는다
		System.out.printf("#3 - 1 : %d\n", k42_n);
		//1000 / 3 = 333.333333.....이지만 정수 부분인 333만 출력됨을 확인할 수 있다
		
		k42_n = 1000 % 3; // % : 나머지 계산
		System.out.printf("#3 - 2 : %d\n", k42_n); //나머지 = 1
		
		for(int k42_i = 0; k42_i < 20; k42_i++) { //0부터 19까지의 정수들 중,
			System.out.printf("#3 - 3 : %d\t", k42_i);  //0부터 19까지 출력하되
			
			if((k42_i + 1) % 5 == 0) { //1부터 20까지의 정수들 중 5로 나눈 나머지가 0이라면
				//0 % 5 (~19) -> 1 % 5 (~20)
				System.out.printf("\n"); //줄바꿈
			}
		}
	}
	
	public static void k42_P4() {
		//반올림 버림 처리
		int k42_n = 12345; //정수형 변수 지정
		int k42_j = (k42_n / 10) * 10; //10의 자리 이하 버림 처리
		/* n / 10 = 1234
		 * 1234 * 10 = 12340
		 */
		System.out.printf("#4 - 1 : %d\n", k42_j);
		
		k42_n = 12345; //초기화
		k42_j = ((k42_n + 5) / 10) * 10; //10의 자리 이하 올림 처리 (+5)
		/*
		 * n + 5 = 12350;
		 * 12350 / 10 = 1235.0
		 * 1235.0 * 10 = 12350
		 */
		System.out.printf("#4 - 2 : %d\n", k42_j);
		
		k42_n = 12344;
		k42_j = ((k42_n + 5) / 10) * 10; //10의 자리 이하 반올림 처리
		/*
		 * n + 5 = 12349
		 * 12349 / 10 * 10 = 12340
		 */
		System.out.printf("#4 - 3 : %d\n", k42_j);
	}

	public static void k42_P5() {
		int k42_val = 14 / 5; //정수형으로 선언되었으나 실수형 결과가 나오는 연산
		
		System.out.printf("#5 - 1 : %d\n", k42_val); //%d로 형태 지정하여 출력
		//정수형 변수이므로 실수 연산 결과는 출력되지 않는다
		
		double k42_valF; //실수형 변수
		
		k42_valF = 14 / 5; //실수형 결과 연산
		System.out.printf("#5 - 2 : %f\n", k42_valF); //%f : 변수형에 주의할 것
		/* 실수형으로 선언된 변수이므로 실수형으로 출력되나
		 * 나눠지는 수 14가 실수형(14.0)으로 선언되지 않았으므로
		 * 소수점 값이 온전히 출력되지 않음
		 */
		
		k42_valF = 14.0 / 5;
		System.out.printf("#5 - 3 : %f\n", k42_valF);
		//위와 달리 나눠지는 수가 14.0으로 주어졌으므로 소수점 값도 온전히 출력됨
		
		k42_valF = (14.0) / 5 + 0.5;
		System.out.printf("#5 - 4 : %f\n", k42_valF);
		//연산 결과에 0.5를 더하는 연산도 정상적으로 처리됨
		
		k42_val = (int)((14.0) / 5 + 0.5); //float를 int형으로 변환한다
		System.out.printf("#5 - 5 : %d\n", k42_val); //%d
		//정수형으로 변환된 값이 출력된다
	}
}




























