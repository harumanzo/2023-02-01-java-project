package com.KoreaIT.java.basicAM;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("========프로그램 시작========");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어 )");
			String command = sc.nextLine().trim();

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호 /  제목  /  조회수");
					for (int i2 = articles.size() - 1; i2 >= 0; i2--) {
						Article articles2 = articles.get(i2);
						System.out.println(articles2.i + "   / " + articles2.command2+ "  /  " + articles2.조회수);
					}
				}
			}

			else if (command.equals("article write")) {
				System.out.printf("제목 )");
				Scanner scv = new Scanner(System.in);
				String command2 = scv.nextLine();
				System.out.printf("내용 )");
				String command3 = scv.nextLine();
				Date now = new Date();
				Date update = new Date();
				int 조회수 = 0;

				Article article = new Article(i, now, update, 조회수, command2, command3);
				articles.add(article);
				System.out.println(i + "번글이 생성되었습니다");
				i++;
			}

			else if (command.startsWith("article detail")) {
				String[] arr = command.split(" ");
				int n = Integer.parseInt(arr[2]);
				Article foundArticle = null;

				if (articles.size() == 0) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				} else {
					for (int p = 1; p <= articles.size(); p++) {
						Article article = articles.get(p - 1);
						if (n == article.i) {
							foundArticle = article;
							break;
						} 
					}
				}
				if (foundArticle ==  null) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
							continue;
						}
				foundArticle.조회수 ++;
				SimpleDateFormat formatter = new SimpleDateFormat("YYYY-dd-MM HH:mm:ss");
				System.out.println("번호 : " + foundArticle.i);
				System.out.println("날짜 : " + formatter.format(foundArticle.now));
				System.out.println("날짜 : " + formatter.format(foundArticle.update));
				System.out.println("조회수 : " + foundArticle.조회수);
				System.out.println("제목 : " + foundArticle.command2);
				System.out.println("내용 : " + foundArticle.command3);
			}

			else if (command.startsWith("article delete")) {
				String[] arr = command.split(" ");
				int n = Integer.parseInt(arr[2]);
				Article foundArticle = null;
				if (articles.size() == 0) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				} else {
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.i) {
							foundArticle = article3;
							break;
						} 

						}
					}
					if (foundArticle == null) {
						System.out.println(n + "번 게시물은 존재하지 않습니다.");
						continue;

							}
						
					
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.i) {
							articles.remove(p - 1);
							System.out.println(n + "번 게시물이 삭제되었습니다.");
							break;
						}

					}
				}
			else if (command.startsWith("article modify")) {
				String[] arr = command.split(" ");
				int n = Integer.parseInt(arr[2]);
				Article foundArticle = null;
				if (articles.size() == 0) {
					System.out.println(n + "번 게시물은 존재하지 않습니다.");
				} else {
					for (int p = 1; p <= articles.size(); p++) {
						Article article3 = articles.get(p - 1);
						if (n == article3.i) {
							foundArticle = article3;
							break;
						} 

						}
					}
					if (foundArticle == null) {
						System.out.println(n + "번 게시물은 존재하지 않습니다.");
						continue;

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
				}

			else if (command.equals("system exit")) {
				break;
			}

			else {
				System.out.println("존재하지 않는 명령어입니다");
			}

		}

	System.out.println("========프로그램 종료========");sc.close();
}}

class Article {
	int i;
	Date now;
	Date update;
	int 조회수;
	String command2;
	String command3;

	public Article(int i, Date now, Date update, int 조회수, String command2, String command3) {
		this.i = i;
		this.now = now;
		this.조회수 = 조회수;
		this.command2 = command2;
		this.command3 = command3;

	}

}