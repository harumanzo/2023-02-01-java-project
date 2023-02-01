package com.KoreaIT.java.basicAM;

import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		
		while (true){
			System.out.printf("명령어 )");
			String command = sc.nextLine();
			
			
			if (command.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			}
			
			else if (command.equals("article write")) {
				System.out.printf("제목 )");
				Scanner scv = new Scanner(System.in);
				String command2 = scv.nextLine();
				System.out.printf("내용 )");
				String command3 = scv.nextLine();
				System.out.println(i+"번글이 생성되었습니다");
				i++;
			}
			
			
			else if (command.equals("system exit")) {
				break;
			}
			
			else {
				System.out.println("존재하지 않는 명령어입니다");
			}
			
		}
		
		System.out.println("========프로그램 종료========");
		sc.close();
	}
}
