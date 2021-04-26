package sw07;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;

public class TotalPriceCheck {
	static String[] k42_ITEM = 
		{"뽀로로 블루베리 맛 235ml", "[팔도] 뽀로로 보리차 220ml", 
		"피코크 콜롬비아 안티오키아 수프리모 1kg", "프레스코발디 카스틸리오니 끼안티", 
		"피죤 주방세제 퓨어 750ml 애플밤", "피죤 주방세제 퓨어 750ml 버진모히토", 
		"건조기용 피죤 라피에스타 40매", "건조기용 피죤 미스틱레인 40매", "액츠 퍼펙트 베이킹소다 3L+200ml", 
		"액츠 퍼펙트 딥클린 3L+200ml", "[종가집] 묵은지김치1.6kg", "프레스코발디 카스틸리오니 토스카나", 
		"피코크 트루워터 330ml", "맑은누리숨 황사방역 마스크 KF94 (대형)", 
		"오리온 투유 우유초콜릿 60g", "라이프리 안심매트 10p", "[롯데] 허쉬[HERSHEY`S] 미니어처 155g", 
		"(G)피코크 유기농 밤그대로 100g*2입", "[피코크] 트루 스파클링 레몬(500ml×6입)", 
		"[피코크] 트루스파클링 자몽(500ml×6입)", "피코크 핫바베큐치킨300g", 
		"[20년산] 해남쌀이야기10kg(상등급)", "[피코크] 마몰로 녹차트러플 200g", 
		"[피코크] 과일 그래놀라 380g", "[피코크] 버터플라이 새우튀김 400g", 
		"[피코크] 인절미 그래놀라 380g", "피코크 카라멜초코볼 260g", "피코크 리얼화이트 딸기초코볼 170g", 
		"[피코크] 핫앤스파이시 새우튀김 400g", "[리스테린] 구강청결제 후레쉬버스트 750ml"};
	
	//임의로 출력하여 저장한 배열
	static String[] OneRecOrigin = 
		      {"01     뽀로로 블루베리 맛 235ml                          1,200     1       1,200",
			   "02     [팔도] 뽀로로 보리차 220ml                        1,200     2       2,400",
			   "03     피코크 콜롬비아 안티오키아 수프리모 1kg          14,980     3      44,940",
			   "04     프레스코발디 카스틸리오니 끼안티                 22,000     4      88,000",
			   "05     피죤 주방세제 퓨어 750ml 애플밤                   6,500     5      32,500",
			   "06     피죤 주방세제 퓨어 750ml 버진모히토               6,500     1       6,500",
			   "07     건조기용 피죤 라피에스타 40매                     6,500     2      13,000",
			   "08     건조기용 피죤 미스틱레인 40매                     6,500     3      19,500",
			   "09     액츠 퍼펙트 베이킹소다 3L+200ml                   9,900     4      39,600",
			   "10     액츠 퍼펙트 딥클린 3L+200ml                       9,900     5      49,500",
			   "11     [종가집] 묵은지김치1.6kg                         12,900     1      12,900",
			   "12     프레스코발디 카스틸리오니 토스카나               37,000     2      74,000",
			   "13     피코크 트루워터 330ml                             1,680     3       5,040",
			   "14     맑은누리숨 황사방역 마스크 KF94 (대형)            3,500     4      14,000",
			   "15     오리온 투유 우유초콜릿 60g                        8,260     5      41,300",
			   "16     라이프리 안심매트 10p                             2,415     1       2,415",
			   "17     [롯데] 허쉬[HERSHEY`S] 미니어처 155g              3,080     2       6,160",
			   "18*    (G)피코크 유기농 밤그대로 100g*2입                3,486     3      10,458",
			   "19     [피코크] 트루 스파클링 레몬(500ml×6입)           3,570     4      14,280",
			   "20     [피코크] 트루스파클링 자몽(500ml×6입)            3,570     5      17,850",
			   "21     피코크 핫바베큐치킨300g                           3,836     1       3,836",
			   "22*    [20년산] 해남쌀이야기10kg(상등급)                29,800     2      59,600",
			   "23     [피코크] 마몰로 녹차트러플 200g                   4,186     3      12,558",
			   "24     [피코크] 과일 그래놀라 380g                       4,186     4      16,744",
			   "25     [피코크] 버터플라이 새우튀김 400g                 4,186     5      20,930",
			   "26     [피코크] 인절미 그래놀라 380g                     4,186     1       4,186",
			   "27     피코크 카라멜초코볼 260g                          4,886     2       9,772",
			   "28     피코크 리얼화이트 딸기초코볼 170g                 1,000     3       3,000",
			   "29     [피코크] 핫앤스파이시 새우튀김 400g               5,586     4      22,344",
			   "30     [리스테린] 구강청결제 후레쉬버스트 750ml         12,500     5      62,500"};
	static String[] OneRec = 
	      {"01     뽀로로 블루베리 맛 235ml                          1,200     1       1,200",
		   "02     [팔도] 뽀로로 보리차 220ml                        1,200     2       2,400",
		   "03     피코크 콜롬비아 안티오키아 수프리모 1kg          14,980     3      44,940",
		   "04     프레스코발디 카스틸리오니 끼안티                 22,000     4      22,000",
		   "05     피죤 주방세제 퓨어 750ml 애플밤                   6,500     5      32,500",
		   "06     피죤 주방세제 퓨어 750ml 버진모히토               6,500     1       6,500",
		   "07     건조기용 피죤 라피에스타 40매                     6,500     2      13,000",
		   "08     건조기용 피죤 미스틱레인 40매                     6,500     3      19,500",
		   "09     액츠 퍼펙트 베이킹소다 3L+200ml                   9,900     4      39,600",
		   "10     액츠 퍼펙트 딥클린 3L+200ml                       9,900     5      49,500",
		   "11     [종가집] 묵은지김치1.6kg                         12,900     1      12,900",
		   "12     프레스코발디 카스틸리오니 토스카나               37,000     2      74,000",
		   "13     피코크 트루워터 330ml                             1,680     3       5,040",
		   "14     맑은누리숨 황사방역 마스크 KF94 (대형)            3,500     4      14,000",
		   "15     오리온 투유 우유초콜릿 60g                        8,260     5      41,300",
		   "16     라이프리 안심매트 10p                             2,415     1       1,415",
		   "17     [롯데] 허쉬[HERSHEY`S] 미니어처 155g              3,080     2       6,160",
		   "18*    (G)피코크 유기농 밤그대로 100g*2입                3,486     3      12,458",
		   "19     [피코크] 트루 스파클링 레몬(500ml×6입)           3,570     4      14,280",
		   "20     [피코크] 트루스파클링 자몽(500ml×6입)            3,570     5      17,850",
		   "21     피코크 핫바베큐치킨300g                           3,836     1       3,836",
		   "22*    [20년산] 해남쌀이야기10kg(상등급)                29,800     2      59,600",
		   "23     [피코크] 마몰로 녹차트러플 200g                   4,186     3      12,558",
		   "24     [피코크] 과일 그래놀라 380g                       4,186     4      16,744",
		   "25     [피코크] 버터플라이 새우튀김 400g                 4,186     5      19,930",
		   "26     [피코크] 인절미 그래놀라 380g                     4,186     1       4,186",
		   "27     피코크 카라멜초코볼 260g                          4,886     2       9,772",
		   "28     피코크 리얼화이트 딸기초코볼 170g                 1,000     3       3,000",
		   "29     [피코크] 핫앤스파이시 새우튀김 400g               5,586     4      22,344",
		   "30     [리스테린] 구강청결제 후레쉬버스트 750ml         12,500     5      72,500"};
	
	static int[] k42_PRICE = 
		{1200, 1200, 14980, 22000, 6500, 6500, 6500, 6500, 9900, 9900, 
		12900, 37000, 1680, 3500, 8260, 2415, 3080, 3486, 3570, 3570, 
		3836, 29800, 4186, 4186, 4186, 4186, 4886, 1000, 5586, 12500};
		
	static int[] k42_amount = 
		{1,2,3,4,5, //수량 정보 정수형 배열
		1,2,3,4,5,1,2,3,4,5,
		1,2,3,4,5,1,2,3,4,5,
		1,2,3,4,5};
	
	//면세품목 지정을 위한 참, 거짓 배열
	static boolean[] k42_TAXincluded = 
		{true, true, true, true, true, true, 
		true, true, true, true, true, true, 
		true, true, true, true, true, false, 
		true, true, true, false, true, true, 
		true, true, true, true, true, true};
//메인함수			
	public static void main(String[] args) throws UnsupportedEncodingException {
		int[] k42_OneRecPrices = printlist(); //가격 값만을 분리
		for(int k42_i = 0; k42_i <k42_OneRecPrices.length; k42_i++) {
			if(k42_OneRecPrices[k42_i] != (k42_PRICE[k42_i] * k42_amount[k42_i])) { //가격 부분이 원래 가격과 다르다면
				System.out.println("오류[" + OneRec[k42_i] + "]"); //혼합 출력
				System.out.println("수정[" + OneRecOrigin[k42_i] + "]");
				System.out.println("--------------------------------------------------------------------------------------");
			}
		}
	}
	public static int[] printlist() throws UnsupportedEncodingException {
		String[] k42_cut1 = new String[1000]; //split으로 나눈 값을 임시로 저장할 배열
		String[] k42_cut2 = new String[k42_ITEM.length]; //다시 정제한 값을 저장할 배열
		int[] k42_OneRecPrices = new int[k42_ITEM.length]; //값이 저장될 정수형 배열
		int[] k42_sum = new int[k42_ITEM.length]; //합계 저장을 위한 정수 배열
		for(int k42_i = 0; k42_i < k42_ITEM.length; k42_i ++) {
		/*String[] OneRec = new String[k42_ITEM.length];
		OneRec[i] = String.format("%02d", i) + k42_ITEM[i] + k42_PRICE[i] + k42_amount[i] + (k42_PRICE[i] * k42_amount[i]);
		}*/
			k42_sum[k42_i] = k42_PRICE[k42_i] * k42_amount[k42_i];
			/*
			 * if(k42_TAXincluded[k42_i] == false) { //즉 면세품목이라면
			 * System.out.printf("\"%s%-5s%-16s%10s%6d%12s\",\n", String.format("%02d",
			 * k42_i + 1), "*", printBlank(strCut(k42_ITEM[k42_i], 45), 45), //strCut으로 16만큼
			 * 자른 후 공백 채워줌 NumberFormat.getInstance().format(k42_PRICE[k42_i]),
			 * k42_amount[k42_i], NumberFormat.getInstance().format(k42_sum[k42_i])); }
			 * //과세품목 else { System.out.printf("\"%-7s%-16s%10s%6d%12s\",\n",
			 * String.format("%02d", k42_i + 1), printBlank(strCut(k42_ITEM[k42_i], 45),
			 * 45), NumberFormat.getInstance().format(k42_PRICE[k42_i]), k42_amount[k42_i],
			 * NumberFormat.getInstance().format(k42_sum[k42_i])); }
			 */
			k42_cut1 = OneRec[k42_i].split(" "); //공백을 기준으로 분리하여 배열로 저장한다
			k42_cut2[k42_i] = (k42_cut1[k42_cut1.length - 1]).replace(",", ""); //분리된 요소들의 마지막 값만을 별개의 배열에 저장함
			k42_OneRecPrices[k42_i] = Integer.parseInt(k42_cut2[k42_i]); //가격 값이므로 정수형으로 저장
		}
	return k42_OneRecPrices;
	}
	public static String printBlank(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//문자 타입에 따른 공백 수를 저장하기 위한 함수
		//k42_str = 받은 문자열, k42_i = 공백을 포함하여 출력할 문자수
		int k42_strBytes = k42_str.getBytes("MS949").length; //받은 문자열의 byte수를 저장할 변수
		//MS949 인코딩 시 한글 한 문자 당 2Byte
		int k42_blank = 0; //공백 수 추후 지정
			k42_blank = k42_strBytes; //받은 int i 에서 blank의 값을 뺀 만큼 공백 출력
		
		String k42_result = "";
		k42_result += k42_str; //return될 값 result에 받은 문자열 먼저 저장
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //문자열 뒤에 공백 저장
		}
		return k42_result; //처리 후 사용될 문자열
	}
	
	public static String strCut(String k42_str, int k42_length){
		// 문자열을 바이트 단위로 자르기 위한 함수         
		String k42_result = k42_str; //받은 문자열
		int k42_oL = 0, k42_rF = 0, k42_rL = 0;
		try {
			byte[] k42_bytes = k42_result.getBytes("UTF-8"); //바이트로 인코딩하여 배열로 저장
			int k42_j = 0;
			k42_j = k42_rF;
			while(k42_j < k42_bytes.length) { //바이트 길이 내에서
				if((k42_bytes[k42_j] & 0x80) != 0) { //한글 인코딩 대조
					if(k42_oL+2 > k42_length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					k42_oL+=2; k42_rL+=3; k42_j+=3;
					} else {
						if(k42_oL+1 > k42_length) { //지정한 길이를 초과했다면 반복문 탈출
						break;
					} 
					++k42_oL; ++k42_rL; ++k42_j; //1씩 추가한다
					}       
				}       
			k42_result = new String(k42_bytes, k42_rF, k42_rL, "UTF-8");  // charset 옵션 사용 (String class)
		} catch(UnsupportedEncodingException e){  //예외처리
			e.printStackTrace();  //예외 사유, 위치 출력
		} 
		return k42_result;   
	}
}
