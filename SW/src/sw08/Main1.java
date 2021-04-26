package sw08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
	public static void main(String[] args) {
		try {
			File k42_f = new File("c:\\Users\\J\\Mytest.txt"); //파일을 저장할 경로
			FileWriter k42_fw = new FileWriter(k42_f); //파일 쓰기: FileWrtier 객체를 생성하여 사용한다
			//괄호 안: 파일 경로, 이름
			//Mytest.txt에 저장될 내용
			k42_fw.write("Hello"); 
			k42_fw.write("안녕");
			//fw 객체 사용시 에디터에서 자동으로 exception 처리를 요구함
			
			k42_fw.close(); //컴파일이 잘 되더라도 오류 방지를 위해 close함
			
			FileReader k42_fr = new FileReader(k42_f); //파일을 읽는 개체
			//괄호 안: 파일 경로, 이름
			
			int k42_n = -1; //음의 정수
			char [] k42_ch; //문자 배열
			
			while(true){ //무한 반복
				k42_ch = new char[100]; //크기가 100인 문자 배열
				k42_n = k42_fr.read(k42_ch);
				//읽어들인 문자 수 반환
				//파일 끝: -1 반환
				/*
			     * Reads characters into an array.  This method will block until some input
			     * is available, an I/O error occurs, or the end of the stream is reached.
			     *
			     * @param       cbuf  Destination buffer
			     *
			     * @return      The number of characters read, or -1
			     *              if the end of the stream
			     *              has been reached
			     *
			     * @throws      IOException  If an I/O error occurs
			     */
				//파일 끝에 도달했을 경우 반복문 종료
				if(k42_n == -1) break;
				
				for(int k42_i = 0; k42_i < k42_n; k42_i++) { //읽어들인 문자의 수 만큼 반복
					System.out.printf("%c", k42_ch[k42_i]); //문자 배열의 내용 출력
				}
			}
			k42_fr.close(); //파일 읽기 종료
			System.out.println("\nFILE READ END");
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); //에러 발생시 내용, 위치 출력
		}
	}
}
