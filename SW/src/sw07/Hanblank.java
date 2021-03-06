package sw07;

import java.io.UnsupportedEncodingException;

public class Hanblank {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("한글abcd", 15));
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("한글한글aa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("한글aa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("한글한글aa", 15));
		System.out.printf("한글: %d개\n", HanCount("한글한글aa"));

	}
	public static String printBlankForward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//문자 타입에 따른 공백 수를 저장하기 위한 함수
		//k42_str = 받은 문자열, k42_i = 공백을 포함하여 출력할 문자수
		int k42_strBytes = k42_str.getBytes("MS949").length; //받은 문자열의 byte수를 저장할 변수
		//MS949 인코딩 시 한글 한 문자 당 2Byte
		int k42_blank = 0; //공백 수 추후 지정
			k42_blank = k42_strBytes; //받은 int i 에서 blank의 값을 뺀 만큼 공백 출력
		
		String k42_result = "";
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //문자열 앞에 공백 저장
		}
		k42_result += k42_str; //return될 값 result에 받은 문자열 저장
		return k42_result; //처리 후 사용될 문자열
	}
	public static String printBlankBackward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//문자 타입에 따른 공백 수를 저장하기 위한 함수
		//k42_str = 받은 문자열, k42_i = 공백을 포함하여 출력할 문자수
		int k42_strBytes = k42_str.getBytes("MS949").length; //받은 문자열의 byte수를 저장할 변수
		//MS949 인코딩 시 한글 한 문자 당 2Byte
		int k42_blank = 0; //공백 수 추후 지정
			k42_blank = k42_strBytes; //받은 int i 에서 blank의 값을 뺀 만큼 공백 출력
		
		String k42_result = "";
		k42_result = k42_str; //return될 값 result에 받은 문자열 먼저 저장
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //문자열 뒤에 공백 저장
		}
		return k42_result; //처리 후 사용될 문자열
	}
	public static int HanCount(String k42_str) {
		int k42_cnt = 0; //한글의 개수를 저장할 변수
		for(int k42_i = 0; k42_i < k42_str.length(); k42_i ++) //받은 문자열의 길이 안에서
			if(String.valueOf(k42_str.charAt(k42_i)).matches((".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"))) {
				k42_cnt++; //문자 하나씩 검사하여 한글 정규식과 일치할 경우 카운트한다
			}
		return k42_cnt; //총 개수 반환
	}
}
