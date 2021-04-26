package sw03;

public class main2 {
	public static int k42_netprice(int k42_price, double k42_rate) { //소비자가 계산하기
		return (int)(k42_price / (1 + k42_rate)); // x(y + 1) = xy + x
	}
	public static void main(String[] args) { //메인 함수
		String [] k42_item = {"꼬북칩", "오감자", "초코칩", "고래밥", "치토스"}; //제품명을 string 배열에 저장
		int[] k42_price = {1500, 1500, 2400, 1200, 2000};  //가격을 int 배열에 저장
		int[] k42_amount = {10, 2, 1, 3, 5}; //수량을 int 배열에 저장
		double k42_tax_rate = 0.1; //세율 10%
		int k42_total_sum = 0; //합계를 저장할 변수 선언
		
		System.out.printf("******************************\n");
		System.out.printf("*            제품명            *\n");
		System.out.printf(" 항목      단가   수량      합계   \n");
		
		for(int i = 0; i < k42_item.length; i++) { //제품명 배열의 길이만큼 반복
			int sum = k42_price[i] * k42_amount[i]; //합계 = 제품명 항목 * 수량 항목
			k42_total_sum = k42_total_sum + sum; //합계 = 거듭하여 더하기 누적
			System.out.printf("%.5s  %7d  %2d  %9d\n", k42_item[i], k42_price[i], k42_amount[i], sum); //배열의 i번째 항을 반복하여 출력
		}
		System.out.printf("******************************\n");
		System.out.printf("지불금액 :%20d\n", k42_total_sum); //지불금액의 자리수 지정하여 출력하기
		
		int total_net_price = (int)(k42_total_sum / (1 + k42_tax_rate)); //소비자가 구하기
		System.out.printf("과세금액 :%20d\n", total_net_price); //소비자가의 자리수 지정하여 출력하기
		int tax = k42_total_sum - total_net_price; //세금 = 합계 - 소비자가
		System.out.printf("   세금 :%20d\n", tax); //세금의 자리수 지정하여 출력하기
	}
}
