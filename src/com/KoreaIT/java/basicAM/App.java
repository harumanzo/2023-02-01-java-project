package com.KoreaIT.java.basicAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.controller.Articlecontroller;
import com.KoreaIT.java.basicAM.controller.Controller;
import com.KoreaIT.java.basicAM.controller.Membercontroller;
import com.KoreaIT.java.basicAM.dto.Article;
import com.KoreaIT.java.basicAM.dto.Id;
import com.KoreaIT.java.basicAM.dto.Member;

public class App {
	static List<Article> articles = new ArrayList<>();
	static List<Member> members = new ArrayList<>();
	static List<Id> ids = new ArrayList<>();

	public void run() {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		Membercontroller membercontroller = new Membercontroller(members, sc);
		Articlecontroller articlecontroller = new Articlecontroller();

		Articlecontroller.maketestdata();

		while (true) {

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

		}

		System.out.println("========프로그램 종료========");
		sc.close();
	}

}
