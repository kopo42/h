package sw08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {
	public static void FileWrite() throws IOException {
		File k42_f = new File("c:\\Users\\J\\Mytest2.txt"); //경로, 파일명
		BufferedWriter k42_bw = new BufferedWriter(new FileWriter(k42_f)); //파일 쓰기 buffered 객체 생성
		
		k42_bw.write("Writing a file"); //입력할 내용
		k42_bw.newLine(); //줄바꿈
		k42_bw.write("Hello");
		k42_bw.newLine();
		
		k42_bw.close(); //파일 쓰기 닫기
	}
	
	public static void FileRead() throws IOException {
		File k42_f = new File("c:\\Users\\J\\Mytest2.txt");
		BufferedReader k42_br = new BufferedReader(new FileReader(k42_f)); //파일 읽기 객체 생성
		
		String k42_readtxt; //br로 읽어들인 파일 내용을 저장할 변수
		
		while((k42_readtxt = k42_br.readLine()) != null) { //파일 내용이 계속 존재할 경우
			System.out.printf("%s\n", k42_readtxt); //readtxt에 저장한 파일 내용 출력
		}
		k42_br.close(); //파일 읽기 닫기
	}

	public static void main(String[] args) throws IOException { //메인함수에서 실행
		FileWrite();
		FileRead();
		//예외처리 요구 (throws IOException)
	}
}
