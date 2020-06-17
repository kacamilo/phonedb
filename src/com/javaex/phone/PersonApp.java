package com.javaex.phone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) throws IOException {
		PersonDao personDao = new PersonDao();
		List<PersonVo> plist = new ArrayList<PersonVo>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*************************************************");
		System.out.println("*		전화번호 관리 프로그램		*");
		System.out.println("*************************************************");
		
		while (true) {
			System.out.println(" ");
			System.out.println("1. 리스트   2. 등록   3.삭제   4. 검색   5. 종료");
			System.out.println("----------------------------------");

			System.out.print(">메뉴번호: ");
			
			int num = sc.nextInt();
			if (num == 5) {
				System.out.println("<5. 종료>");
				break;
			}
			
			switch (num) {
			case 1: 
				System.out.println("<1. 리스트>");
				plist = personDao.getPersonList();
				
				for(PersonVo vo : plist) {
					vo.showInfo();
				}
				
				break;
				
			case 2:
				
				break;
				
			}
			
		}
			
	}

}
