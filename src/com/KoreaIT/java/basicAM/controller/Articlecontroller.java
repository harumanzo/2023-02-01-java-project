package com.KoreaIT.java.basicAM.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.basicAM.dto.Article;
import com.KoreaIT.java.basicAM.dto.Member;
import com.KoreaIT.java.basicAM.controller.Membercontroller;

public class Articlecontroller extends Controller {
	static List<Article> articles = new ArrayList<>();

	private String command;
	private String actionMethodName;
	
	public static void maketestdata() {
		articles.add(new Article(1, new Date(), new Date(), 0, "홍길동" , "action", "테스트", "테스트"));
		articles.add(new Article(2, new Date(), new Date(), 0, "홍길순", "method","테스트", "테스트"));
		articles.add(new Article(3, new Date(), new Date(), 0, "홍학범", "naming","테스트", "테스트"));
		System.out.println("테스트 게시글 만들어짐.");

	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;
		
		switch (actionMethodName) {
		case "list":
			dolist();
			break;
			
		case "write":
			dowrite();
			break;
			
		case "delete":
			dosomething(command);
			break;
			
		case "detail":
			dosomething(command);
			break;
			
		case "modify":
			dosomething(command);
			break;
		}		
	}

	public void dolist() {
		if (articles.size() == 0) {
			System.out.println("게시글이 없습니다.");
		} else {
			System.out.println("번호 /  제목  /  조회수  /  작성자");
			for (int i2 = articles.size() - 1; i2 >= 0; i2--) {
				Article articles2 = articles.get(i2);
				System.out.println(articles2.id + "   / " + articles2.command2 + "  /  " + articles2.조회수 +"  /  " +articles2.name);
			}
		}

	}

	public void dowrite() {
		if(loginedmember == null) {
			System.out.println("로그인 후 이용해주십시오");
			return;
		}
		
		Article article1 = articles.get(articles.size()-1);
		int i = article1.id + 1;
		System.out.printf("제목 )");
		Scanner scv = new Scanner(System.in);
		String command2 = scv.nextLine();
		System.out.printf("내용 )");
		String command3 = scv.nextLine();
		Date now = new Date();
		Date update = new Date();
		int 조회수 = 0;
		
		

		Article article = new Article(i, now, update, 조회수,loginedmember.name,loginedmember.membername, command2, command3);
		articles.add(article);
		loginedmember.memberwrite ++;
		System.out.println(i + "번글이 생성되었습니다");

	}

	public void dosomething(String command) {
		String[] arr = command.split(" ");
		if (arr.length < 3) {
			System.out.println("존재하지 않는 명령어입니다");
		} else {
			int n = Integer.parseInt(arr[2]);
			Article foundArticle = null;

			if (articles.size() == 0) {
				System.out.println(n + "번 게시물은 존재하지 않습니다.");
			} else {
				for (int p = 1; p <= articles.size(); p++) {
					Article article3 = articles.get(p - 1);
					if (n == article3.id) {
						foundArticle = article3;
						break;
					}

				}
			}
			if (foundArticle == null) {
				System.out.println(n + "번 게시물은 존재하지 않습니다.");
			} else {
				if (arr[1].equals("detail")) {
					foundArticle.조회수++;
					SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM HH:mm:ss");
					System.out.println("번호 : " + foundArticle.id);
					System.out.println("날짜 : " + formatter.format(foundArticle.now));
					System.out.println("날짜 : " + formatter.format(foundArticle.update));
					System.out.println("작성자 : " + foundArticle.name);
					System.out.println("조회수 : " + foundArticle.조회수);
					System.out.println("제목 : " + foundArticle.command2);
					System.out.println("내용 : " + foundArticle.command3);


				} else if (arr[1].equals("delete")) {
					if(loginedmember == null) {
						System.out.println("로그인 후 이용해주십시오");
						return;
					}else {
						if(loginedmember.name.equals(foundArticle.name)) {
							
						}else if(loginedmember.membername.equals("admin")){
							
						}else {
							System.out.println("작성자 본인이 아닙니다!!!");
							return;
						}
					}
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.id) {
							articles.remove(p - 1);
							System.out.println(n + "번 게시물이 삭제되었습니다.");
							break;
						}

					}
				} else if (arr[1].equals("modify")) {
					if(loginedmember == null) {
						System.out.println("로그인 후 이용해주십시오");
						return;
					}else {
						if(loginedmember.membername.equals(foundArticle.membername)) {
							
						}else if(loginedmember.membername.equals("admin")){
							
						}
						else {
							System.out.println("작성자 본인이 아닙니다!!!");
							return;
						}
					}
					System.out.printf("제목 )");
					Scanner scv = new Scanner(System.in);
					String command2 = scv.nextLine();
					System.out.printf("내용 )");
					String command3 = scv.nextLine();
					Date update = new Date();

					foundArticle.command2 = command2;
					foundArticle.command3 = command3;
					foundArticle.update = update;
					System.out.println(n + "번 게시물이 수정되었습니다.");
				}

			}

		}

	}

}
