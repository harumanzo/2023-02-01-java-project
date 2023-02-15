package com.KoreaIT.java.basicAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.controller.Articlecontroller;
import com.KoreaIT.java.basicAM.controller.Controller;
import com.KoreaIT.java.basicAM.controller.Membercontroller;
import com.KoreaIT.java.basicAM.dto.Article;
import com.KoreaIT.java.basicAM.dto.Member;

public class App extends Controller{
	static List<Article> articles = new ArrayList<>();
	static List<Member> members = new ArrayList<>();

	public void run() {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		Membercontroller membercontroller = new Membercontroller(members, sc);
		Articlecontroller articlecontroller = new Articlecontroller(sc);

		Articlecontroller.maketestdata();
		Membercontroller.makeadminaccount();
		Membercontroller.maketestdata();
		

		while (true) {
			if(loginedmember !=null) {			
				System.out.println("1.로그아웃   2.회원정보   3.회원정보수정   4.회원탈퇴   5.글목록   6.글쓰기   7.프로그램 종료");
				System.out.printf("명령어 )");
				String command = sc.nextLine().trim();

				if (command.length() == 0) {
					System.out.println("명령어를 입력해주세요");
					continue;
				}

				String[] commandBits = command.split(" "); // article detail 1 / member join

				if (commandBits.length == 1) {
					System.out.println("명령어 확인 후 다시 입력해주세요");
					continue;
				}

				String controllerName = commandBits[0];
				String actionMethodName = commandBits[1];

				Controller controller = null;

				if (controllerName.equals("article")) {
					controller = articlecontroller;
				} else if (controllerName.equals("member")) {
					controller = membercontroller;
				} else {
					if (controllerName.equals("system")) {
						if (actionMethodName.equals("exit")) {
							break;
						}else {
							System.out.println("존재하지 않는 명령어 입니다.");
							continue;
						}

					} else {
						System.out.println("존재하지 않는 명령어 입니다.");
						continue;
					}

				}
				controller.doAction(command, actionMethodName);
			}else {
				System.out.println("1.회원가입   2.로그인   3. 글목록   4. 글 정보    5.프로그램 종료");
				System.out.printf("명령어 )");
				String command = sc.nextLine().trim();

				if (command.length() == 0) {
					System.out.println("명령어를 입력해주세요");
					continue;
				}
				
				if(command.equals("1")) {
					command = "member join";
				}

				String[] commandBits = command.split(" "); // article detail 1 / member join

				if (commandBits.length == 1) {
					System.out.println("명령어 확인 후 다시 입력해주세요");
					continue;
				}

				String controllerName = commandBits[0];
				String actionMethodName = commandBits[1];

				Controller controller = null;

				if (controllerName.equals("article")) {
					controller = articlecontroller;
				} else if (controllerName.equals("member")) {
					controller = membercontroller;
				} else {
					if (controllerName.equals("system")) {
						if (actionMethodName.equals("exit")) {
							break;
						}else {
							System.out.println("존재하지 않는 명령어 입니다.");
							continue;
						}

					} else {
						System.out.println("존재하지 않는 명령어 입니다.");
						continue;
					}

				}
				controller.doAction(command, actionMethodName);
			}


		}

		System.out.println("========프로그램 종료========");
		sc.close();
	}

	public void doAction(String command, String actionMethodName) {
		// TODO Auto-generated method stub
		
	}

}
