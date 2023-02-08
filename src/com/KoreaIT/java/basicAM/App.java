package com.KoreaIT.java.basicAM;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.controller.Articlecontroller;
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

			if (command.equals("member join")) {
				membercontroller.dojoin(sc);
			}

			else if (command.equals("article list")) {
				articlecontroller.dolist();

			} else if (command.equals("article write")) {
				articlecontroller.dowrite();

			}

			else if (command.startsWith("article")) {
				articlecontroller.dosomething(command);

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
